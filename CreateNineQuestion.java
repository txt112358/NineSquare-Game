/**
 * This class is used to prepare question data for the game
 */

/**
 * @author Tang, Xintian
 *
 */
public final class CreateNineQuestion {

	/**
	 * Create a NineQuestion by int[9][9] array
	 * 
	 * @param data
	 *            integer type array, the dimension is 9*9
	 * @return NineQuestion the question to be used
	 */
	public NineQuestion createByArray(int[][] data) {
		assert data.length == 9 && data[0].length == 9 : "The dimension of input data has some problems";
		NineQuestion q = new NineQuestion();
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				// Exam the data<=9
				assert data[i][j] <= 9 : "The data number has some problems" + "x=" + (i + 1) + "y=" + (j + 1);
				// If data is<=0, then it needs to be filled
				if (data[i][j] <= 0) {
					q.setNumber(i + 1, j + 1, 0, false);
				} else {
					q.setQuestion(i + 1, j + 1, data[i][j]);
				}
			}
		}
		return q;
	}
}
