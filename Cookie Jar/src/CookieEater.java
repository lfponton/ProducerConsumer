public class CookieEater implements Runnable
{
  private CookieJar cookieJar;

  public CookieEater(CookieJar cookieJar)
  {
    this.cookieJar = cookieJar;
  }

  @Override public void run()
  {
    while (true)
    {
      cookieJar.eat();
      try
      {
        Thread.sleep(3000);
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }

  }
}
