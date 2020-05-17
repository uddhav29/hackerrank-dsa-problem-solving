package solutions;


import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class MaximumIndexProduct {

	static long solve(int[] arr) {
		long result = 0;
		
		for(int i = 0; i<arr.length; i++) {
			long left = -1, right = -1;
			
			for(int j = i-1; j >= 0; j--){
                if(arr[j] > arr[i]){
                    left = j;
                    break;
                }
            }
            if(left == -1)
                continue;
            
            for(int k = i+1; k < arr.length; k++){
                if(arr[k] > arr[i]){
                    right = k;
                    break;
                }
            }
            if(right == -1)
                continue;
            long temp = (left+1)*(right+1);
			if(temp>result)result=temp;
		}
    	
    	
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int arrCount = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[arrCount];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int arrItr = 0; arrItr < arrCount; arrItr++) {
            int arrItem = Integer.parseInt(arrItems[arrItr]);
            arr[arrItr] = arrItem;
        }

        long result = solve(arr);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
