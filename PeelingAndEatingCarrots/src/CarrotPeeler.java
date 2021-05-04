public class CarrotPeeler implements Runnable
{
  private BlockingQueue queue;

  public CarrotPeeler(BlockingQueue queue)
  {
    this.queue = queue;
  }

  @Override public void run()
  {

    while (true)
    {
        queue.put(new Carrot(queue.size()));
        System.out.println("Carrot peeler is peeling a carrot.");

        try
        {
          Thread.sleep(1000);
          System.out.println("Carrot" + queue.size() + " peeled.");
        }
        catch (InterruptedException e)
        {
          e.printStackTrace();

        }
    }
  }
}


