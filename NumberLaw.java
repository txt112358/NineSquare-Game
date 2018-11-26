import java.util.HashSet;
import java.util.Set;

/**
 * This class create a law which the input number cannot be one of the input number
 */

/**
 * @author Tang, Xintian
 *
 */
public class NumberLaw {

	private Set<Integer> bannedNumber = new HashSet<>();

	/**
	 * Add banned number to the law
	 * 
	 * @param number
	 *            The number to be banned
	 */
	public void addBannedNumber(int number) {
		this.bannedNumber.add(number);
	}

	/**
	 * Delete a banned number from the law
	 * 
	 * @param number
	 *            The number to be deleted
	 */
	public void deleteBannedNumber(int number) {
		this.bannedNumber.remove(number);
	}

	/**
	 * Add banned number from the NumberLaw
	 * 
	 * @param other
	 *            Other NumberLaw
	 * @return NumberLaw type result of union
	 */
	public void unionNumberLaw(NumberLaw other) {
		Object[] other_law = other.getBannedNumber();
		for (Object n : other_law) {
			this.bannedNumber.add((Integer) n);
		}
	}

	/**
	 * Return all banned number by Set<integer>
	 * 
	 * @return
	 */
	public Object[] getBannedNumber() {
		return this.bannedNumber.toArray();
	}

	/**
	 * Check whether the number obeys the rule
	 * 
	 * @param number
	 *            The number to be judged
	 * @return Whether the number obeys the rule
	 */
	public boolean obeyRule(int number) {
		for (Integer element : this.bannedNumber) {
			if (element == number) {
				return false;
			}
		}
		return true;
	}

}
