/**
 * Careercup.com question(http://www.careercup.com/question?id=6741345771192320)
 * 
 * I need a function that takes the name of the movie to look up and 
 * the width of the letter grid, and computes the key presses that 
 * will enter that string on the DVR grid. The output should be a 
 * string, with "u", "d", "l", "r", and "!" corresponding to up, 
 * down, left, right, and select. 
 * 
 * For example, with a grid of width 5, 
 * a b c d e 
 * f g h i j 
 * k l m n o 
 * p q r s t 
 * u v w x y 
 * z 
 * the movie "up" would be "dddd!u!".
 * 
 * Submitted by pjsky
 */

package google;

public class GoogleMovieLookup {
	public static void main(String[] args) {
		lookUpMovie("up", 5);
	}
	
	public static void lookUpMovie(String str, int width) {
		char[] arr = str.toCharArray();
		
		int prevPosition = 0;
		int prevRow = 0;
		
		for(char c : arr) {
			int position =  (c - 'a') % width;
			int row = (c - 'a') / width;
			
			if(position - prevPosition != 0) {
				if(position - prevPosition > 0)
					printCommand("r", position-prevPosition);
				else if(position - prevPosition < 0)
					printCommand("l", (position-prevPosition)*-1);
				prevPosition = position;
			}
			
			if(row - prevRow != 0) {
				if(row - prevRow > 0)
					printCommand("d", row-prevRow);
				else if(row - prevRow < 0)
					printCommand("u", (row-prevRow)*-1);
				prevRow = row;
			}
			printCommand("!", 1);
		}
	}
	
	public static void printCommand(String command, int n) {
		for(int i=0; i < n; i++)
			System.out.print(command);
	}
}
