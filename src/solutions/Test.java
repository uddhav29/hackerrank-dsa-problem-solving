package solutions;
import java.io.*;
import java.util.*;

class Test {
	public static void main(String args[] ) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		PrintWriter wr = new PrintWriter(System.out);

		int N = Integer.parseInt(br.readLine().trim());

		int[] A = new int [N];

		String[] inp = br.readLine().split(" ");

		for(int i=0;i<N;i++) 
		{
			A[i] = Integer.parseInt(inp[i]);
		}
		int Q = Integer.parseInt(br.readLine().trim());
		for(int i=0;i<Q;i++) {
			String[] inp1 = br.readLine().split(" ");
			int L = Integer.parseInt(inp1[0]);
			int R = Integer.parseInt(inp1[1]);
			int out_ = solve(N, A, L ,R);
			System.out.println(out_);
		}
		wr.close();
		br.close();
	}
	static int solve(int N, int[] A, int L, int R) {

		if(L==R) return A[L-1]; 
		int[] temp =  Arrays.copyOfRange(A, L-1, R-1); 
		Arrays.parallelSort(temp); 
		return  temp[(temp.length-1)/2];

	}

	public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
		// Write your code here
		List<Integer> sequence = new ArrayList<Integer>();
		int lastAnswer = 0;
		for(List<Integer> row:queries) {
			int seq = (row.get(0)^lastAnswer)%n;
			if(row.get(0)==1) {
				sequence.set(seq, row.get(1));
			}
			if(row.get(0)==2) {
				lastAnswer=row.get(1)%row.size();
			}
		}
		return sequence;
	}
}
