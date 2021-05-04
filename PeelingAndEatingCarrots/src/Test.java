public class Test
{
  public static void main(String[] args) throws InterruptedException
  {
    BlockingQueue queue = new BlockingQueue(20);
    Thread peeler = new Thread(new CarrotPeeler(queue));
    peeler.start();

    for (int i = 0; i < 20; i++)
    {
      Thread eater = new Thread(new CarrotEater(queue));
      eater.start();
    }
  }
}
