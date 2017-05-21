/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wise;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.Locale;
import java.util.ResourceBundle;
import org.json.JSONException;
import twitter4j.GeoLocation;
import twitter4j.Query;
import twitter4j.QueryResult;
import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.URLEntity;
import twitter4j.conf.ConfigurationBuilder;

/**
 *
 * @author MUHARREM
 */
public class TwitterUtils {

    public ArrayList<CheckinObject> dataList(String cityCode, String selectedDate, String maxTweetParam, String topTweetParam) throws IOException, JSONException, ParseException{
        ArrayList<CheckinObject> checkinList = new ArrayList<>();
        
        ConfigurationBuilder cb = new ConfigurationBuilder();
        cb.setDebugEnabled(true)
          .setOAuthConsumerKey(Constants.CONSUMER_KEY)
          .setOAuthConsumerSecret(Constants.CONSUMER_SECRET)
          .setOAuthAccessToken(Constants.TOKEN)
          .setOAuthAccessTokenSecret(Constants.TOKEN_SECRET);
        
        
        Integer maxTweet = Integer.parseInt(maxTweetParam);
        Integer topTweet = Integer.parseInt(topTweetParam);
        
        TwitterFactory tf = new TwitterFactory(cb.build());
        Twitter twitter = tf.getInstance();
        
        DateFormat format = new SimpleDateFormat("MM/dd/yyyy", Locale.ENGLISH);
        
        
        Date startDate = format.parse(selectedDate);
        
        Calendar c = Calendar.getInstance(); 
        c.setTime(startDate); 
        c.add(Calendar.DATE, 1);
        Date endDate = c.getTime();
        
        Query query = SetQueryString(cityCode, startDate, endDate);
        
        QueryResult result = null;       
        try {
            while(query != null && checkinList.size() <= maxTweet){           
                result = twitter.search(query);
                if(result != null)
                {
                    for (Status status : result.getTweets()) 
                    {
                        
                        for (URLEntity urlEntity :status.getURLEntities()) 
                        {
                            String urlCheckinId = urlEntity.getExpandedURL().substring(urlEntity.getExpandedURL().lastIndexOf("/") + 1);
                            GeoLocation geo = status.getGeoLocation();
                            
                            CheckinObject checkin = new CheckinObject();
                            checkin.CheckinId = urlCheckinId;
                            checkin.Count = 1;//status.getRetweetCount() + status.getFavoriteCount() + 1;
                            checkin.Latitude = geo.getLatitude();
                            checkin.Longitude = geo.getLongitude();
                            
                            if (!checkin.containsSameCoordinates(checkinList, checkin.Latitude, checkin.Longitude)) {
                                 checkinList.add(checkin);
                            }
                            else {
                                int indexOfCheckinId = checkin.getIndexByCoordinates(checkinList, checkin.Latitude, checkin.Longitude);
                                checkinList.get(indexOfCheckinId).setCheckinCount(checkin.Count);  
                                checkinList.get(indexOfCheckinId).setReplacementCheckinId(checkin.CheckinId);  
                            }
                        }
                    }
                                           
                   query = result.nextQuery();
                }
                else    
                {
                    query = null;
                }    
            }
            
        } catch (TwitterException e) {
        }
               
        Collections.sort(checkinList, new CountComparator());
       
        if (checkinList.size() > topTweet) {
            checkinList.subList(topTweet, checkinList.size()).clear(); // get top x
        }
          
        FourSquareCheckin fsq = new FourSquareCheckin();
        
        for (CheckinObject checkin : checkinList) 
        {
            fsq = getVenueInfo(checkin);
            checkin.LocationName = fsq.VenueName;
            checkin.Image = fsq.VenueImage;
        }
               
        return checkinList;
    }
       
    public static Query SetQueryString(String place, Date since, Date until){
        Query query = new Query("place:" + place + "url:swarmapp.com");           
        String startDate = new SimpleDateFormat("yyyy-MM-dd").format(since);
        String endDate = new SimpleDateFormat("yyyy-MM-dd").format(until);
        query.setCount(100);
        query.setSince(startDate);
        query.setUntil(endDate);
        query.setSinceId(0);
        return query;
    }    
    
    public FourSquareCheckin getVenueInfo(CheckinObject checkin) throws IOException, JSONException {
        FourSquareCheckin fsq = new FourSquareCheckin();
        fsq = fsq.GetVenueInfoByCheckinId(checkin.CheckinId); 
        
        if (fsq.VenueImage != null && fsq.VenueName != null) 
        {
            return fsq;
        }
        else 
        {
            if (checkin.SecondaryCheckinId != null) 
            {
                fsq = fsq.GetVenueInfoByCheckinId(checkin.SecondaryCheckinId); 
                if (fsq.VenueImage != null && fsq.VenueName != null) 
                {
                    return fsq;
                }
                else
                {
                    if (checkin.TertiaryCheckinId != null) 
                    {
                        fsq = fsq.GetVenueInfoByCheckinId(checkin.TertiaryCheckinId);  
                        if (fsq.VenueImage != null && fsq.VenueName != null) 
                        {
                            return fsq;
                        }
                    }
                }
            }
        }
        if (fsq.VenueImage == null) {
            fsq.VenueImage = "";
        }
        if (fsq.VenueName == null) {
            fsq.VenueName = "";
        }
        return fsq;
    }
   
}