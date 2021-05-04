import java.util.Random;

public class Guide implements Runnable
{
  private AirportQueue airportQueue;

  public Guide(AirportQueue airportQueue)
  {
    this.airportQueue = airportQueue;
  }

  @Override public void run()
  {
    while (true)
    {
      airportQueue.putPassengerInQueue(passangerAppears());
      try
      {
        Thread.sleep(1000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
  }

  private Passenger passangerAppears() {
    Random rand = new Random();
    int id = rand.nextInt(100);
    String nationality = "";
    if (id % 2 == 0)
    {
      nationality = "US";
    }
    else
    {
      nationality = "non-US";
    }

    return new Passenger(nationality, id);
  }
}
