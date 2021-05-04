import java.util.LinkedList;
import java.util.Queue;

public class AirportQueue implements PassengerQueue
{
  private Queue<Passenger> passengersUS = new LinkedList<>();
  private Queue<Passenger> passengersNonUS = new LinkedList<>();

  @Override public synchronized void putPassengerInQueue(Passenger passenger)
  {
    if ("US".equals(passenger.getNationality()))
    {
      passengersUS.add(passenger);
      System.out.println("Guide: Passenger added to the US queue");

    }
    else
    {
      passengersNonUS.add(passenger);
      System.out.println("Guide: Passenger added to the Non US queue");
    }
    notifyAll();
  }

  @Override public synchronized Passenger getNextUSPassenger()
  {
    while (passengersUS.isEmpty())
    {
      try
      {

        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    Passenger passenger = passengersUS.remove();
    notifyAll();
    System.out.println("Non US Controller: Passenger's passport number is "
        + passenger.getPassportNumber());
    return passenger;
  }

  @Override public synchronized Passenger getNextNonUSPassenger()
  {
    while (passengersNonUS.isEmpty())
    {
      try
      {
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    Passenger passenger = passengersNonUS.remove();
    notifyAll();
    System.out.println("Non US Controller: Passenger's passport number is "
        + passenger.getPassportNumber());
    return passenger;
  }
}
