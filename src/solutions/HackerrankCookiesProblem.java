package solutions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;
import java.util.Scanner;



public class HackerrankCookiesProblem {

	static int cookies(int k, int[] A) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>(); 
        for(int i = 0; i < A.length; i++) {
			pQueue.add(A[i]);
		}
        
        int operations = 0;
        while(pQueue.size()>1) {
            
            int leastMin = pQueue.poll();
            int secMin = pQueue.poll();
            
            if(leastMin>=k)break;
            else {
                pQueue.add((leastMin*1)+(secMin*2));
                operations++;
            }
        }
        if(pQueue.size()==1 && pQueue.peek()<k) {
            return -1;
        }
        return operations;}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) throws IOException {
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("output"));

		String[] nk = scanner.nextLine().split(" ");

		int n = Integer.parseInt(nk[0].trim());

		int k = Integer.parseInt(nk[1].trim());

		int[] A = new int[n];

		String[] AItems = scanner.nextLine().split(" ");

		for (int AItr = 0; AItr < n; AItr++) {
			int AItem = Integer.parseInt(AItems[AItr].trim());
			A[AItr] = AItem;
		}

		int result = cookies(k, A);
		System.out.println(result);
		bufferedWriter.write(String.valueOf(result));
		bufferedWriter.newLine();

		bufferedWriter.close();
	}
}
