/*
	QuickSort.java
	Data Structures and Algorithms
	Author: Aileen L. Cai
	Due: February 20, 2020
*/



public class QuickSort implements SortingAlgorithm
{
	public void sort(int [] arr) 
	{
		sort(arr, 0, arr.length - 1);   //no need for an additional array because quick sort happens in-place 
	}

	public void sort(int [] arr, int start, int end)  
	{
		int p = partition(arr, start, end);   
	
		if (start < p-1)
		{
			sort(arr, start, p-1);      //array is split according to partition functions then sorted 
		}

		if (p < end)
		{
			sort(arr, p, end);
		}
		
	}

	public int partition(int [] arr, int start, int end)   //splitting the array at a particular point
	{
		int pivot = start;   //in this case, the particular point is the first item in the array 
		int left = start;
		int right = end;

		while (left <= right)  
		{
			while (arr[left] < arr[pivot])      //comparing the elements on the left side against the pivot 
				++left;
			while (arr[right] > arr[pivot])    //comparing the elements on the right side against the pivot 
				--right;
			
			if (left <= right)
			{
				int temp = arr[right];    //swapping the positions of the elements in the array 
				arr[right] = arr[left];
				arr[left] = temp;
				left++;
				right--;
			}
		}
		return left;
	}
}
