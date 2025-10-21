// DO NOT change this interface
// It is exactly right as it is

public interface MaxPriorityQueue
{
  public boolean isEmpty();
  public boolean add(Comparable x);
  public Comparable removeMax();
  public Comparable peekMax();

  public String toString( );		
  public boolean isFull( );
  public int getCount();

}
