public interface PassengerQueue
{
  void putPassengerInQueue(Passenger passenger);
  Passenger getNextUSPassenger();
  Passenger getNextNonUSPassenger();
}
