/**
 * This class is used to record the question and answers
 */

/**
 * @author Tang, Xintian
 *
 */
public class NineQuestion {

	private int[][] question = new int[9][9];
	private boolean[][] isQuestion = new boolean[9][9];

	/**
	 * Get the number of certain position
	 * 
	 * @param x
	 *            The x position of the question
	 * @param y
	 *            The y position of the question
	 * @return The number based on position
	 */
	public int getNumber(int x, int y) {
		assert this.isPositionLegal(x, y) : "The position is illegal";
		return this.question[x - 1][y - 1];
	}

	/**
	 * Judge whether the number of certain position belongs to the question
	 * 
	 * @param x
	 *            The x position of the question
	 * @param y
	 *            The y position of the question
	 * @return Whether the number belongs to the question
	 */
	public boolean isQuestion(int x, int y) {
		assert this.isPositionLegal(x, y) : "The position is illegal";
		return this.isQuestion[x - 1][y - 1];
	}

	/**
	 * Set the number based on integer type number
	 * 
	 * @param x
	 *            The x position of the number
	 * @param y
	 *            The y position of the number
	 * @param number
	 *            The number to be set
	 * @param isQuestion
	 *            Whether it is a question or an answer
	 */
	public void setNumber(int x, int y, int number, boolean isQuestion) {
		assert this.isPositionLegal(x, y) : "The position is illegal";
		assert this.isNumberLegal(number) : "The input number is illegal";
		this.question[x - 1][y - 1] = number;
		this.isQuestion[x - 1][y - 1] = isQuestion;
	}

	/**
	 * Set the question number
	 * 
	 * @param x
	 *            The x position of the number
	 * @param y
	 *            The y position of the number
	 * @param number
	 *            The number to be set
	 */
	public void setQuestion(int x, int y, int number) {
		assert this.isPositionLegal(x, y) : "The position is illegal";
		assert this.isNumberLegal(number) : "The input number is illegal";
		this.setNumber(x, y, number, true);
	}

	/**
	 * Set the answer number
	 * 
	 * @param x
	 *            The x position of the number
	 * @param y
	 *            The y position of the number
	 * @param number
	 *            The number to be set
	 */
	public void setAnswer(int x, int y, int number) {
		assert this.isPositionLegal(x, y) : "The position is illegal";
		assert this.isNumberLegal(number) : "The input number is illegal";
		this.setNumber(x, y, number, false);
	}

	/**
	 * Delete the number of certain position
	 * 
	 * @param x
	 *            The x position of the number
	 * @param y
	 *            The y position of the number
	 * @return Whether the delete action is successful
	 */
	public boolean deleteNumber(int x, int y) {
		assert this.isPositionLegal(x, y) : "The position is illegal";
		if (this.question[x - 1][y - 1] < 0) {
			return false;
		} else {
			this.question[x - 1][y - 1] = -1;
			return true;
		}
	}

	/**
	 * Judge whether the input position is legal
	 * 
	 * @param x
	 *            The x position of the number
	 * @param y
	 *            The y position of the number
	 * @return Whether the position is legal
	 */
	public boolean isPositionLegal(int x, int y) {
		if (x < 1 || x > 9 || y < 1 || y > 9) {
			return false;
		} else {
			return true;
		}
	}

	/**
	 * Judge whether the input number is legal
	 * 
	 * @param number
	 *            The number to be input
	 * @return Whether the number is legal
	 */
	public boolean isNumberLegal(int number) {
		if (number < 1 || number > 9) {
			return false;
		} else {
			return true;
		}
	}

}
