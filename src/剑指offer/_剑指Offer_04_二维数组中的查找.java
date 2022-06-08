package 剑指offer;

public class _剑指Offer_04_二维数组中的查找 {
	public boolean findNumberIn2DArray(int[][] matrix, int target) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return false;
		}
		
		int n = matrix.length;
        int m = matrix[0].length;
        
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {       	
        	if (matrix[i][j] == target) {
        		return true;
        	} else if (matrix[i][j] > target) {
        		j--;
        	} else {
        		i++;
        	}
        }
        return false;
    }
}
