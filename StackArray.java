import java.util.ArrayList; 
// WRITTEN BY MR. MCKEEN

/*
The private variable in the file below is an ArrayList.

When you create your own StackList and QueueList, it will look very much
like the file below EXCEPT that the private variable will be a 
LinkedList instead.

This is your first class that uses the type definition <E>.  Remember to keep the E's in place here and when you write StackList and QueueList!
*/

public class StackArray<E>
{ 
  private ArrayList<E> array;  // The only private variable
 
 // Constructs a stack of <Whatever> the user wants
 // Example in a runner: StackArray<Fraction> sf = new StackArray<Fraction>();

  public StackArray()
  { 
  		array = new ArrayList<E>(); 
  } 

  // Puts a value on the top of the stack
  public void push(E element) 
  { 
  		array.add(element); 
  }
  //Removes the value from the top of the stack 
  public E pop() 
  { 
  		return array.remove(array.size() - 1); 
  } 

  // Returns a pointer to the top value without modifying the stack
  // Precondition:  The stack is not empty
  public E peek() 
  { 
  		return array.get(array.size() - 1); 
  }

  // Checks if the stack is empty 
  public boolean isEmpty() 
  { 
  		return array.size() == 0; 
  } 
}
