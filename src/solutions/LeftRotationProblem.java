package solutions;

import java.io.*;
import java.util.*;

public class LeftRotationProblem {

    static int[] rotLeft(int[] a, int d) {

		int[] rotatedArray = new int[a.length];
		
		int j = 0; 	

		for(int i = d ; i<a.length ;i++) {
    		rotatedArray[j++] = a[i];
    	}
    	for(int i = 0; i < d; i++) {
    		rotatedArray[j++] = a[i];
    	}
    	
    	return rotatedArray;


    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("LeftRotationOutput"));

        String[] nd = scanner.nextLine().split(" ");

        int n = Integer.parseInt(nd[0]);

        int d = Integer.parseInt(nd[1]);

        int[] a = new int[n];

        String[] aItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int aItem = Integer.parseInt(aItems[i]);
            a[i] = aItem;
        }

        int[] result = rotLeft(a, d);
        int a1=3;
        int b=2;
        System.out.print(a1/b);
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i]+" ");
        }

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
