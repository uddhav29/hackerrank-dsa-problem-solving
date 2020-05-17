package solutions;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class LargestRectangle {

	// Complete the largestRectangle function below.
	static long largestRectangle(int[] h) {
		long result = Integer.MIN_VALUE;

		for(int i = 0;i<h.length;i++) {
			int currentResult = h[i];
			for(int j = i-1;j>=0;j--) {
				if(h[i]>h[j])break;
				currentResult = currentResult + h[i];
			}
			for(int j = i+1;j<h.length;j++) {
				if(h[i]>h[j])break;
				currentResult = currentResult + h[i];
			}
			if(currentResult>result) {
				result = currentResult;
			}
		}
		
		return result;


	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

		int n = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		int[] h = new int[n];

		String[] hItems = scanner.nextLine().split(" ");
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int i = 0; i < n; i++) {
			int hItem = Integer.parseInt(hItems[i]);
			h[i] = hItem;
		}

		long result = largestRectangle(h);
		System.out.println(result);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}
}
