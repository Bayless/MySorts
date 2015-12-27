//Bayle Smith-Salzberg
//APCS1 pd10
//HW27 -- Objectify Your Array Tools
//2015-11-09

public class ArrayUtils{
    public static String toString(Object[] Array){
	if (Array.length == 0){
	    return "[]";
	}
	String ret = "";
	for (Object i: Array){
	    ret += "," + i;
	}
	String s  = "[" + ret.substring(1,ret.length())+"]";
	return s;
    }
    public static String populate(Object[] Array, int min, int max){
	Object[] ret = new Object[Array.length];
	for (int i=0; i < Array.length;i++){
	    double prob = Math.random();
	    Array[i] = (int)(prob * (max - min) + min);
	    ret[i]=Array[i];
	}
	return toString(ret);
    }
    public static int linSearch(Object[] a, Object target){
	boolean ret = false;
	for (int i=0;i<a.length;i++){
	    if (a[i].equals(target)){
		return i;}
    }
    return -1;
    }
    public static int linSearchR(Object[] a, Object target, int ctr){
	int ret=-1;
	if (a.length==0){
	    return -1;}
	if(a[0].equals(target)){
	    return ctr;
	}

	else if (!(a[0].equals(target))){
	    Object[] b =new Object[a.length - 1];
	    for (int i = 1; i < a.length;i++){
		b[i-1] = a[i];}
	    ctr =ctr +  1;
	    return linSearchR(b, target, ctr);
	}
	return ret;

    }
    public static int freq(Object[] a, Object target){
	int ctr = 0;
	for (int i=0;i<a.length;i++){
	    Object[] b = {a[i]};
	    if (linSearch(b, target)!= -1){
		ctr+=1;}
	}
	return ctr;
    }
    public static int freqRec(Object[] a, Object target){
	if (a.length==0){
	    return 0;}
	else {
	    if (a[0].equals(target)){
		Object[] b =new Object[a.length - 1];
		for (int i = 1; i < a.length;i++){
		    b[i-1] = a[i];}
		return 1 + freqRec(b,target);
	    }
	    else {
		Object[] b =new Object[a.length - 1];
		for (int i = 1; i < a.length;i++){
		    b[i-1] = a[i];}
		return freqRec(b,target);
	    }
	}
    }
		
    public static void main (String[] args){
	Object[] arr = {1,2,3,4,45};
	System.out.println(toString(arr));
	Object[] empty = new Object[4];
	Object[] b = {1,2,3,2,2,2,4};
	Object target = 2;
	Object non = 4;
	System.out.println(linSearch(b, target));
	System.out.println(linSearchR(b, target, 0));
	System.out.println(linSearch(b, non));
	System.out.println(linSearchR(b,non,0));
	System.out.println(freq(b,target));
	System.out.println(freqRec(b,target));
	System.out.println(freq(b,non));
	System.out.println(freqRec(b,non));
	Object[] arr2 = {"1string" , 2 ,3,4,45};
	System.out.println(toString(arr2));
	Object[] empty3 = new Object[4];
	System.out.println(populate(empty3, 10, 23));
	Object[] empty4 = new Object[20];
	System.out.println(populate(empty4, 0, 20));
	Object[] c = {1,2,"3string",2,2,2,4};
	Object targetz = "3string";
	Object none = 4;
	System.out.println(linSearch(c, targetz));
	System.out.println(linSearchR(c, targetz, 0));
	System.out.println(linSearch(c, none));
	System.out.println(linSearchR(c,none,0));
	System.out.println(freq(c,target));
	System.out.println(freqRec(c,targetz));
	System.out.println(freq(c,none));
	System.out.println(freqRec(c,none));
    }
}
