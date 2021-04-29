public class Test
{
  public static void main(String[] args)
  {
    BlockingQueue queue = new BlockingQueue(2);

    while (true)
    {
      Thread p1 = new Thread(() -> queue.put("A"));
      Thread p2 = new Thread(() -> queue.put("B"));
      Thread p3 = new Thread(() -> queue.put("C"));
      Thread c1 = new Thread(() -> queue.take());
      Thread c2 = new Thread(() -> queue.take());
      Thread c3 = new Thread(() -> queue.take());

      p1.start();
      p2.start();
      p3.start();
      c1.start();
      c2.start();
      c3.start();
    }
  }
}
