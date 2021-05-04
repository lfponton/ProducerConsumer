public class CookieBaker implements Runnable
{
  private CookieJar cookieJar;

  public CookieBaker(CookieJar cookieJar) {
    this.cookieJar = cookieJar;
  }

  @Override public void run()
  {
    while (true)
    {
      cookieJar.startBaking("Chocolate");
    }
  }
}
