import java.util.LinkedList;

// JULIA WANG
// StackList.java
// Write your own Stack using a LinkedList as the private variable

public class StackList<E>
{ 
  private LinkedList<E> list;

  public StackList()
  {
    list = new LinkedList<>();
  }

  public void push(E x)
  {
    list.addFirst(x); //are we treating the beginning or the end of the list as the top of the stack???
    //list.addLast(x);
  }

  public E pop()
  {
    return list.removeFirst();
    //return list.removeLast();
  }

  public E peek()
  {
    return list.getFirst();
    //return list.getLast();
  }

  public boolean isEmpty()
  {
    return list.size() == 0; 
  }

}