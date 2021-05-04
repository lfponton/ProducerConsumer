public class Controller implements Runnable
{
  private AirportQueue airportQueue;
  private String nationality;

  public Controller(AirportQueue airportQueue, String nationality)
  {
    this.airportQueue = airportQueue;
    this.nationality = nationality;
  }

  @Override public void run()
  {
    while(true) {

      if ("US".equals(nationality))
      {
        airportQueue.getNextUSPassenger();
      }
      else
      {
        airportQueue.getNextNonUSPassenger();
      }

    }
  }
}
