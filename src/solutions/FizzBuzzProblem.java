package solutions; 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;



class Result {

	public static void fizzBuzz(int i) {
		
		for(int n=1;n<=i;n++) {
			
			if(n%5==0&&n%3==0) {
			System.out.println("FizzBuzz");
				}else if(n%3==0) {
			System.out.println("Fizz");
					}else if(n%5==0) {
			System.out.println("Buzz");
						}else {
			System.out.println(n);
		}
	}


	}

}

public class FizzBuzzProblem {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(bufferedReader.readLine().trim());

		Result.fizzBuzz(n);

		bufferedReader.close();
	}
}
