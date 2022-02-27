import static org.junit.Assert.assertArrayEquals;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

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
    	try
    	{
    		FileReader kN = new FileReader("numbers1000.txt");
    		FileReader dupKN = new FileReader("numbers1000Duplicates.txt");
    		FileReader tenKN = new FileReader("numbers10000.txt");
    		FileReader nrlyRdrdKN = new FileReader("numbersNearlyOrdered1000.txt");
    		FileReader rvrsKN = new FileReader("numbersReverse1000.txt");
    		FileReader srtdKN = new FileReader("numbersSorted1000.txt");
    	    
    	}

		catch (FileNotFoundException e)
		{
		    e.printStackTrace();
		}
    	
    }

}

