/*
	MergeSort.java
	Data Structures and Algorithms
	Author: Aileen L. Cai
	Due: February 20, 2020
*/


//received help from information in "Cracking the Coding Interview"


public class MergeSort implements SortingAlgorithm
{
	public void sort(int [] arr)
	{
		int[] finalArray = new int[arr.length];  //merge sort does not happen in-place; needs additional array to sort
		mergeSort(arr, finalArray, 0, arr.length-1);
	}

	public void mergeSort(int [] arr, int[] finalArray, int left, int right)
	{
		if (left<right)
		{
			int mid = (left + right) / 2;
			mergeSort(arr, finalArray, left, mid); //sorting the left half of the split array 
			mergeSort(arr, finalArray, mid+1, right); //sorting the right half of the split array
			merge(arr, finalArray, left, mid, right); //merging the arrays together
		}
	}

	public void merge(int[] arr, int[] finalArray, int left, int mid, int right)
	{
		for (int i = left; i <= right; i++)
		{
			finalArray[i] = arr[i];      //combining the two arrays into the finalArray
		}

		int leftIndex = left;
		int rightIndex = mid + 1;
		int targetIndex = left;

		while(leftIndex <= mid && rightIndex <= right)  //sorting through both sides of the final array 
		{
			if (finalArray[leftIndex] <= finalArray[rightIndex])  //if left side is smaller
			{
				arr[targetIndex] = finalArray[leftIndex];
				leftIndex++;			
			}
			else   //if right side is smaller
			{
				arr[targetIndex] = finalArray[rightIndex];
				rightIndex++;
			}
			targetIndex++;
		}

		int remainder = mid - leftIndex;
		for (int j = 0; j <= remainder; j++)   //when the while loop above doesn't copy all of the elements from the left into the final array 
			arr[targetIndex + j] = finalArray[leftIndex + j];
	}
}	