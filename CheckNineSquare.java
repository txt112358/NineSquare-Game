/**
 * This class is used to exam whether the insert data fits the game rule
 */

/**
 * @author Tang, Xintian
 *
 */
public class CheckNineSquare {
	/**
	 * Create row NumberLaw based on row number and the NineQuestion
	 * 
	 * @param q
	 *            The question to be used
	 * @param x
	 *            The row number
	 * @return The NumberLaw of the row
	 */
	public NumberLaw createRowLaw(NineQuestion q, int x) {
		assert q != null : "The input q should not be null";
		assert x >= 1 && x <= 9 : "The input row number should<=9 and >=1";
		NumberLaw law = new NumberLaw();
		for (int i = 1; i <= 9; i++) {
			if (q.getNumber(x, i) > 0)
				law.addBannedNumber(q.getNumber(x, i));
		}
		return law;
	}

	/**
	 * Create column NumberLaw based on column number and the NineQuestion
	 * 
	 * @param q
	 *            The question to be used
	 * @param x
	 *            The column number
	 * @return The NumberLaw of the column
	 */
	public NumberLaw createColumnLaw(NineQuestion q, int y) {
		assert q != null : "The input q should not be null";
		assert y >= 1 && y <= 9 : "The input column number should<=9 and >=1";
		NumberLaw law = new NumberLaw();
		for (int i = 1; i <= 9; i++) {
			if (q.getNumber(i, y) > 0)
				law.addBannedNumber(q.getNumber(i, y));
		}
		return law;
	}

	/**
	 * Get the start position of the order x
	 * 
	 * @param x
	 *            The input column/row number
	 * @return The start position of column/row number
	 */
	private final int getStartPosition(int x) {
		assert x >= 1 && x <= 9 : "The input number should<=9 and >=1";
		int judge = x % 3;
		switch (judge) {
		case 0:
			return x - 2;
		case 1:
			return x;
		case 2:
			return x - 1;
		}
		return 0;
	}

	/**
	 * Create the number law based on a 3*3 blank
	 * 
	 * @param q
	 *            The question to be solved
	 * @param x
	 *            The x position of the problem
	 * @param y
	 *            The y position of the problem
	 * @return NumberLaw type banned number
	 */
	public NumberLaw createBlankLaw(NineQuestion q, int x, int y) {
		assert q != null : "The input q should not be null";
		assert q.isPositionLegal(x, y) : "The input position has some problems";
		NumberLaw law = new NumberLaw();
		int start_x = this.getStartPosition(x);
		int start_y = this.getStartPosition(y);
		for (int i = start_x; i < start_x + 3; i++) {
			for (int j = start_y; j < start_y + 3; j++) {
				if (q.getNumber(i, j) > 0)
					law.addBannedNumber(q.getNumber(i, j));
			}
		}
		return law;
	}

	/**
	 * Judge whether the input number obey the game rules
	 * 
	 * @param q
	 *            The problem to be solved
	 * @param x
	 *            The x position of the question
	 * @param y
	 *            The y position of the question
	 * @param number
	 *            The number to be input into the data
	 * @return Whether the input number fits the game rules
	 */
	public boolean checkFit(NineQuestion q, int x, int y, int number) {
		// Check the input variables
		assert q != null : "The NineQuestion should not be null";
		assert q.isPositionLegal(x, y) : "The position is illegal";
		assert q.isNumberLegal(number) : "The input number is illegal";
		// Begin set Number rules
		NumberLaw law = new NumberLaw();
		law.unionNumberLaw(this.createRowLaw(q, x));
		law.unionNumberLaw(this.createColumnLaw(q, y));
		law.unionNumberLaw(this.createBlankLaw(q, x, y));
		law.deleteBannedNumber(q.getNumber(x, y));
		// Return result
		return law.obeyRule(number);
	}

	/**
	 * This method is used to check whether the NineQuestion is finished
	 * 
	 * @param q
	 *            The NineQuestion
	 * @return Whether the NineQuestion has been finished
	 */
	public boolean checkFinished(NineQuestion q) {
		// Check the input q
		assert q != null : "The input q cannot be null";
		// Check all numbers in the game
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (q.getNumber(i, j) < 1) {
					return false;
				}
			}
		}
		return true;
	}

}
