package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Miscellaneous {

	public static void main(String[] args) {
		//int a= getMinimizedString("aaaa",3);
		int[] A = {1,0,0,0,0,0,0};
		//System.out.println(solve(2, A));
		//spiralAdd(5);
		ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> b = new ArrayList<Integer>();
		ArrayList<Integer> c = new ArrayList<Integer>();
		b.add(1);
		b.add(1);
		c.add(0);
		c.add(0);
		a.add(b);
		a.add(c);
		setZeroes(a);
	}

	private static int[][] spiralAdd(int A) {
		int row = A;
		int i, k = 0, l = 0; 
		int[][] spiralArray = new int[A][A];
		int value = 1;

		while (k < A && l < A) { 

			for (i = l; i < A; ++i) { 
				spiralArray[k][i] = value; 
				value++;
			} 
			k++; 

			for (i = k; i < A; ++i) { 
				spiralArray[i][A - 1] = value;
				value++;
			} 
			A--; 


			if (k < row) { 
				for (i = A - 1; i >= l; --i) { 
					spiralArray[row - 1][i]=value;
					value++;
				} 
				row--; 
			} 


			if (l < A) { 
				for (i = row - 1; i >= k; --i) { 
					spiralArray[i][l]=value; 
					value++;
				} 
				l++; 
			} 
		} 
		return spiralArray;
	}

	public int[] nextPermutation(int[] A) {
		int i=0;

		for(i = A.length-1; i>0;i--){

			if(A[i]>A[i-1]){
				break;
			}

		}

		int minimumIndex = i;
		int minValue = A[i-1];

		for(int j = i;j<A.length;j++) {
			if(A[j]<minValue) {
				minValue = A[j];
				minimumIndex = j;
			}
		}

		int temp = A[i-1];
		A[i-1] = A[minimumIndex];
		A[minimumIndex]=temp;

		Arrays.sort(A,i,A.length);

		return A.clone();




	}

	public static void setZeroes(ArrayList<ArrayList<Integer>> a) {

		int rowIndex = 0;
		boolean rowFlag = false,colFlag=false;
		
		for(ArrayList<Integer> parent : a){ 
			int colIndex = 0;
			for(int child : parent){
				if(child==0){
					if(rowIndex==0){
						rowFlag=true;
					}
					if(colIndex==0) {
						colFlag=true;
					}
					
					a.get(0).set(colIndex, -1);
					a.get(rowIndex).set(0, -1);
				}
				colIndex++;
			}
			rowIndex++;
		}


		rowIndex = 1;
		for(ArrayList<Integer> parent : a){
			int colIndex = 1;
			for(int child : parent){
				if(rowIndex<a.size()&&colIndex<a.get(0).size()) {
					if(a.get(rowIndex).get(0)==-1||a.get(0).get(colIndex)==-1){
						a.get(rowIndex).set(colIndex, 0);
					}
				}
				colIndex++;
			}
			rowIndex++;
		}

		for(ArrayList<Integer> parent : a){

			for(int child : parent){
				System.out.print(child+" ");
			}
			System.out.println();
		}

		
		if(rowFlag) {
			Collections.fill(a.get(0), 0);
		}
		for(int i=1;i<a.get(0).size();i++) {
			if(a.get(0).get(i)==-1) {
				a.get(0).set(i,0);
			}
		}
		int newRow = 0;
		while(a.size() > newRow) {
			if(a.get(newRow).get(0)==-1) {
				a.get(newRow).set(0, 0);
			}
			newRow++;
		}
		if(colFlag) {
			int row = 0;
			while(a.size() > row) {
				a.get(row).set(0, 0);
				row++;
			}
		}
			
		
		
		/*
		 * if(a.get(0).get(0) == -1) { Collections.fill(a.get(0), 0); }
		 * 
		 * for(int i = 0; i<a.size();i++) { if(a.get(i).get(0)==-1) { a.get(i).set(0,0);
		 * } }
		 */
		System.out.println("---------------------------");
		for(ArrayList<Integer> parent : a){

			for(int child : parent){
				System.out.print(child+" ");
			}
			System.out.println();
		}

	}

	public static int solve(int A, int[] B) {
		//newspaper daily read problems
		int day = 0;
		for(int i = 0; A>0 ;i++){
			day++;
			A = A - B[i%7];

			if(day==7 && A>0){
				day = 0;
			}    
		}
		return day;
	}

	private static int Maxgcd(int[] A, int B) {
		int max = Integer.MIN_VALUE;
		for(int i = 0; i<A.length;i++) {
			int k = 0;
			for(int j = 0; j<A.length;j++) {
				if(A[j]%A[i]!=0) {	
					k++;
				}
			}
			if(k<B&& max < A[i]) {
				max = A[i];
			}

		}
		return max;
	}

	private static int getMinimizedString(String string, int i) {
		Map<Character, Integer> map = new TreeMap<Character, Integer>();

		for(char c : string.toCharArray()) {
			if(!map.containsKey(c)) {
				map.put(c, 0);
			}else {
				map.computeIfPresent(c, (key,value)-> value+1);
			}			
		}
		Map<Integer, Character> reverseMap = new TreeMap<Integer, Character>();
		for(char c : map.keySet()) {
			reverseMap.put(map.get(c), c);	
		}

		return 0;
	}

	private static int solve(int[] A, int B) {

		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;

		for(int i=0 ; i<A.length; i++) {
			if(A[i]>max) {
				max = A[i];
			}
			if(A[i]<min) {
				min = A[i];
			}


		}

		int a = Math.abs(max);
		int b = Math.abs(min);
		b = b + B;

		return Math.abs(a-b);
	}
	
	static int CountDIGIT(String str) {
        int digitCount=0;
    	for(int i=0;i<str.length();i++) {
        	if(Character.isDigit(str.charAt(i))) {
        		digitCount++;
        	}
        }
    	return digitCount;
    }

    static int CountLETTER(String str) {
    	 int letterCount=0;
     	for(int i=0;i<str.length();i++) {
         	if(Character.isLetter(str.charAt(i))) {
         		letterCount++;
         	}
         }
     	return letterCount;

    }

}
