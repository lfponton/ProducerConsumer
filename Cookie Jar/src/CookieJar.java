import java.util.LinkedList;
import java.util.Queue;

public class CookieJar
{
  private Queue<Cookie> cookieJar = new LinkedList<>();
  private int numberOfCookies;
  private int whenToStartBaking;

  public CookieJar(int numberOfCookies, int whenToStartBaking)
  {
    this.numberOfCookies = numberOfCookies;
    this.whenToStartBaking = whenToStartBaking;
  }

  public synchronized void startBaking(String type)
  {
    System.out.println("Baker starts baking.");
      for (int i = 0; i < numberOfCookies; i++)
      {
        cookieJar.add(new Cookie(type));
      }
    System.out.println("Cooked a batch of " + type + " cookies.");
      finishedBaking();

  }

  public synchronized void finishedBaking()
  {
    while (cookieJar.size() >= whenToStartBaking)
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
    notifyAll();
  }

  public synchronized Cookie eat() {
    while (cookieJar.isEmpty())
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
    Cookie cookie = cookieJar.remove();
    System.out.println("Eater ate a " + cookie.toString() +". There are " + cookieJar.size() + " left.");
    notifyAll();
    return cookie;
  }

  public int getSize()
  {
    return cookieJar.size();
  }
}
