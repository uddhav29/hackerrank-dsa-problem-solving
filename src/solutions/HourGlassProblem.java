package solutions;

import java.io.*;
import java.util.*;

public class HourGlassProblem {

	// Complete the hourglassSum function below.
	static int hourglassSum(int[][] arr) {
		
		int maxHourGlassSum = Integer.MIN_VALUE;

		for(int i = 0 ; i<arr.length ;i++) {

			for(int j = 0; j<arr.length;j++) {
				
				if( i-1>=0 && j-1>=0 && j+1 <= arr.length-1 && i+1 <= arr.length-1) {
					
					int sum = getHourGlassSum(arr,i ,j);
					
					if(sum > maxHourGlassSum) {
					
						maxHourGlassSum = sum;
					}
				}

			}
		}

		return maxHourGlassSum;


	}

	

	private static int getHourGlassSum(int[][] arr, int i, int j) {
		
		return arr[i-1][j-1]+arr[i-1][j]+arr[i-1][j+1]
					        +arr[i][j]+
			   arr[i+1][j-1]+arr[i+1][j]+arr[i+1][j+1];
	}



	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

		int[][] arr = new int[6][6];

		for (int i = 0; i < 6; i++) {
			String[] arrRowItems = scanner.nextLine().split(" ");
			scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

			for (int j = 0; j < 6; j++) {
				int arrItem = Integer.parseInt(arrRowItems[j]);
				arr[i][j] = arrItem;
			}
		}
		getCut("abbaaba", 1);
		int result = hourglassSum(arr);
		System.out.println(result);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();

		scanner.close();
	}



	private static void getCut(String string, int b) {
		int replaced = 0;
		boolean allreplaced = false;
		//String temp = string;
		char[] temp = string.toCharArray();
		for(int i = temp.length; i<=0; i--) {
			if(temp[i]=='b' && !allreplaced) {
				temp[i]='a';
				replaced++;
				if(replaced>b) {
					allreplaced=true;
				}
				
			}
		}
		int count = 0;
		for(int i = 0; i<=temp.length;i++) {
			if(temp[i]=='a') {
				count++;
			}else if(temp[i]=='b') {
				count=0;
			}
		}
		System.out.println(count);
	}
}

