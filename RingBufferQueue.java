// JULIA WANG
// RingBufferQueue.java
// Write this class LAST.  Use your RingBufferQueue FRQ to complete this class 

public class RingBufferQueue
{ 
	private char[] characters;
	private int front;
	private int rear;	

	public RingBufferQueue(int capacity)
	{ 
		characters = new char[capacity + 1];
		front = 0;
		rear = 0;
	}

	public boolean isEmpty()
	{
		return front == rear;
	}

	public void flush()
	{
		front = rear;
	}

	public boolean add(char ch)
	{
		if ((rear + 1) % characters.length == front) //if the next space over equals front then it is full
			return false;
		else 
		{
			characters[rear] = ch;
			rear = (rear + 1) % characters.length; //shifts the rear to the right. Modulos the index number to create a circular array
			return true;
		}
	}

	public char remove()
	{
		if (isEmpty()) //if queue is empty then there is nothing to remove
			return ' ';
		else
		{
			char temp = characters[front];
			front = (front + 1) % characters.length; //shifts the front to the right. Modulos the index number to create a circular array
			return temp; //returns the removed character
		}
	}

	public char peek()
	{
		if (isEmpty()) //if queue is empty
			return '!';
		else
			return characters[front];
	}

	public int getFront()
	{
		return front;
	}

	public int getRear()
	{
		return rear;
	}		 	
					
}