/**
 * This class is used to print the NineQuestion to the screen
 */

/**
 * @author Tang, Xintian
 *
 */
public class PrintNineQuestion implements OutputFormat {
	/**
	 * This method is used to print the NineQuestion q to the screen
	 * 
	 * @param q
	 *            The NineQuestion to be printed to the screen
	 */
	public void outputQuestion(NineQuestion q) {
		assert q != null : "The input NineQuestion cannot be null";
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (q.getNumber(i, j) < 1) {
					System.out.print("* ");
				} else {
					System.out.print(q.getNumber(i, j) + " ");
				}
			}
			System.out.println();
		}
	}

}
