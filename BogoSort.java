import java.util.ArrayList;
public class BogoSort {
      public static ArrayList populate( int size, int lo, int hi ) {
	ArrayList<Integer> retAL = new ArrayList<Integer>();
	while( size > 0 ) {
	    //     offset + rand int on interval [lo,hi]
	    retAL.add( lo + (int)( (hi-lo+1) * Math.random() ) );
	    size--;
	}
	return retAL;
    }

    public static boolean sorted(ArrayList<Comparable> data){
	for (int i = 0; i < data.size()-1;i++){
	    if (data.get(i).compareTo(data.get(i+1)) == 1){
		return false;
	    }
	}
	return true;
    }
    public static void bogo(ArrayList<Comparable> data){
	while (! sorted(data)){
	    shuffle(data);
	}
    }
 public static void shuffle( ArrayList al ) {
	int randomIndex;
        for( int i = al.size()-1; i > 0; i-- ) {
	    //pick an index at random
            randomIndex = (int)( (i+1) * Math.random() );
	    //swap the values at position i and randomIndex
            al.set( i, al.set( randomIndex, al.get(i) ) );
        }
    }
 //main method for testing
    public static void main( String [] args ) {
	  ArrayList glen = new ArrayList<Integer>();
	  glen.add(7);
	  glen.add(1);
	  glen.add(5);
	  glen.add(12);
	  glen.add(3);
	  System.out.println( "ArrayList glen before sorting:\n" + glen );
	  bogo(glen);
	  System.out.println( "ArrayList glen after sorting:\n" + glen );
	  ArrayList coco = populate( 10, 1, 1000 );
	  System.out.println( "ArrayList coco before sorting:\n" + coco );
	  bogo(coco);
	  System.out.println( "ArrayList coco after sorting:\n" + coco );
    }
}
