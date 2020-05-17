package solutions;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class MaximumElementStack {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in); 
		int top = 0; 
		int input = Integer.parseInt(sc.nextLine()); 
		int[] stack = new int[input];
		int[] maxArray= new int[input]; 
		int leftMax = 0;
		while(input>0){

			String[] query = sc.nextLine().split(" ");

			if(query[0].equals("1"))
			{
				int value = Integer.parseInt(query[1]);
				stack[top]= value; 

				if(value>leftMax) { 
					leftMax = value; 
				}
				top++; 
				maxArray[top] =leftMax;
			}
			if(query[0].equals("2"))
			{ 
				top--; 
				leftMax = maxArray[top]; 
			}
			if(query[0].equals("3"))
			{
				System.out.println(maxArray[top]); 
			}
			input--; 
		}
	}




	String twoStrings(String s1, String s2) {

		Set<Character> set = new HashSet<Character>();

		for(char c : s1.toCharArray()) {
			set.add(c);
		}

		for(char c : s2.toCharArray()) {
			if(set.contains(String.valueOf(c))) {
				return "YES";
			}
		}
		return "NO";
	}
}