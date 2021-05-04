public class TestCarrots
{
  public static void main(String[] args)
  {
    CarrotBunch carrotBunch = new CarrotBunch(4, 10);
    Thread peeler = new Thread(new CarrotPeeler(carrotBunch));
    peeler.start();
    for (int i = 0; i < carrotBunch.getWhenToStopPeeling(); i++)
    {
      Thread eater = new Thread(new CarrotEater(carrotBunch));
      eater.start();
    }

  }
}
