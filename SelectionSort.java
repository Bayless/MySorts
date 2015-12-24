//Bayle Smith-Salzberg
//APCS1 pd10
//HW52
//2015-12-22

/*======================================
  class SelectionSort -- implements SelectionSort algorithm
  ======================================*/

import java.util.ArrayList;

public class SelectionSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of SelectionSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void selectionSortV( ArrayList<Comparable> data ) 
    {
	int times = data.size()-1;
	for (int x = 0; x < times; x++){
	    Comparable mini = min(data,x);
	    int indexM = data.indexOf(mini);
	    Comparable ex = data.get(x);
	    data.set(x,mini);
	    data.set(indexM, ex);
	}
    }//end selectionSort -- O(?)
	
	public static Comparable  min(ArrayList<Comparable> input, int index){
	    Comparable little = input.get(index);
	    for (int i = index; i <input.size();i++){
		if(input.get(i).compareTo(little) == -1){
		    little = input.get(i);
		}
	    }
	    return little;
	}
	// ArrayList-returning selectionSort
	// postcondition: order of input ArrayList's elements unchanged
	//                Returns sorted copy of input ArrayList.
	public static ArrayList<Comparable> 
	    selectionSort( ArrayList<Comparable> input ) 
	{
	selectionSortV(input);
	return input;
    }//end selectionSort -- O(?)


    //main method for testing
    public static void main( String [] args ) {
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  selectionSortV(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  selectionSortV(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
	  ArrayList len = new ArrayList<Integer>();
	  len.add(7);
	  len.add(1);
	  len.add(5);
	  len.add(12);
	  len.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + len );
	  ArrayList lenSorted = selectionSort( len );
	  System.out.println( "sorted version of ArrayList len:\n" 
	  + lenSorted );
	  System.out.println( "ArrayList len after sorting:\n" + len );

	  ArrayList oco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList oco before sorting:\n" + oco );
	  ArrayList ocoSorted = selectionSort( oco );
	  System.out.println( "sorted version of ArrayList oco:\n" 
	  + ocoSorted );
	  System.out.println( "ArrayList oco after sorting:\n" + oco );
	  System.out.println( oco );

    }//end main

}    //end class SelectionSort
