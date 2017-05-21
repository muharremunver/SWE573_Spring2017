/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unittest;

import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Test;
import wise.CheckinObject;

/**
 *
 * @author MUHARREM
 */
public class UnitTests {
    
    public UnitTests() {
    }  
        @Test
        public void controlOfNonEmptyListContainsCoordinates() {
                CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 14.444;
                chk.Longitude = 15.666;
                checkinList.add(chk);
                
                Assert.assertTrue(tester.containsSameCoordinates(checkinList, 14.444, 15.666));
          
        }
        
        @Test
        public void controlOfEmptyListDoesNotContainCoordinates() {
                CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                Assert.assertFalse(tester.containsSameCoordinates(checkinList, 14.444, 15.666));
          
        }
        
        @Test
        public void controlOfNonEmptyListDoesNotContainCoordinatesWithDifferentLatitude() {
                CheckinObject tester = new CheckinObject();

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 14.444;
                chk.Longitude = 15.666;
                checkinList.add(chk);
                
                Assert.assertFalse(tester.containsSameCoordinates(checkinList, 11.333, 15.666));         
        }
        
        @Test
        public void controlOfListDoesNotContainCoordinatesWithNonEmptyListWithDifferentLongitude() {
                CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 14.444;
                chk.Longitude = 15.666;
                checkinList.add(chk);
                
                Assert.assertFalse(tester.containsSameCoordinates(checkinList, 14.444, 19.323));         
        }
        
        @Test
        public void controlOfNonEmptyListDoesNotContainCoordinatesWithDifferentLatitudeAndLongitude() {
                CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 12.4332;
                chk.Longitude = 12.66634;
                checkinList.add(chk);
                
                Assert.assertFalse(tester.containsSameCoordinates(checkinList, 14.444, 19.323));         
        }
        
        
        
        @Test
        public void controlOfCheckinIndexInNonEmptyList() {
            CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                
                CheckinObject chk1 = new CheckinObject();
                chk1.Latitude = 20;
                chk1.Longitude = 20;
                checkinList.add(chk1);
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 10;
                chk.Longitude = 10;
                checkinList.add(chk);
                
                Assert.assertEquals(1, (long)tester.getIndexByCoordinates(checkinList, 10, 10));                
        }
        
        @Test
        public void controlOfCheckinIndexInEmptyList() {
            CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                               
                Assert.assertEquals(-1, (long)tester.getIndexByCoordinates(checkinList, 10, 10));                
        }
        
        @Test
        public void controlOfCheckinIndexInNonEmptyListWithDifferentLatitude() {
            CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                
                CheckinObject chk1 = new CheckinObject();
                chk1.Latitude = 20;
                chk1.Longitude = 20;
                checkinList.add(chk1);
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 55;
                chk.Longitude = 10;
                checkinList.add(chk);
                
                Assert.assertEquals(-1, (long)tester.getIndexByCoordinates(checkinList, 10, 10));                
        }
        
        @Test
        public void controlOfCheckinIndexInNonEmptyListWithDifferentLongitude() {
            CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                
                CheckinObject chk1 = new CheckinObject();
                chk1.Latitude = 20;
                chk1.Longitude = 20;
                checkinList.add(chk1);
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 10;
                chk.Longitude = 20;
                checkinList.add(chk);
                
                Assert.assertEquals(-1, (long)tester.getIndexByCoordinates(checkinList, 10, 10));                
        }
        
        @Test
        public void controlOfCheckinIndexNotInNonEmptyList() {
            CheckinObject tester = new CheckinObject(); 

                ArrayList<CheckinObject> checkinList = new ArrayList<>();
                
                CheckinObject chk = new CheckinObject();
                chk.Latitude = 10;
                chk.Longitude = 10;
                checkinList.add(chk);
                
                Assert.assertEquals(-1, (long)tester.getIndexByCoordinates(checkinList, 55, 230));                
        }
}
