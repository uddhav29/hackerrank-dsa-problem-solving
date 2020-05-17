package solutions;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

public class ParenthesesProblem {

    static String isBalanced(String s) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('{','}');map.put('(',')');map.put('[',']');
        Stack<Character> stack = new Stack<Character>(); 
   
        for(char i : s.toCharArray()) {
        	if(map.containsKey(i)) {
        		stack.push(i);
        	}else {
        		if(stack.isEmpty()) {
        			return "NO";
        		}
        		if(i!=map.get(stack.pop())) {
                	return "NO";
                }
        	}     
         }

        if(stack.isEmpty()) return "YES";
        return "NO";
}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int tItr = 0; tItr < t; tItr++) {
            String s = scanner.nextLine();

            String result = isBalanced(s);
            System.out.println(result);
            bufferedWriter.write(result);
            bufferedWriter.newLine();
        }

        bufferedWriter.close();

        scanner.close();
    }
}
