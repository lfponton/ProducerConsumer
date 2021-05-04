public class CarrotPeeler implements Runnable
{
  private CarrotBunch carrots;

  public CarrotPeeler(CarrotBunch carrots)
  {
    this.carrots = carrots;
  }

  @Override public void run()
  {
    while (true)
    {
        for (int i = 0; i < carrots.getWhenToStopPeeling(); i++)
        {
          carrots.peel(new Carrot(carrots.getSize()));
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
  }
}
