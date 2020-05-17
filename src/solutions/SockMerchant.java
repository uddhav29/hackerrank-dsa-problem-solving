package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class SockMerchant {

    static int sockMerchant(int n, int[] ar) {
    	int result = 0;
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	
    	for(int i =0; i<ar.length;i++) {
    		if(map.containsKey(ar[i])) {
    			int value = map.get(ar[i]);
    			 map.put(ar[i],value+1);
    		}else map.put(ar[i],1);
    	}
    	
    	for(int i : map.keySet()) {
    		result = result + map.get(i)/2;
    	}
    	return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] ar = new int[n];

        String[] arItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arItem = Integer.parseInt(arItems[i]);
            ar[i] = arItem;
        }

        int result = sockMerchant(n, ar);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
    }
}
