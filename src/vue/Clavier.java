package vue;

import java.util.Scanner;

/**
 * 
 * @author LanXor
 *
 */
public class Clavier {
	
	/**
	 * @see java.util.Scanner
	 */
	private Scanner scanner = new Scanner(System.in);
	
	/**
	 * 
	 * @return
	 */
	public int entrerClavierInt() {
		return this.scanner.nextInt();
	}
	
	/**
	 * 
	 * @return
	 */
	public String entrerClavierString() {
		return this.scanner.next();
	}
	
}
