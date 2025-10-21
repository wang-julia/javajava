//AnimalList
//Julia Wang

public class AnimalList 
{
    private ListNode head;
    private int numAddRemove;

    public AnimalList()
    {
        head = null;
        numAddRemove = 0;
    }

    //ADDANIMAL
    public void addAnimal(Comparable addValue)
    {
        ListNode a = new ListNode(addValue, null);

        if (head == null) //if there is nothing in the list then it points head to a
        {
            head = a;
            numAddRemove++;
            System.out.println("ADDED: " + addValue + "\t\tBEFORE: none" + "\t\tAFTER: none" ); //BONUS
            return;
        }
        else //adding a listnode if the list is not empty
        {
            ListNode temp = head;
            ListNode prev = null; 

            while (temp != null && addValue.compareTo(temp.getValue()) > 0) //if compareTo is positive, then addValue comes before the current listnode so you need to check the next listnode
            {
                prev = temp; //points prev to the current listnode
                temp = temp.getNext(); //points temp to the next listnode
            }

            if (prev == null) //adding at the beginning: when addValue comes alphabetically before all the other listnodes, it adds it to the head
            {
                a.setNext(temp);
                head = a; 
                System.out.println("ADDED: " + addValue + "\t\tBEFORE: none" + "\t\tAFTER: " + temp.getValue()); //BONUS
            } 
            else //adding the listnode in the middle or end (adds it BEFORE the current listnode (aka temp) and after previous listnode)
            {
                a.setNext(temp); 
                prev.setNext(a);
                
                if (temp != null) //add in middle
                    System.out.println("ADDED: " + addValue + "\t\tBEFORE: " + prev.getValue() + "\t\tAFTER: " + temp.getValue()); //BONUS
                else //add at end
                    System.out.println("ADDED: " + addValue + "\t\tBEFORE: " + prev.getValue() + "\t\tAFTER: none"); //BONUS
            }

            numAddRemove++;
        }
    }

    //REMOVEANIMAL
    public boolean removeAnimal(Comparable searchValue) //removes the first instance of the searchValue
    {
        ListNode temp = head; 
        ListNode prev = null; 

        if (head == null) //if list is empty
            return false;
        else
        {
            while (temp != null && searchValue.compareTo(temp.getValue()) != 0) //if searchValue and temp.getValue() are not the same value
            {
                prev = temp; //points prev to the current listnode
                temp = temp.getNext(); //points temp to the next listnode
            }

            if (temp == null) //nothing found
                return false;
            else if (prev == null) //remove from beginning (temp is pointing to first listnode)
            {
                head = head.getNext();
                numAddRemove++;

                if (temp.getNext() != null)
                    System.out.println("REMOVED: " + searchValue + "\t\tBEFORE: none" + "\t\tAFTER: " + temp.getNext().getValue()); //BONUS
                else
                    System.out.println("REMOVED: " + searchValue + "\t\tBEFORE: none" + "\t\tAFTER: none"); //BONUS
                return true;
            }
            else
            {
                if (temp.getNext() == null) //remove at end (temp is pointing to the last listnode)
                {
                    System.out.println("REMOVED: " + searchValue + "\t\tBEFORE: " + prev.getValue() + "\t\tAFTER: none"); //BONUS
                    prev.setNext(null);
                }
                else //remove in the middle
                {
                    System.out.println("REMOVED: " + searchValue + "\t\tBEFORE: " + prev.getValue() + "\t\tAFTER: " + temp.getNext().getValue()); //BONUS
                    prev.setNext(temp.getNext());
                }
                numAddRemove++;
                return true;
            }
        }
    }

    //DISPLAYLIST
    public void displayList()
    {
        ListNode current = head; //sets current to point to the same thing listnode as head
        while (current != null)
        {
            System.out.println(current.getValue()); //returns value of the listnode
            current = current.getNext(); //moves on to point to next listnode
        }
    }

    public int getnumAddRemove()
    {
        return numAddRemove;
    }
}
