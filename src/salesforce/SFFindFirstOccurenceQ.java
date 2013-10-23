/**
 * Glassdoor question..
 * 
 * Find the first index of the substring without using a java library 
 * function or regular expressions.
 * 
 * Solved on October 23, 2013.
 */
package salesforce;

public class SFFindFirstOccurenceQ {
	public static void main(String[] args) {
		System.out.println(firstIndexOfSubstring("dworldhellow world", "world"));
		// Test from Glassdoor.
		System.out.println(firstIndexOfSubstring("internnet", "net"));
	}

	public static int firstIndexOfSubstring(String s, String p) {
		int firstIndex = 0;
		int lastIndex = 0;
		
		while(lastIndex < s.length()) {
			// If there is an initial match, update firstIndex.
			if(s.charAt(lastIndex) == p.charAt(0))
				firstIndex = lastIndex;

			// If we have searched beyond the length of the pattern
			// or the pattern stopped matching, reset firstIndex.
			else if(lastIndex-firstIndex >= p.length() || s.charAt(lastIndex) != p.charAt(lastIndex-firstIndex))
				firstIndex = -1;

			// If everything checks and the last character of the pattern
			// is the same as the current string index, we've found
			// the first occurence.
			else if(s.charAt(lastIndex) == p.charAt(p.length()-1))
				return firstIndex;

			lastIndex++;
		}
		return firstIndex;
	}
}
