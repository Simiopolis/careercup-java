/**
 * Link: http://www.careercup.com/question?id=5485521224597504
 * Given an input list of lists.. flatten the list. For e.g. 
 *
 * {{1,2}, {3}, {4,5}} ... Output should be {1, 2, 3, 4, 5}
 * 
 * Submitted by wassp
 * 
 */
package microsoft;

import java.util.ArrayList;
import java.util.List;

public class MSFlattenList {
	public static void main(String[] args) {
		// Set up a test list.
		List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(2);
		list.add(l);
		l = new ArrayList<Integer>();
		l.add(3);
		list.add(l);
		l = new ArrayList<Integer>();
		l.add(4);
		l.add(5);
		list.add(l);
		
		System.out.println("Before: " + list);
		System.out.println("After: " + flattenList(list));
		
	}
	
	public static List<Integer> flattenList(List<ArrayList<Integer>> list){
		List<Integer> output = new ArrayList<Integer>();
		for(List<Integer> l : list)
			output.addAll(l);
		return output;
	}
}
