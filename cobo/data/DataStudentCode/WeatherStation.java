/*
Team Phonebooth :: Yat Long Chan, Weichen Liu, Kevin Cheng
APCS
LAB08 -- America's Next Top Data Scientist
2022-04-05
time spent: 1 hour
*/

/*
 Represents information about a NWS weather station
*/

public class WeatherStation {
   private String name;
   private String id;
   private String state;
   private double lat;
   private double lng;
   
   WeatherStation(String name, String id, String state, double lat, double lng) {
      this.name = name;
      this.id = id;
      this.lat = lat;
      this.lng = lng;
      this.state = state;   
   }
   
   /* Produce the id of this station */
   public String getId() { 
      return id;
   }

   public double getLat() {
      return lat;
   }
   
   /* Produce the name of this station */
   public String getName() { 
      return name;
   }
   
   /* Determine if this weather station is located in the given state */
   public boolean isLocatedInState(String st) {
      return this.state.equals(st);
   }
   
}