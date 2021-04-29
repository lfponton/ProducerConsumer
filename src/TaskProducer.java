import java.util.Random;

public class TaskProducer implements Runnable
{
  private BlockingQueue queue;
  private String name;

  public TaskProducer(BlockingQueue queue, int id)
  {
    this.queue = queue;
    name = "Producer " + id;
  }

  @Override public void run()
  {
    Random rand = new Random();

    while (true)
    {
      int a = rand.nextInt(100); // [0,99]
      int b = rand.nextInt(100); // [0,99]
      Task t = new Task(a, b);
      queue.add(t);
      System.out.println(name + " added task " + " (" + a + ", " + b + ")");
    }
  }
}
