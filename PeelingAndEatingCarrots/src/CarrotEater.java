public class CarrotEater implements Runnable
{
  private BlockingQueue queue;

  public CarrotEater(BlockingQueue queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {
    while (true)
    {
      System.out.println("Carrot Eater is trying to eat a carrot.");
        queue.take();
        try
        {
          Thread.sleep(4000);
          System.out.println("Carrot Eater ate a carrot.");
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();
        }
      }
  }
}
