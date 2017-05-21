/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package wise;


import java.util.ArrayList;
import java.util.Comparator;

/**
 *
 * @author MUHARREM
 */
public class CheckinObject {
    public String CheckinId;
    public String SecondaryCheckinId;
    public String TertiaryCheckinId;
    public String LocationName;
    public Integer Count;
    public double Latitude;
    public double Longitude;
    public String Image;
    public String VenueId;
    
    public boolean containsSameCoordinates(ArrayList<CheckinObject> checkinList, double latitude, double longitude) {
        for(CheckinObject o : checkinList) {
            if(o != null && o.Latitude == latitude && o.Longitude == longitude) {
                return true;
            }
        }
        return false;
    }
    
    public Integer getIndexByCoordinates(ArrayList<CheckinObject> checkinList, double latitude, double longitude){
        for (CheckinObject checkin: checkinList) {
            if (checkin.Latitude == latitude && checkin.Longitude == longitude) {
                return checkinList.indexOf(checkin);
            }
        }
        return -1;
    }
    
    public boolean setCheckinCount(Integer count)
    {
        this.Count += count;
        return true;
    }        

    public boolean setReplacementCheckinId(String checkinId)
    {
        if (this.SecondaryCheckinId == null) {
            this.SecondaryCheckinId = checkinId;
        }
        else if (this.TertiaryCheckinId == null) {
            this.TertiaryCheckinId = checkinId;
        }
        return true;
    }    
}
    
    class CountComparator implements Comparator<CheckinObject> {
    @Override
    public int compare(CheckinObject a, CheckinObject b) {
        return a.Count > b.Count ? -1 : a.Count == b.Count ? 0 : 1;
    }
}
