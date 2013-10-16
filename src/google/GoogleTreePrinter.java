/**
 * Careercup.com question(http://www.careercup.com/question?id=5074387359236096).
 * Complete the below function which takes an arraylist and displays the list in the expected output. 
 * 
 * Example input: 
 * List<Relation> input = newArrayList(); 
 * 
 * input.add(new Relation(“animal”, “mammal”)); 
 * input.add(new Relation(“animal”, “bird”)); 
 * input.add(new Relation(“lifeform”, “animal”)); 
 * input.add(new Relation(“cat”, “lion”)); 
 * input.add(new Relation(“mammal”, “cat”)); 
 * input.add(new Relation(“animal”, “fish”)); 
 * 
 * TreePrinter.printTree(input); 
 * 
 * Expected output: 
 * line 1: lifeform 
 * line 2: animal 
 * line 3: mammal 
 * line 4: cat 
 * line 5: lion 
 * line 6: bird 
 * line 7: fish
 * 
 * Submitted by AP.
 * Written by Thinh Lam on October 16, 2013.
 */
package google;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GoogleTreePrinter {
	public static void main(String[] args) {
		List<Relation> input = new ArrayList<Relation>(); 

		input.add(new Relation("animal", "mammal")); 
		input.add(new Relation("animal", "bird")); 
		input.add(new Relation("lifeform", "animal")); 
		input.add(new Relation("cat", "lion")); 
		input.add(new Relation("mammal", "cat")); 
		input.add(new Relation("animal", "fish")); 
		
		printTree(input);
	}
	
	// Create a hashmap based on the input and start recursive printing process.
	public static void printTree(Iterable<Relation> rs) {
		Map<String, ArrayList<String>> map = createMap(rs);
		printTree(findRoot(map), map);
	}
	
	// Main method that prints each element recursively in post(?) order traversal.
	public static void printTree(String root, Map<String, ArrayList<String>> map) {
		System.out.println(root);
		if(map.get(root) == null)
			return;
		else {
			for(String child : map.get(root))
				printTree(child, map);
		}
	}
	
	// Find the initial root by looking for the key that is not a value
	// to any other key.
	public static String findRoot(Map<String, ArrayList<String>> map) {
		boolean found = true;
		
		for(String key : map.keySet()) {
			for(List<String> list : map.values())
				if(list.contains(key))
					found = false;
			if(found)
				return key;
			found = true;
		}
 		return null;
	}
	
	// Generate a mapping of the parent-child pairs for easy traversal / reference.
	public static Map<String, ArrayList<String>> createMap(Iterable<Relation> relations) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		ArrayList<String> list;


		for(Relation r : relations) {
			if(!map.containsKey(r.parent))
				list = new ArrayList<String>();
			else
				list = map.get(r.parent);
			list.add(r.child);
			map.put(r.parent, list);
		}
		
		return map;
	}
	
	// Given Relation class for our parent-child pair.
	public static class Relation {
		String parent;
		String child;
		
		public Relation(String parent, String child) {
			this.parent = parent;
			this.child = child;
		}
	}
}
