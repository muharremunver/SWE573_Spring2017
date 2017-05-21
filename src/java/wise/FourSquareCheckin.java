/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wise;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 *
 * @author MUHARREM
 */
public class FourSquareCheckin {
    public String VenueName;
    public String VenueImage;
    
    
    public FourSquareCheckin GetVenueInfoByCheckinId(String checkinId) throws IOException, JSONException{
        String token = "3KYLDHFMOFUJYX4U0CYWOFFUQJZANOSVB44YD2JVDKMHIFDA";
        FourSquareCheckin retVal = new FourSquareCheckin();
        
        URL url = new URL("https://api.foursquare.com/v2/checkins/resolve?shortId=" + checkinId + "&oauth_token=" + token + "&v=20170429");
        URLConnection uc = url.openConnection();
        String venueName;
        String venueId;
        String venueImage;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"))) {
            String inputLine;
            inputLine = in.readLine();
            JSONObject jsonObject = new JSONObject(inputLine);
            venueName = null;
            if (jsonObject.getJSONObject("response") != null) {
                if (jsonObject.getJSONObject("response").getJSONObject("checkin") != null) {
                    if (jsonObject.getJSONObject("response").getJSONObject("checkin").getJSONObject("venue") != null) {
                        venueName = jsonObject.getJSONObject("response").getJSONObject("checkin").getJSONObject("venue").getString("name");
                        venueId = jsonObject.getJSONObject("response").getJSONObject("checkin").getJSONObject("venue").getString("id");
                        venueImage = GetLocationPhotoByVenueId(venueId);
                        retVal.VenueName = venueName;
                        retVal.VenueImage = venueImage;
                    }
                }
            }
        }
      
        catch(Exception ex){
              return retVal;
        }      
          return retVal;
    }
    
    public String GetLocationPhotoByVenueId(String venueId) throws IOException, JSONException{
        String token = "3KYLDHFMOFUJYX4U0CYWOFFUQJZANOSVB44YD2JVDKMHIFDA";
        
        URL url = new URL("https://api.foursquare.com/v2/venues/" + venueId + "/photos?&oauth_token=" + token + "&v=20170429");
        URLConnection uc = url.openConnection();
        String venueImageName;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(uc.getInputStream(),"UTF-8"))) {
            String inputLine;
            inputLine = in.readLine();
            JSONObject jsonObject = new JSONObject(inputLine);
            venueImageName = null;
            if (jsonObject.getJSONObject("response") != null) {
                if (jsonObject.getJSONObject("response").getJSONObject("photos") != null) {
                    if (jsonObject.getJSONObject("response").getJSONObject("photos").getJSONArray("items") != null) {
                        JSONArray items = jsonObject.getJSONObject("response").getJSONObject("photos").getJSONArray("items");
                        String firstPartofUrl = items.getJSONObject(0).getString("prefix");
                        String secondPartofUrl = items.getJSONObject(0).getString("suffix");
                        venueImageName = firstPartofUrl + "300x150" + secondPartofUrl;
                    }                    
                }
            }
        }
        catch(Exception ex){
            return "FourSquare response error";
        }      
        return venueImageName;
    }
    
    
    
    
}
