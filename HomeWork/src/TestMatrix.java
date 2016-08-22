
public class TestMatrix {

	public static void main(String[] args) {
		Matrix matrix = new Matrix(5,5);
		for(int i = 0; i < 5; i++) {
			for(int ii = 0; ii < 5; ii++) {
				matrix.matrixArray[i][ii] = ii;
			}
		}
		matrix.printMatrixArray();
		matrix.numberMultiplication(2);
		matrix.printMatrixArray();
	}

}
