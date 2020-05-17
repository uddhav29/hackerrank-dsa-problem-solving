package solutions;

import java.util.ArrayList;
import java.util.HashMap;

public class FastExponentiation {

	public static void main(String[] args) {
		
		fastExponentiation(2, 7);
			
	}
	static public int power(final int a, final int N) {
		if (N == 0) {
	            return 1;
	        } else {
	            final int R = power(a, N / 2);
	            if (N % 2 == 0) {
	                return R * R;
	            } else { 
	                return R * R * a;
	            }
	        }
	    }

	
	static long fastExponentiation(int base, int exponent) {
		int MOD = 1000000007;
		long result = 1;
	    while(exponent > 0) {
	       if(exponent % 2 == 1) {
	    	   result = (result*base) % MOD;
	    	 }
	       base = (base*base) % MOD;
	       exponent /= 2;
	    }
	    return result%MOD;
	}
	
	private static void getMinimumNumberOfTime(ArrayList<Integer> arr1) {
		int A[] = {2,3,1,5,4};
		int B[] = {1,3,5,4,2};
		boolean[] marked = new boolean[6];
		int  i =0;
		int j =0;
		int cycles = 0;

		while(i<B.length) {

			while(A[j]!=B[i]) {
				if(!marked[A[j]]) {
					cycles++;
				}
				j++;
				if(j>=A.length) {
					j=0;
				}
			}
			marked[A[j]]=true;
			
			cycles++;
		i++;
		}
		System.out.println(cycles);
	}

	private static void getMinimumNumberOfTeams(ArrayList<Integer> A) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		int maxFreq=0;
		int answer = 0;
		for(int i =1;i<=500;i++) {
			if(i%3==0) {
				answer++;
			}else if(i%7==0) {
				answer++;
			}else if(i%9==0) {
				answer++;
			}
		}
		System.out.println("%%"+answer);
		for(int i = 0; i<A.size()-1;i++) {
			if(map.containsKey(A.get(i))) {
				map.computeIfPresent(A.get(i), (key,value)->value+1);
			}else {    			
				map.put(A.get(i), 1);
			}
		}
		for(Integer i : map.keySet()) {
			if(map.get(i)>maxFreq) {
				maxFreq=map.get(i);
						
			}
		}
		
		System.out.println(maxFreq);
	}

	private static void getCut1(String string, int b) {
		int maxLength = Integer.MIN_VALUE;
		for(int i = 0 ; i<= string.length(); i++) {
			for(int j = i+b; j<=string.length(); j++) {
				String sub = string.substring(i, j);
				System.out.println(sub);
				int bcount=0;
				for(int k = 0; k<=sub.length()-1;k++) {
					if(sub.charAt(k)=='b') {
						bcount++;	
					}

				}
				if(bcount<=b&&sub.length()>maxLength) {
					maxLength=sub.length();
				}
			}

		}
		System.out.println(maxLength);
	}

}
