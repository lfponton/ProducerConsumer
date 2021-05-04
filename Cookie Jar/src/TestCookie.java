public class TestCookie
{
  public static void main(String[] args)
  {
    CookieJar cookieJar = new CookieJar(16, 5);
    Thread baker = new Thread(new CookieBaker(cookieJar));
    baker.start();
    for (int i = 0; i < 6; i++)
    {
      Thread eater = new Thread(new CookieEater(cookieJar));
      eater.start();
    }
  }
}
