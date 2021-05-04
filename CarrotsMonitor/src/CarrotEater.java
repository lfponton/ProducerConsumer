public class CarrotEater implements Runnable
{
  private CarrotBunch carrots;
  public CarrotEater(CarrotBunch carrots)
  {
    this.carrots = carrots;
  }

  @Override public void run()
  {
    while (true)
    {
      while (carrots.getSize() == carrots.getWhenToStopPeeling())
      {
        carrots.eat();

        try
        {
          Thread.sleep(4000);
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
    }
  }
}
