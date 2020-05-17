package solutions;

public class SubSolution {

	public static void main(String[] args) {

		int[] A = {3,5,2,4,1,1};
		System.out.println(sub("abbaba",A,"ab"));
	}

	private static int sub(String A, int[] B, String C) {
		
		int min = Integer.MAX_VALUE;

		for(int i =0; i<A.length();i++){

			for(int j = i; j<A.length();j++){

				int k = 0;
				String sub = A.substring(i,j);
				int sum = 0;    
				if(sub.length()>=C.length()){
					for(int l = 0; l<sub.length()&&k<C.length();l++){
						if(C.charAt(k)==sub.charAt(l)){
							sum = sum + B[l];
							k++;
						}
					}
					System.out.println(sum);
					if(k==C.length()&& sum < min){
						min = sum;
					}
				}



			}    

		}
		if(min == Integer.MAX_VALUE){
			return -1;
		}
		return min; }

	private static void perform(String string) {
		String str = "AbcaZeoB";
		String a = str.replaceAll( "[A-Z]", "" ).replaceAll( "[aeiou]", "#" );
		System.out.println(a+a);
	}

	public int solve(int[] A, int B) {

		int result = 1;

		for(int i = 0; i< A.length;i++){
			int j = i;
			while(A[i]+A[i]+A[j]<B && j < A.length - 1){
				j++;
			}
			if( j < A.length - 1){
				result = result + (A.length - j);
			}
		}
		return result;
	}

}
