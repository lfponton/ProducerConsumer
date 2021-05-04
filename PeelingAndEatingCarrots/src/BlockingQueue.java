import utility.collection.BoundedArrayQueue;
import utility.collection.QueueADT;

public class BlockingQueue<T> implements Buffer<T>
{
  private QueueADT<T> queue;

  public BlockingQueue(int capacity)
  {
    this.queue = new BoundedArrayQueue<>(capacity);
  }


  @Override public synchronized void put(T element)
  {
    if (element == null)
    {
      throw new IllegalArgumentException("Element cannot be null.");
    }
    while (queue.isFull())
    {
      try
      {
        //System.out.println("Producer waiting. Queue size is " + queue.size());
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    //System.out.println("Producer adds an element to the queue");
    queue.enqueue(element);
    //System.out.println("Queue size is " + queue.size());
    notifyAll();
  }

  @Override public synchronized T take()
  {
    while (queue.isEmpty())
    {
      try
      {
        //System.out.println("Consumer waiting. Queue size is " + queue.size());
        wait();
      }
      catch (InterruptedException e)
      {
        e.printStackTrace();
      }
    }
    //System.out.println("Consumer takes an element from the queue");
    T element = queue.dequeue();
    //System.out.println("Queue size is " + queue.size());
    notifyAll();
    return element;
  }

  @Override public synchronized T look()
  {
    if (queue.isEmpty())
    {
      return null;
    }
    return queue.first();
  }

  @Override public synchronized boolean isEmpty()
  {
    return queue.isEmpty();
  }

  @Override public synchronized boolean isFull()
  {
    return queue.isFull();
  }

  @Override public synchronized int size()
  {
    return queue.size();
  }
}