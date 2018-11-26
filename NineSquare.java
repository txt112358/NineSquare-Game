import java.util.Scanner;

public class NineSquare {

	public static void prepareData(NineQuestion q) {
		q.setQuestion(1, 1, 8);
		q.setQuestion(2, 3, 3);
		q.setQuestion(2, 4, 6);
		q.setQuestion(3, 2, 7);
		q.setQuestion(3, 5, 9);
		q.setQuestion(3, 7, 2);
		q.setQuestion(4, 2, 5);
		q.setQuestion(4, 6, 7);
		q.setQuestion(5, 5, 4);
		q.setQuestion(5, 6, 5);
		q.setQuestion(5, 7, 7);
		q.setQuestion(6, 4, 1);
		q.setQuestion(6, 8, 3);
		q.setQuestion(7, 3, 1);
		q.setQuestion(7, 8, 6);
		q.setQuestion(7, 9, 8);
		q.setQuestion(8, 3, 8);
		q.setQuestion(8, 4, 5);
		q.setQuestion(8, 8, 1);
		q.setQuestion(9, 2, 9);
		q.setQuestion(9, 7, 4);
	}

	public static void printData(NineQuestion q) {
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (q.getNumber(i, j) <= 0) {
					System.out.print("* ");
				} else {
					System.out.print(q.getNumber(i, j) + " ");
				}
			}
			System.out.println();
		}
	}

	public static NineQuestion prepareData() {
		int[][] data = new int[][] { { 8, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 3, 6, 0, 0, 0, 0, 0 },
				{ 0, 7, 0, 0, 9, 0, 2, 0, 0 }, { 0, 5, 0, 0, 0, 7, 0, 0, 0 }, { 0, 0, 0, 0, 4, 5, 7, 0, 0 },
				{ 0, 0, 0, 1, 0, 0, 0, 3, 0 }, { 0, 0, 1, 0, 0, 0, 0, 6, 8 }, { 0, 0, 8, 5, 0, 0, 0, 1, 0 },
				{ 0, 9, 0, 0, 0, 0, 4, 0, 0 } };
		return new CreateNineQuestion().createByArray(data);
	}

	public static void main(String[] args) {
		// The question to be solved
		NineQuestion q = prepareData();
		// The check method
		CheckNineSquare check = new CheckNineSquare();
		// The print method
		OutputFormat print = new PrintNineQuestion();
		// The Scanner to scan all data from the screen
		Scanner sc = new Scanner(System.in);

		// The title of the game
		System.out.println("Hello, this is a squared paper for practicing calligraphy");
		System.out.println("Please read the question very carefully and make the decision\n");
		System.out.println("Now, we can see the problem");
		while (!check.checkFinished(q)) { // If not finished, continue
			// Firstly, print the question
			print.outputQuestion(q);
			// Input all answers
			System.out.print("Please input the x position:");
			int x = sc.nextInt();
			System.out.print("Please input the y position:");
			int y = sc.nextInt();
			System.out.print("Please input the number:");
			int number = sc.nextInt();
			// Check the answers and insert the data
			if (check.checkFit(q, x, y, number) && !q.isQuestion(x, y) && q.isNumberLegal(number)
					&& q.isPositionLegal(x, y)) {
				q.setAnswer(x, y, number);
			} else {
				System.out.println("The answer is not correct. Please input again.");
			}
			System.out.println("\nNow the game becomes...");
		}
		sc.close();

	}

}
