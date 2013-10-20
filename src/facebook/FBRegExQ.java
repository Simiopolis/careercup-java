/**
 * Link: http://www.careercup.com/question?id=6631993756352512
 * 
 * Given a regular expression with characters a-z, ' * ', ' . ' 
 * the task was to find if that string could match another string with characters 
 * from: a-z where ' * ' can delete the character before it, and ' . ' could match 
 * whatever character. ' * ' always appear after a a-z character. 
 * Example: 
 * isMatch("a*", "") = true; 
 * isMatch(".", "") = false; 
 * isMatch("ab*", "a") = true; 
 * isMatch("a.", "ab") = true; 
 * isMatch("a", "a") = true;
 * 
 * NOTE: * can only delete the character before it, but * can be skipped. So 
 * "a*" is "a" or is an empty string ""
 * 
 * Submitted by kevin
 * Solved on October 20, 2013.
 */
package facebook;


public class FBRegExQ {
	public static void main(String[] args) {
		System.out.println(isMatch("a*", ""));
		System.out.println(isMatch(".", ""));
		System.out.println(isMatch("ab*", "a"));
		System.out.println(isMatch("a.", "ab"));
		System.out.println(isMatch("a", "a"));
		System.out.println(isMatch("ada*d*a","ada"));
	}
	
	public static boolean isMatch(String regex, String target) {
		int rLength = regex.length();
		int tLength = target.length();
		
		// If there is only one character in both arguments, simply
		// check them for equivalency.
		if(rLength == 1 && tLength == 1)
			return regex.charAt(0) == target.charAt(0);
		// If only the regex is of length one, then return false as we know
		// it won't be able to match the entire target.
		if(rLength == 1)
			return false;
		// If there is only one character in the target, check if there is
		// a single '*' regex.
		if (tLength == 1 && rLength == 2)
			return regex.charAt(1) == '*';
		// If the target is empty, then the regex successfully matched
		// the target.
		if (tLength == 0)
			return true;
		
		// If the last character is a '*', check if target matches the regex with or without the 
		// '*' character and continue recursing.
		if(regex.charAt(rLength-1) == '*') {
			return (isMatch(regex.substring(0, rLength-1), target) || isMatch(regex.substring(0, rLength-2), target)) &&
					isMatch(regex.substring(0, rLength-2), target);
		} 
		// If the last character is a '.', just continue recursing because we don't care
		// about the last character.
		else if(regex.charAt(rLength-1) == '.')
			return isMatch(regex.substring(0, rLength-1), target.substring(0, tLength-1));
		// The only other possibility is that the last character is a regular letter, in which
		// case we simply check the last characters of both arguments for equivalency and 
		// continue recursing.
		else
			return (regex.charAt(rLength-1) == target.charAt(tLength-1)) && isMatch(regex.substring(0, rLength-1), target.substring(0, tLength-1));
	}
}
