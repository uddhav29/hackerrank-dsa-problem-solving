package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class ManipulateArray {

    static long arrayManipulation(int n, int[][] queries) {
    	
    	long maximumValue = Integer.MIN_VALUE;
    	
    	long[] outputArray = new long[n];
    	
    	Arrays.fill(outputArray, 0);
    	
    	for(int i = 0 ; i < queries.length; i++) {
    			for(int j = queries[i][0]-1;j<queries[i][1];j++) {
    					outputArray[j]+=queries[i][2];
    	}	
    	
    	}
    	for(int i = 0 ;i<outputArray.length;i++) {
    		if(outputArray[i]>maximumValue) {
    			maximumValue=outputArray[i];
    		}
    	}
    	return maximumValue;
    }	

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        String[] nm = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nm[0]);

        int m = Integer.parseInt(nm[1]);

        int[][] queries = new int[m][3];

        for (int i = 0; i < m; i++) {
            String[] queriesRowItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 3; j++) {
                int queriesItem = Integer.parseInt(queriesRowItems[j]);
                queries[i][j] = queriesItem;
            }
        }

        long result = arrayManipulation(n, queries);
        System.out.println(result);
        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
