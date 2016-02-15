import java.util.Arrays;

public class Subject {

	private int[] arrayValues;  // where the values of the array are store


	public Subject(int[] inputArray){
		arrayValues = inputArray; //constructor sets unsorted array
	}

	// recursive sorting function
	public int[] mergeSort(int[] A){
		int n = A.length; // find length of array
		if (n < 2){
			return A; //if single element then return
		}
		else{                  // if not single element then split and sort
			int mid = n/2;      // find midpoint
			int[] left = new int[mid];  //split array
			int[] right = new int[n-mid];
			System.arraycopy(A, 0, left, 0, mid);
			System.arraycopy(A, mid, right, 0, n-mid);
			left = mergeSort(left);  //run recursively on both arrays
			right = mergeSort(right);
			A = merge(left, right);  // merge the two arrays
			return A;		// return sorted array
		}


	}

	public int[] merge(int[] left, int[] right){
		int nL = left.length;
		int nR = right.length;
		int i = 0;
		int j = 0;
		int k = 0;
		int[] merged = new int[nL+nR];

		while( i < nL && j < nR ){
			if (left[i] <= right[j]){
				merged[k]=left[i];
				i++;
			}
			else{
				merged[k]=right[j];
				j++;
			}
			k++;
		}

		while(i < nL){
			merged[k]=left[i];
			i++;
			k++;
		}

		while(j < nR){
			merged[k]=right[j];
			j++;
			k++;
		}
		return merged;
	}

	//set  sorted array
	public void sortArray(){
		arrayValues = mergeSort(arrayValues); //calls recursive function
	}

	public void displayArray(){
		System.out.print(Arrays.toString(arrayValues)); //displays the array values
	}

}
