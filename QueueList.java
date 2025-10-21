import java.util.LinkedList;

// JULIA WANG
// QueueList.java
// Write your own Queue using a LinkedList as the private variable

public class QueueList<E>
{ 
  private LinkedList<E> list;

  public QueueList()
  {
    list = new LinkedList<>();
  }

  public boolean add(E x)
  {
    list.addLast(x);
    return true;
  }

  public E remove()
  {
    return list.removeFirst();
  }

  public E peek()
  {
    return list.getFirst();
  }

  public boolean isEmpty()
  {
    return list.size() == 0;
  }
}