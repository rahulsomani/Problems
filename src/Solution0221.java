
public class Solution0221 {
	public static void main(String[] args) {
		char[][] matrixTest1 = {
				{'1','0','1','0','0'},
				{'1','0','1','1','1'},
				{'1','1','1','1','1'},
				{'1','0','0','1','0'}
		};                
		
		Solution0221 o = new Solution0221();
		
		//System.out.println(o.maximalSquare(matrixTest1)); //expected 4

	}
	public int maximalSquare(char[][] matrix) {
		
		
		int m = matrix.length;
		int n = matrix[0].length;
		
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				
				if (matrix[i][j] == '1') {
					
				}
				
			}
		}
		return 0;
	}

	private int maxSquare(char[][] matrix, int row , int column) {
		
		
			return 0;
		
	}
	


}


