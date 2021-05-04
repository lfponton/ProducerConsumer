import java.util.LinkedList;
import java.util.Queue;

public class CarrotBunch
{
  private int whenToStartPeeling;
  private int whenToStopPeeling;
  private Queue<Carrot> carrots = new LinkedList<>();

  public CarrotBunch(int start, int stop)
  {
    whenToStartPeeling = start;
    whenToStopPeeling = stop;
  }

  public synchronized void peel(Carrot carrot)
  {
    while(carrots.size() == whenToStopPeeling)
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
    carrots.add(carrot);
    System.out.println("Added a carrot. There are " + carrots.size());
    notifyAll();
  }

  public synchronized Carrot eat()
  {
    while (carrots.isEmpty())
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
    System.out.println("Carrot is removed. There are " + carrots.size());
    notifyAll();
    return carrots.remove();
  }

  public synchronized int getSize()
  {
    return carrots.size();
  }

  public synchronized int getWhenToStopPeeling()
  {
    return whenToStopPeeling;
  }

  public synchronized int getWhenToStartPeeling()
  {
    return whenToStartPeeling;
  }

}
