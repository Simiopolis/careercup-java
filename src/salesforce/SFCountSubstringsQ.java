/**
 * Link: http://www.careercup.com/question?id=15883676
 * find the substring count from a string without string functions in java? 
 * Given String str = "abcdefghcde"; 
 * String find = "cde"; 
 * Count occurrences of cde in String str
 * 
 * Solved on October 25, 2013.
 */
package salesforce;

public class SFCountSubstringsQ {
	public static void main(String[] args) {
		System.out.println(substringsCount("abcdefghcde", "cde"));
		System.out.println(substringsCount("", ""));
		System.out.println(substringsCount(null, null));
		System.out.println(substringsCount("a", "aaa"));
		System.out.println(substringsCount("aaaaa", "aaa"));
		System.out.println(substringsCount("aaaaa", "aa"));
	}
	
	public static int substringsCount(String string, String pattern) {
		if(string == null || pattern == null)
			return -1;
		char[] str = string.toCharArray();
		char[] pat = pattern.toCharArray();
		
		int startIndex = 0;
		int lastIndex = 0;
		int count = 0;
		
		while(lastIndex < str.length) {
			if(lastIndex - startIndex >= pat.length || str[lastIndex] != pat[lastIndex-startIndex]) {
				startIndex++;
				lastIndex = startIndex;
			} else if(lastIndex - startIndex == pat.length-1) {
				count++;
				startIndex = lastIndex+1;
			}
			lastIndex++;
		}
		return count;
	}
}
