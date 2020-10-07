package Iterator;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Random;
import java.util.Scanner;

/**
 * Represents a List.
 *
 * @author Constantine Peros
 */
public class List {

  /**
   * @param args
   */
  public static void main(String[] args) {
    // iterators
    ArrayList<Integer> list = new ArrayList<Integer>();
    list.add(1001);
    boolean run = false;
    
    
    Random random = new Random();   
    int listSize = random.nextInt(25 - 3 + 1) + 3;  // Creates an integer between 3 and 10
    for(int i = 0; i < listSize; i++) {
      int ranDigit = random.nextInt(1000);  // Creates an integer between 3 and 100
      list.add(ranDigit);
    }


    do
    {
        try {
          Print(list);
          DoWhatNow(list, run);
        }
        catch (Exception e) {
          System.out.print("Error in Main " + e);
        }
    }
    while(run); //wanted to loop until quit, but had to make it just run once due to an error

  }

  /**
   * 
   */
  private static void DoWhatNow(ArrayList<Integer> list, boolean run) {
    // What would you like to do
    PrintString("What would you like to do? [A]dd Add[E] [G]et [R]emove [I]ndexof [S]et Si[Z]e I[T]erate S[O]rt"); // Asks What would you like to do?
    // Asks for an index to get
    Scanner inKey = new Scanner(System.in);
    inKey.useDelimiter(System.lineSeparator());
    try {
      String option = inKey.next();
      
      if (option.equalsIgnoreCase("a")) {
        AddInput(list);
      } else if (option.equalsIgnoreCase("g")) { 
        GetInput(list);
      } else if (option.equalsIgnoreCase("r")) {
        RemoveInput(list);
      } else if (option.equalsIgnoreCase("i")) { 
        indexOfInput(list);
      } else if (option.equalsIgnoreCase("s")) { 
        setInput(list);
      }else if (option.equalsIgnoreCase("z")) { 
        System.out.println(list.size());
      }else if (option.equalsIgnoreCase("e")) { 
        AddEInput(list);
      } else if (option.equalsIgnoreCase("t")) { 
        IterateInput(list);
      }else if (option.equalsIgnoreCase("o")) { 
        sortInput(list);
      }else {
        DoWhatNow(list, run);
      }

      } catch (Exception e) {
      // TODO: handle exception
        Print(list);
        PrintString("Error in DoWhatNow " + e);
    } 
    inKey.close();
  }

  /**
   * @param list
   */
  private static void sortInput(ArrayList<Integer> list) {
    PrintString("What type of sorting method? [B]ubble [I]nserton [S]elect");
    
    Scanner inKey = new Scanner(System.in);
    inKey.useDelimiter(System.lineSeparator());
    try {
      String option = inKey.next();
      
      if (option.equalsIgnoreCase("b")) {
        BubbleSort(list);
      } else if (option.equalsIgnoreCase("i")) { 
        InsertionSort(list);
      } else if (option.equalsIgnoreCase("s")) {
        BubbleSort(list);
      } else {
        sortInput(list);
      }

      } catch (Exception e) {
      // TODO: handle exception
        PrintString("Error in sort " + e);
    } 
    inKey.close();
    
  }

  /**
   * @param list
   */
  private static void InsertionSort(ArrayList<Integer> list) { 

    for(int k = 1; k < list.size(); k++)   {  
      int temp = list.get(k);  
      int j = k - 1;  
      while(j >= 0 && temp <= list.get(j))   {  
          //numArray[j + 1] = numArray[j]; 
          list.set(j + 1, list.get(j));
          j = j - 1; 
          Print(list);
      }  
      //numArray[j + 1] = temp;  
      list.set(j + 1, temp);
  }  
  //print the sorted array
  Print(list);
    

  }

  /**
   * @param list
   */
  private static void BubbleSort(ArrayList<Integer> list) {
    
    int index = 0;
    int j = list.get(index);
    int k = list.get(index + 1);
    
    //final long startTime = System.nanoTime();
    //swaps = 0;
    //comps = 0;
    int size = list.size();
    int n = 0;
    boolean didSwap = false;
    do {
      didSwap = false;
      for (int i = 0; i < (size - 1) - n; i++) {
        //comps++;
        if (j > k) {
          int temp = j;
          list.set(index, k);
          list.set(index + 1, temp);
          //swaps++;
          didSwap = true;
          Print(list);
          if (i < size - 2) {
            index++;
            j = list.get(index);
            k = list.get(index + 1);
          } else {
            index = 0;
            i = - 1;
            j = list.get(index);
            k = list.get(index + 1);
          } 
          
        } else { 
          index++;
          j = list.get(index);
          k = list.get(index + 1);
          
        }
      }
    } while (didSwap);

    //final long endTime = System.nanoTime();
    //sortTime = endTime - startTime;
    
    
    /*
    int j = list.get(indexCount);
    int k = list.get(indexCount + 1);
    int temp = 0;
    int size = list.size();

    System.out.println(j);
    System.out.println(k);
    
    while(j > k && indexCount < size - 1) {
      PrintString("this is true");
      temp = list.get(indexCount + 1);
      list.set(indexCount + 1, list.get(indexCount));
      list.set(indexCount, temp);
      
      Print(list);
      
      indexCount++;
      if (indexCount < size - 1) {
        j = list.get(indexCount);
        k = list.get(indexCount + 1);
      }
    }
    
    indexCount = 0;
    j = list.get(indexCount);
    k = list.get(indexCount + 1);
    if (j > k){
      
      Bubblesort(list, indexCount);  
    } else if (indexCount < size - 1){
      indexCount++;
      Bubblesort(list, indexCount);
    }*/
    
    Print(list);
  
  }

  /**
   * @param list
   */
  private static void IterateInput(ArrayList<Integer> list) {
    // Playing with iterator
    Iterator <Integer> it = list.iterator();
    while(it.hasNext()) {
      System.out.println(it.next());
    }
    PrintString("Which value would you like removed?");
    
    Scanner inKey = new Scanner(System.in);
    inKey.useDelimiter(System.lineSeparator());
    try {
      String option = inKey.next();
      int optionInt = Integer.parseInt(option); // Converts index string to int
      System.out.println("Remove index " + list.indexOf(optionInt));

      int remove = list.indexOf(optionInt); // int remove equals the indexOf the input option
      
      if(remove != -1) { // if remove exists
        it = list.iterator();
        
        for(int i = 0; i <= remove; i++) { // iterate until i equals removal value
          it.next();
        }
        it.remove(); // remove the value 
        PrintString("removed value " + option);
        
      } else {
        PrintString("Value to remove does not exist");
      }
      
      it = list.iterator();
      
      while(it.hasNext()) {
        System.out.println(it.next());
      }
 
    } catch (Exception e) {
      PrintString("Error in Iterate" + e);
    } finally {
      inKey.close();
    }
  }

  /**
   * @param list
   */
  private static void AddEInput(ArrayList<Integer> list) {
    PrintString("What would you like to add to the end of the list? "); // Asks Which Index would you like to see?
    // Asks for an index to get
    
    Scanner inKey = new Scanner(System.in);
    inKey.useDelimiter(System.lineSeparator());
    try {
      String item = inKey.next();
      int itemInt = Integer.parseInt(item); // Converts index string to int
      list.add(itemInt); // adds item to end of list
      Print(list); // prints list
    } catch (Exception e) {
      // TODO: handle exception
      PrintString("Farts II");
    } finally {
      inKey.close();
    }             
  }

  /**
   * @param list
   */
  private static void setInput(ArrayList<Integer> list) {


    PrintString("What index would You Like to set? ");
    // Asks for an index to set
    Scanner inKey = new Scanner(System.in);
    try {
      String index = inKey.nextLine();
      int indexInt = Integer.parseInt(index); // Converts index string to int and saves as indexInt
      PrintString("What would You Like to it to be? "); // Asks "What would You Like it to be? "
      String element = inKey.nextLine();
      int elementInt = Integer.parseInt(element); // Converts index string to int and saves as indexInt   
      list.set(indexInt, elementInt);
      Print(list);        
      System.out.println("list.get(indexInt)");
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      inKey.close();
    }
    
  
    
  }

  /**
   * @param list
   */
  private static void indexOfInput(ArrayList<Integer> list) {
    PrintString("What would you like to search the array for? "); // Asks What would you like to search the array for?
    Scanner inKey = new Scanner(System.in);
    inKey.useDelimiter(System.lineSeparator());
    try {
      String element = inKey.next();
      int elementInt = Integer.parseInt(element); // Converts index string to int
      if (list.contains(elementInt)) {
        PrintString("Element " + element + " is has an index of " + list.indexOf(elementInt)); 
      } else {
        PrintString("Array does not contain element");
      }
      
    } catch (Exception e) {
      // TODO: handle exception
      System.out.println("Farts");
    } finally {
      inKey.close();
    }             
  }

  /**
   * @param list
   */
  private static void RemoveInput(ArrayList<Integer> list) {


    PrintString("Where would You Like to Remove? "); // Asks "Where would You Like to Add? "
    // Asks for an index to add
    Scanner inKey = new Scanner(System.in);
    try {
      String index = inKey.nextLine(); 
      int indexInt = Integer.parseInt(index); // Converts index string to int and saves as indexInt 
      list.remove(indexInt);
      System.out.println(list);        
      System.out.println(list.get(indexInt));
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      inKey.close();
    }
  }

  /**
   * @param list
   */
  private static void AddInput(ArrayList<Integer> list) {

    PrintString("Where would You Like to Add? "); // Asks "Where would You Like to Add? "
    // Asks for an index to add
    Scanner inKey = new Scanner(System.in);
    try {
      String index = inKey.nextLine();
      
      int indexInt = Integer.parseInt(index); // Converts index string to int and saves as indexInt
      
      PrintString("What would You Like to Add? "); // Asks "What would You Like to Add? "
      String element = inKey.nextLine();
      int elementInt = Integer.parseInt(element); // Converts index string to int and saves as indexInt   
      list.add(indexInt, elementInt);
      Print(list);        
      System.out.println("list.get(indexInt)");
    } catch (Exception e) {
      // TODO: handle exception
    } finally {
      inKey.close();
    }
    
  }

  /**
   * @param string
   */
  private static void PrintString(String string) {
    // Prints a string
    System.out.println(string);
    
  }

  /**
   * 
   */
  private static void GetInput(ArrayList<Integer> list) {
    PrintString("Which Index would you like to see? "); // Asks Which Index would you like to see?
    // Asks for an index to get
    
    Scanner inKey = new Scanner(System.in);
    inKey.useDelimiter(System.lineSeparator());
    try {
      String index = inKey.next();
      int indexInt = Integer.parseInt(index); // Converts index string to int
      System.out.println(list.get(indexInt));
    } catch (Exception e) {
      // TODO: handle exception
      PrintString("Farts");
    } finally {
      inKey.close();
    }             
  }
  

  /**
   * 
   */
  private static void Print(ArrayList<Integer> list) {
    
    System.out.println(list);
    
  }

}
