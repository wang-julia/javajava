// This is where most of your code will be
//Julia Wang

import java.util.ArrayList;

public class ProcessArrays 
{
  public ProcessArrays(){}

  public void remove(int[] arnold, ArrayList<Integer> albert, int killUs)
  {
    if (killUs % 2 == 0) //removes even numbers
    {
        for (int i = albert.size()-1; i >= 0; i--) //arraylist
        {
          if (albert.get(i) % 2 == 0)
            albert.remove(i);
        }

        for (int i = 0; i < arnold.length; i++) //array
        {
          if (arnold[i] % 2 == 0)
            arnold[i] = -1; 
        }
    }
    else //removes odd numbers
    {
        for (int i = albert.size()-1; i >= 0; i--) //arraylist
        {
          if (albert.get(i) % 2 != 0)
            albert.remove(i);
        }
        
        for (int i = 0; i < arnold.length; i++) //array
        {
          if (arnold[i] % 2 != 0)
            arnold[i] = 0; 
        }
    }
  }

  public void sortUs(HighSchoolStudent[] arnold, ArrayList<HighSchoolStudent> albert) 
  {
    //sorting Array/Arnold using insertion sort 
    for (int i = 1; i < arnold.length; i++)
    {
      int j;
      HighSchoolStudent temp = arnold[i];

      if (temp.getDaysMissed() > arnold[i-1].getDaysMissed()) //if the element to the left of temp is less than temp
      {
        //shifts temp towards the left as long as the value to the left is less than temp's daysmissed value
        for (j = i; j > 0 && arnold[j-1].getDaysMissed() < temp.getDaysMissed(); j--)
        {
          arnold[j] = arnold[j-1]; //temp's current index's element is replaced by the lesser element on temps left 
        }
        
        arnold[j] = temp; //replaces the element of index where temp stopped with temp's daymissed value
      }
    }

    //sorting arraylist/Albert using insertion sort
    for (int i = 1; i < albert.size(); i++)
    {
      int j;
      HighSchoolStudent temp = albert.get(i);

      if (temp.getDaysMissed() > albert.get(i-1).getDaysMissed()) 
      {
        for (j = i; j > 0 && albert.get(j-1).getDaysMissed() < temp.getDaysMissed(); j--)
        {
          albert.set(j, albert.get(j-1));
        }
        
        albert.set(j, temp);
      }
    }
  }

  //finds the student who missed the most school out of both the array and the arraylist
  public ArrayList<String> getTruants(HighSchoolStudent[] arnold, ArrayList <HighSchoolStudent> albert)
  {
    ArrayList<String> truants = new ArrayList<String>();

    double max = arnold[0].getDaysMissed();
    truants.add(arnold[0].getName());

    for (int i = 1; i < arnold.length; i++) //finds max(s) in arnold
    {
      double temp = arnold[i].getDaysMissed();
      if (temp > max)
      {
        for (int z = truants.size() - 1; z >= 0; z--) //if new max, then clears current truants arraylist
        {
          truants.remove(z);
        }
        truants.add(arnold[i].getName()); 
        max = temp;
      } 
      else if (temp == max) //if daysmissed is equal, then it adds the student to the arraylist without clearing
      {
        truants.add(arnold[i].getName());
      }
    }

    for (int j = 0; j < albert.size(); j++) //finds max(s) in albert (compares to the same max as used in arnold)
    {
      double temp2 = albert.get(j).getDaysMissed();

      if (temp2 > max)
      {
        for (int z = truants.size() - 1; z >= 0; z--) //if new max, then clears current truants arraylist
        {
          truants.remove(z);
        }
        truants.add(albert.get(j).getName());
        max = temp2;
      }
      else if (temp2 == max) //if daysmissed is equal, then it adds the student to the arraylist without clearing
      {
        truants.add(albert.get(j).getName());
      }
    }

    return truants;
  }

  //twoAnswer
  public TwoAnswer largest(int[][] twoDArray)
  {
    //largest row
    int largestSum = Integer.MIN_VALUE;   
    int tempSum = 0; 

    for (int i = 0; i < twoDArray.length; i++) //rows
    {
      for (int j = 0; j < twoDArray[i].length; j++) //columns
      {
        tempSum += twoDArray[i][j]; //adds row sum
      }

      if (tempSum > largestSum) //compares current sum to previous largest sum
        largestSum = tempSum;  
      tempSum = 0; 
    }

    //largest column
    int largestSum2 = Integer.MIN_VALUE;  
    int tempSum2 = 0; 
    for (int i = 0; i < twoDArray[0].length; i++) //columns
    {
      for (int j = 0; j < twoDArray.length; j++) //rows
      {
        tempSum2 += twoDArray[j][i]; //adds the column sum
      }

      if (tempSum2 > largestSum2) //compares current sum to previous largest sum
        largestSum2 = tempSum2;  
      tempSum2 = 0; 
    }
    
    TwoAnswer biggy = new TwoAnswer(largestSum, largestSum2); 
    return biggy; 
  }

  public int[] countDigits(int[] arnold, ArrayList<Integer> albert)
  {
    ArrayList<Integer> temp = new ArrayList<Integer>();

    for (int i = 0; i < arnold.length; i++) //splits up all the values in the array into its digits and adds it to a temp arraylist
    {
      int d = arnold[i]; 
      
      if (d == 0) //if int is just 0
        temp.add(0);
      else 
      {
        while (d > 0) 
        {
          int mod = d%10;  //gets the end number
          temp.add(mod); //adds it to the arraylist
          d = d/10; //"cuts" off the end number
        } 
      }
    }

    for (int j = 0; j < albert.size(); j++) //splits up all the values in the arraylist into its digits
    {
      int di = albert.get(j);
      
      if (di == 0)
        temp.add(0);
      else
      {
        while (di > 0)
        {
          int mod = di%10; //gets the end number
          temp.add(mod); //adds it to the arraylist
          di = di/10;  //"cuts" off the end number
        } 
      }
    }

    int[] digits = new int[10];

    for (int z = 0; z < temp.size(); z++) //increments each array value when the corresponding digit exists
    {
      int value = temp.get(z);
      digits[value]++; 
    } 

    return digits; 
  }

  public void makeMeLaugh()
  {
    System.out.println("What do you call a pile of cats?");
    System.out.println("A meow-ntain.");
  }

  public boolean isPrime(int[] arnold, ArrayList<Integer> albert)
  {
    int sum = 0; 

    for (int i = 0; i < arnold.length; i++) //checks prime for array
    {
      int temp = arnold[i];
      
      //prime???
      if (temp <= 1)
        return false; 

      int divisor; 
      int max = 1;

      for (divisor = 1; divisor < temp; divisor++) //finds max
      {
        if (temp % divisor == 0)
          max = divisor;
      }

      if (max != 1) //if the max is 1 or the og number then it is prime
        return false; 

      sum += temp; 
    }

    for (int j = 0; j < albert.size(); j++) //checks prime for arraylist
    {
      int temp = albert.get(j);
      
      //prime???
      if (temp <= 1)
        return false; 
    
      int divisor; 
      int max = 1;

      for (divisor = 1; divisor < temp; divisor++) //finds max
      {
        if (temp % divisor == 0)
          max = divisor;
      }

      if (max != 1) //if the max is 1 then it is prime
        return false; 

      sum += temp; 
    }

    //finds if sum is prime
    if (sum <= 1)
      return false; 

    int divisor; 
    int max = 1;

    for (divisor = 1; divisor < sum; divisor++) //finds max
    {
      if (sum % divisor == 0)
        max = divisor; 
    }

    if (max != 1)
      return false; 

    return true; 
    
  }
}