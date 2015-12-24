//Bayle Smith-Salzberg
//APCS pd10
//HW51 -- Dat Bubbly Tho
//2015-12-21

/*======================================
  class BubbleSort -- implements bubblesort algorithm (vanilla version)
  ======================================*/

import java.util.ArrayList;

public class BubbleSort {

    //~~~~~~~~~~~~~~~~~~~ HELPER METHODS ~~~~~~~~~~~~~~~~~~~
    //precond: lo < hi && size > 0
    //postcond: returns an ArrayList of random integers
    //          from lo to hi, inclusive
    public static ArrayList populate( int size, int lo, int hi ) 
    {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }


    //randomly rearrange elements of an ArrayList
    public static void shuffle( ArrayList al ) 
    {
	int randomIndex;
	//setup for traversal fr right to left
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
    //~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~


    // VOID version of bubbleSort
    // Rearranges elements of input ArrayList
    // postcondition: data's elements sorted in ascending order
    public static void bubbleSortV( ArrayList<Comparable> data ) {
	int times = data.size() - 1;
	for (int x = 0; x < times; x++){
	    for (int i = times; i > 0; i--){
		if (data.get(i).compareTo(data.get(i-1)) == -1 ){
		    Comparable lit = data.get(i);
		    data.set(i, data.get(i-1));
		    data.set(i-1,lit);
		}
	    }
	}

    }//end bubbleSortV -- O(?)


    // ArrayList-returning bubbleSort
    // postcondition: order of input ArrayList's elements unchanged
    //                Returns sorted copy of input ArrayList.
    public static ArrayList<Comparable> bubbleSort( ArrayList<Comparable> data ){
	int times = data.size() - 1;
	for (int x = 0; x < times; x++){
	    for (int i = times; i > 0; i--){
		if (data.get(i).compareTo(data.get(i-1)) == -1 ){
		    Comparable lit = data.get(i);
		    data.set(i, data.get(i-1));
		    data.set(i-1,lit);
		}
	    }
	}
	return data;
    }  
    //end bubbleSort -- O(?)


    public static void main(String [] args){
	ArrayList glen = new ArrayList<Integer>();
	glen.add(7);
	glen.add(1);
	glen.add(5);
	glen.add(12);
	glen.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + glen );
	bubbleSortV(glen);
	System.out.println( "ArrayList glen after sorting:\n" + glen );
	ArrayList coco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList coco before sorting:\n" + coco );
	bubbleSortV(coco);
	System.out.println( "ArrayList coco after sorting:\n" + coco );
    	ArrayList len = new ArrayList<Integer>();
	len.add(7);
	len.add(1);
	len.add(5);
	len.add(12);
	len.add(3);
	System.out.println( "ArrayList glen before sorting:\n" + len );
	ArrayList lenSorted = bubbleSort( len );
	System.out.println( "sorted version of ArrayList len:\n" 
			    + lenSorted );
	System.out.println( "ArrayList len after sorting:\n" + len );

      	ArrayList oco = populate( 10, 1, 1000 );
	System.out.println( "ArrayList oco before sorting:\n" + oco );
	ArrayList ocoSorted = bubbleSort( oco );
	System.out.println( "sorted version of ArrayList oco:\n" 
			    + ocoSorted );
	System.out.println( "ArrayList oco after sorting:\n" + oco );
	System.out.println( oco );

    }//end main

}//end class BubbleSort
