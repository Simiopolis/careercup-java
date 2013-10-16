/**
 * Careercup.com question(http://www.careercup.com/question?id=5111068527427584)
 * 
 * Input - List<String> ["star", "rats", "ice", "cie", "arts"] 
 * 
 * print all anagrams in buckets: 
 * ["star", "rats", "arts"] 
 * ["ice", "cie"] 
 * 
 * The signature of unimplemented method is given:
 * 
 * public void anagramBuckets(List<String> input);
 * 
 * Submitted by sunnyhust2005
 * Solution by Thinh Lam on October 12, 2013.
 */

package facebook;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FBAnagramQ {

	public static void main(String[] args) {
		String[] argument = new String[] {"star","rats","ice","cie","arts"};
		List<String> list = Arrays.asList(argument);
		anagramBuckets(list);
	}
	
	// Main method as required by the problem. Organizes the words
	// into anagram buckets.
	public static void anagramBuckets(List<String> input) {
		Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
		
		for(String s : input) {
			addToMap(s, map);
		}
		printResults(map);
	}
	
	// If there exists a key that is an anagram of the argument string, add it to its
	// list. Else, create a new entry in the map with the argument string as the 
	// key and a new empty array list as the value.
	public static void addToMap(String string, Map<String, ArrayList<String>> map) {
		for(String key : map.keySet()) {
			if(isAnagram(key,string)) {
				map.get(key).add(string);
				return;
			}
		}
		map.put(string, new ArrayList<String>());
	}
	
	// Checks if one word is an anagram of another.
	public static boolean isAnagram(String word1, String word2) {
		Set<Character> charSet = new HashSet<Character>();
		for(Character c : word1.toCharArray())
			charSet.add(c);
		
		for(Character c2 : word2.toCharArray())
			if(!charSet.contains(c2))
				return false;
		
		return true;
	}
	
	// Prints results, adding the key of each map entry to its array list
	// value as well to complete each set.
	public static void printResults(Map<String, ArrayList<String>> map) {
		for(String key : map.keySet()) {
			List<String> output = map.get(key);
			output.add(key);
			System.out.println(output);
		}
	}
}
