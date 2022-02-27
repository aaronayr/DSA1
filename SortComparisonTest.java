import static org.junit.Assert.assertArrayEquals;

import java.io.File;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

//-------------------------------------------------------------------------
/**
 *  Test class for SortComparison.java
 *
 *  @author Aaron Ryan
 *  @version HT 2020
 */

/*
 * Speed test Analysis:
 * 
 * --Time in milliseconds--
 *                    |Insertion|Selection|Quick  |Merge Rec|Merge It|
 * 1000 random        |06       |04    	  |00	  |01		|00		 |
 * 1000 duplicates    |01       |01		  |00	  |00		|00		 |
 * 10000 random       |37       |23		  |01	  |01		|01	     |
 * 1000 nearly ordered|00       |00		  |00	  |00		|00 	 |
 * 1000 reversed      |00       |01		  |00	  |00		|00		 |
 * 1000 sorted        |00       |00		  |01	  |00		|00		 |
 * 
 * a)
 * The order of input seems to have an effect on 'Insertion' & 'Selection' sort. 
 * The other algorithms may be affected by the order of input, but it is unclear,
 * as the times required to process them are within a rounding error.
 * 
 * b)
 * Insertion sort has the greatest difference between best and worst performance.
 * It has a best case runtime of omega(n), and worst case runtime of O(n^2).
 * This (theoretically) occurs with a sorted and reverse-sorted array respectively.
 * No other algorithm has a best-worst complexity delta of n.
 * Thus Insertion sort has the biggest difference.
 * 
 * c)
 * Insertion sort has the worst scalability.It has a 31ms delta between 1,000 and 10,000 doubles.
 * 
 * d)
 * There may be a difference between recursive and iterative algorithms.
 * The recursive version had a 1ms average runtime, compared to iterative average recorded runtime.
 * This is well within the margin of error, so I can't conclusively say that recursive is less efficient.
 * 
 * e)
 * Quick, Merge Rec and Merge It seem as fast as each other with these data sets to within the margin of error.
 * However, taking the results at face value, these are the fastest algorithms:
 * 1000 random        |Quick/Merge It
 * 1000 duplicates    |Quick/Merge Rec/Merge It
 * 10000 random       |Quick/Merge Rec/Merge It
 * 1000 nearly ordered|Quick/Merge Rec/Merge It
 * 1000 reversed      |Quick/Merge Rec/Merge It
 * 1000 sorted        |Merge Rec/Merge It
 */


@RunWith(JUnit4.class)
public class SortComparisonTest
{
	
	double[] example = {5.45,10.99,85.32,8.76,74.32,42.64,5.56,12.95,20.13,87.41,2.65,2.48,54.44,28.98,50.87,86.79,8.51,30.95,12.54,67.01};
	double[] sortedExample = {2.48, 2.65, 5.45, 5.56, 8.51, 8.76, 10.99, 12.54, 12.95, 20.13, 28.98, 30.95, 42.64, 50.87, 54.44, 67.01, 74.32, 85.32, 86.79, 87.41};

    //~ Constructor ........................................................
    @Test
    public void testConstructor()
    {
        new SortComparison();
    }

    //~ Public Methods ........................................................

    // ----------------------------------------------------------
    /**
     * Check that the methods work for empty arrays
     */
    @Test
    public void testEmpty()
    {
    }


    // TODO: add more tests here. Each line of code and ech decision in Collinear.java should
    // be executed at least once from at least one test.
    
    @Test
    public void testInsertion() {
    	
    	double[] insertExample = SortComparison.insertionSort(example);
    	assertArrayEquals(sortedExample, insertExample, 0);
    }
    
    @Test
    public void testSelection() {
    	
    	double[] selectionExample = SortComparison.selectionSort(example);
    	assertArrayEquals(sortedExample, selectionExample, 0);
    }
    
    @Test
    public void testQuick() {
    	
    	double[] quickExample = SortComparison.quickSort(example);
    	assertArrayEquals(sortedExample, quickExample, 0);
    }

    @Test
    public void testMergeRsv() {
    	
    	double[] MergeRsvExample = SortComparison.mergeSortRecursive(example);
    	assertArrayEquals(sortedExample, MergeRsvExample, 0);
    	
    }
    
    @Test
    public void testMergeItv() {
    	
    	double[] MergeItvExample = SortComparison.mergeSortIterative(example);
    	assertArrayEquals(sortedExample, MergeItvExample, 0);
    }

    // ----------------------------------------------------------
    /**
     *  Main Method.
     *  Use this main method to create the experiments needed to answer the experimental performance questions of this assignment.
     *
     */
    
    public static void main(String[] args)
    {
    	double[] KN = new double[1000];
    	File KNFile = new File("numbers1000.txt");
    	SortComparison.read(KN, KNFile);
    	SortComparison.speedTest(KN);

    	double[] dupKN = new double[1000];
    	File dupKNFile = new File("numbers1000Duplicates.txt");
    	SortComparison.read(dupKN, dupKNFile);
    	SortComparison.speedTest(dupKN);
    	
    	double[] tenKN = new double[10000];
    	File tenKNFile = new File("numbers10000.txt");
    	SortComparison.read(tenKN, tenKNFile);
    	SortComparison.speedTest(tenKN);
    	
    	double[] nearOrderlyKN = new double[1000];
    	File nearOrderlyKNFile = new File("numbersNearlyOrdered1000.txt");
    	SortComparison.read(nearOrderlyKN, nearOrderlyKNFile);
    	SortComparison.speedTest(nearOrderlyKN);
    	
    	double[] reverseKN = new double[1000];
    	File reverseKNFile = new File("numbersReverse1000.txt");
    	SortComparison.read(reverseKN, reverseKNFile);
    	SortComparison.speedTest(reverseKN);
    	
    	double[] sortedKN = new double[1000];
    	File sortedKNFile = new File("numbersSorted1000.txt");
    	SortComparison.read(sortedKN, sortedKNFile);
    	SortComparison.speedTest(sortedKN);
    }
    

}

