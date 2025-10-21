//Julia Wang

public class HeapPriorityQueue implements MaxPriorityQueue
{
    private Comparable[] heaparray;
    private int count;
    private int maxSize; 

    public HeapPriorityQueue(int max)
    {
        maxSize = max;
        count = 0; 
        heaparray = new Comparable[max + 1]; //heap starts at index 1
    }

    public boolean add(Comparable val)
    {
        if (count == maxSize) //full
        {
            System.out.println("ERROR: Unable to add a new item. Your heap is full. "); 
            return false; 
        }
        else 
        {
            int loc = count + 1; //location of where val is being added
            heaparray[loc] = val; //adds to array
            count++;

            while (loc > 1) //as long as loc is greater than 1 (equal to or greater than 2), then it can be divided by two to find its parent; equal to 1 does not work because 1/2 = 0 but the 0th index is not used
            {
                int parent = loc / 2; //finds parent index of val
                if (heaparray[parent].compareTo(heaparray[loc]) < 0) //if parent element is less then val, then swap the location of the two values
                {
                    Comparable temp = heaparray[parent]; //stores parent element in a temp variable
                    heaparray[parent] = heaparray[loc]; //replaces parent value with val
                    heaparray[loc] = temp; //replaces val with parent element (temp)
                    loc = parent; //shifts current location of val to the index location it was swapped with (aka parent index)
                }
                else 
                    break; //if parent element is greater then val, then don't swap anything and leave val at current location in the array
            }
 
            return true;
        }
    }

    public boolean isEmpty()
    {
        return count == 0;
    }

    public Comparable removeMax() //removes root (aka index 1 value)
    {
        if (count == 0)
        {
            System.out.println("ERROR: Unable to remove. Your heap is empty. "); 
            return null; 
        } 
        else 
        { 
            Comparable removed = heaparray[1]; //stores max value
            heaparray[1] = heaparray[count]; //replaces max value with last value in the array
            heaparray[count] = null; //sets last index in array to null (because it got moved to the max position)
            count--;
            int loc = 1; //location of new max value (starts at top aka index of 1)

            //checking if there is a left child is the prereq to checking if there is a rightchild
            while (2*loc <= count)
            {
                int leftchild = loc*2;
                int rightchild = leftchild + 1; //index of rightchild is always one greater then leftchild
                int largest = leftchild; //assume left is largest (bc you still need to check if rightchild exists)

                if (rightchild <= count && heaparray[leftchild].compareTo(heaparray[rightchild]) < 0) //first checks if right child exists in the array, then if it is bigger than leftchild
                {
                    largest = rightchild; 
                }

                if (heaparray[loc].compareTo(heaparray[largest]) < 0) //compare to larger child; if top value is less than larger child value then swap
                {
                    Comparable temp = heaparray[largest]; //stores largest child element in a temp variable
                    heaparray[largest] = heaparray[loc]; //swaps largest child index with the 'new max'
                    heaparray[loc] = temp; //puts largest child value in the 'new max' (parent) index
                    loc = largest; //loc of 'new max' is now the location/index of the larger child
                }
                else
                    break;
            }

            return removed; 
        }
    }

    public Comparable peekMax()
    {
        if (count == 0)
            return null; 
        
        return heaparray[1];
    }

    public String toString()
    {
        if (count == 0)
            return "";
        
        String temp = new String();

        for (int i = 1; i <= count; i++)
            temp += heaparray[i] + ",";

        return temp.substring(0, temp.length()-1); //removes comma at the end
    }

    public boolean isFull()
    {
        return count == maxSize; 
    }

    public int getCount()
    {
        return count; 
    }
}