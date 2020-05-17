package solutions;

public class MaxArrayProblem {
	public int maxArr(int[] A) {

		int sumMax = Integer.MIN_VALUE;
		int sumMin = Integer.MAX_VALUE;
		int substractMax = Integer.MIN_VALUE;
		int substractMin = Integer.MAX_VALUE;

		for(int i = 0; i < A.length;i++){

			int currentSum = A[i]+i;

			int currentdiff = Math.abs(A[i]-i);

			if(currentSum > sumMax){
				sumMax = currentSum;
			}else if(currentSum < sumMin){
				sumMin = currentSum;
			}

			if(currentdiff > substractMax){
				substractMax = currentdiff;
			}else if(currentdiff < substractMin){
				substractMin = currentdiff;
			}
		}

		int max1 = sumMax - sumMin;
		int max2 = substractMax - substractMin;

		if(max1>max2) return max1;

		return max2;
	}
}
