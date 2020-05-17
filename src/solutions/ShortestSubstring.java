package solutions;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;



class IResult {

    /*
     * Complete the 'shortestSubstring' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

    public static int shortestSubstring(String s) {
    	 Set<Character> set = new HashSet<Character>();

         for(int i = 0; i < s.length(); i++ ) {
             set.add(s.charAt(i));
         }
    	int length = set.size();
    	int occurence = 0;
    	int end = 0 ;
    	int minimumValue = Integer.MAX_VALUE;
		String output = "" ;
		
		HashMap<Character, Integer> map = new HashMap<> ();
		for (int i = 0 ; i < s.length() ; ++i) {
			char ch = s.charAt(i) ;
			if (set.contains(ch)) {
				int c = map.containsKey(ch) ? map.get(ch) + 1 : 1 ;
				if (c == 1) occurence++;
				map.put(ch, c) ;
			}
			while (occurence == length) {					
				if (set.contains(s.charAt(end))) {
				  	int v = map.get(s.charAt(end));				  
				  	if (v - 1 == 0) {					  		
				  		occurence--;
				  	}
				  	map.put(s.charAt(end), v - 1) ;					 
				}							
			 	if (i - end + 1 < minimumValue) {
			  		minimumValue = i - end + 1 ;
			  		output = s.substring(end, i + 1) ;
			  	}	
				end++;
			}
		}				
		return output.length();
    }

}

public class ShortestSubstring {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("OUTPUT_PATH"));

        String s = bufferedReader.readLine();

        int result = IResult.shortestSubstring(s);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
