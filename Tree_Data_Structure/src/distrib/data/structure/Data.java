package distrib.data.structure;

/**
 * Leaf's data representation of the couple number - letter of the Tree
 * @author Anthony Paulin 
 * @version 0.1
 * @since 08-06-17
 * @category Data structure
 *
 */
public class Data {
	private int number;
	private char letter;

	/**
	 * Default contructor for the leaf's data Each leaf contain a letter and a
	 * number
	 * 
	 * @param number The number (int) of the leaf
	 * @param letter The character (char) of the leaf
	 */
	public Data(int number, char letter) {
		this.number = number;
		this.letter = letter;
	}

	/**
	 * 
	 * @return The number (int) of the leaf
	 */
	public int getNumber() {
		return number;
	}

	/**
	 * 
	 * @return The character (char) of the leaf
	 */
	public char getLetter() {
		return letter;
	}

	/**
	 * Return a representation of the couple number - letter
	 */
	@Override
	public String toString() {
		return number + "-" + letter;
	}
}
