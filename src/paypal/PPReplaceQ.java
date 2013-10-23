/**
 * Link: http://www.careercup.com/question?id=6497025214382080
 * Replace element of an Array with nearest bigger number at right 
 * side of the Array in O(n) 
 * 
 * For example if the input Array is 
 * 7, 5, 6, 3, 4, 1, 2, 9, 11 
 * output array should be 
 * 9, 6, 9, 4, 9, 2, 9, 11, 11
 * 
 * Solved on October 23, 2013.
 */
package paypal;

public class PPReplaceQ {
	public static void main(String[] args) {
		replace(new int[]{7, 5, 6, 3, 4, 1, 2, 9, 11 });
		replace(new int[]{7, 5, 3, 4, 1, 2});
	}
	
	public static void replace(int[] a) {
		int i=0;
		
		// Find nearest bigger number in linear time.
		// Update indices when found.
		for(int j=1; j<a.length; j++) {
			if(a[i] < a[j]) {
				a[i] = a[j];
				i++;
				j = i;
			}
		}
		
		// Print function for testing purposes.
		for(Integer in : a) {
			System.out.print(in+" ");
		}
		System.out.println();
	}
}
