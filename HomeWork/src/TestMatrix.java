
public class TestMatrix {

	public static void main(String[] args) {
		
		double[][] array1 = {{33, 34, 12},
						  {33, 19, 10},
						  {43, 71, 21}};
		
//		double[][] array1 = {{1, 3, 5},
//				  		  	{5, 3, 4},
//				  		  	{11, 6, 7}};
		
		Matrix matrix1 = new Matrix(array1);
		
		System.out.println("matrix1");
		matrix1.printMatrixArray();
		System.out.println(matrix1.determinant());
		matrix1.printMatrixArray();
	}

}
