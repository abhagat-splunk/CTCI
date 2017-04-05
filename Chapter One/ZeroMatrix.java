public class ZeroMatrix{
	public static void setZeroes(int[][] matrix){
		boolean[] row = new boolean[matrix.length];
		boolean[] col = new boolean[matrix[0].length];

		for(int i=0;i<row.length;i++){
			for(int j=0;j<col.length;j++){
				if(matrix[i][j]==0){
					row[i] = true;
					col[j] = true;
				}
			}
		}
		for(int i=0;i<row.length;i++){
			if(row[i]){
				nullifyRow(matrix,i);
			}
		}
		for(int j=0;j<col.length;j++){
			if(col[j]){
				nullifyCol(matrix,j);
			}
		}
	}
	public static void nullifyRow(int[][] matrix, int row){
		for(int i=0;i<matrix[0].length;i++){
			matrix[row][i]=0;
		}
	}
	public static void nullifyCol(int[][] matrix, int col){
		for(int j=0;j<matrix.length;j++){
			matrix[j][col]=0;
		}
	}
	public static void main(String args[]){
		int[][] matrix = {{1,0,1},{2,3,4},{5,6,0},{7,8,9}};
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
		setZeroes(matrix);
		for(int i=0;i<matrix.length;i++){
			for(int j=0;j<matrix[0].length;j++){
				System.out.print(matrix[i][j]);
			}
			System.out.println();
		}
	}
}