public class TestAirport
{
  public static void main(String[] args)
  {
    AirportQueue airportQueue = new AirportQueue();
    Thread guide = new Thread(new Guide(airportQueue));
    Thread controllerUS = new Thread(new Controller(airportQueue, "US"));
    Thread controllerNonUS = new Thread(new Controller(airportQueue, "Non-US"));
    guide.start();
    controllerUS.start();
    controllerNonUS.start();
  }
}
