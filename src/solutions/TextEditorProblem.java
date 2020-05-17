package solutions;

import java.util.Scanner;
import java.util.Stack;

public class TextEditorProblem {


	public static void main(String[] args) {
		editor();
	}
	
	
	public static void editor() {
		Scanner sc = new Scanner(System.in);

		Stack<String> operations = new Stack<String>();

		int input = Integer.parseInt(sc.nextLine());
		operations.push("");
		while(input>0){

			String[] query = sc.nextLine().split(" ");

			if(query[0].equals("1")){
				String appended = operations.peek().concat(query[1]);
				operations.push(appended);
			}
			if(query[0].equals("2")){
				String top = operations.peek();
				if(Integer.parseInt(query[1])==top.length()) {
					operations.push("");
				}else {
					String edited = top.substring(0, top.length()-Integer.parseInt(query[1]));
					operations.push(edited);
				}
			}
			if(query[0].equals("3")){
				System.out.println(operations.peek().charAt(Integer.parseInt(query[1])-1));
			}
			if(query[0].equals("4")){
				operations.pop();
			}
			input--;
		}

	}
}

