/*
Team Phonebooth :: Yat Long Chan, Weichen Liu, Kevin Cheng
APCS
LAB08 -- America's Next Top Data Scientist
2022-04-05
time spent: 1 hour
*/

/*
 * Arrays of objects
 */

import core.data.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Welcome03_List {
   public static void main(String[] args) {
      DataSource ds = DataSource.connect("http://weather.gov/xml/current_obs/index.xml").load();
      ArrayList<WeatherStation> allstns = ds.fetchList("WeatherStation", "station/station_name", 
             "station/station_id", "station/state",
             "station/latitude", "station/longitude");
      System.out.println("Total stations: " + allstns.size());
      
      Scanner sc = new Scanner(System.in);
      System.out.println("Enter a state abbreviation: ");
      String state = sc.next();
      System.out.println("Stations in " + state);
      for (WeatherStation ws : allstns) {
         if (ws.isLocatedInState(state)) {
            System.out.println("  " + ws.getId() + ": " + ws.getName());
         }
      }

   double lowest = allstns.get(0).getLat();
      String name = allstns.get(0).getName();

      for (WeatherStation ws : allstns) {
         double lat = ws.getLat();

         if (lat > 0 && lat <= lowest) {
            lowest = lat;
            name = ws.getName();
         } else if (lat < 0 && lat <= lowest) {
            lowest = lat;
            name = ws.getName();
         }
      }
         System.out.println("The southern most weeather station is " + name);

   }
}