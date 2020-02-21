/*
	InsertionSort.java
	Data Structures and Algorithms
	Author: Aileen L. Cai
	Due: February 20, 2020
*/


public class InsertionSort implements SortingAlgorithm
{
	public void sort(int [] a) 
	{
		for (int i = 1; i < a.length; i++) // i=1 because a[0] is sorted already
		{
			int temp = a[i];  //using a temporary variable to hold the value of the next unsorted item
			int j = i-1; 
			
			while (j >= 0 && temp < a[j])   
			{
				a[j+1] = a[j];    //sorting each value 
				--j;
			}

			a[j+1] = temp; //copying the temp to the correct location 
		}
	}
}