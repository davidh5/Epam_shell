import java.util.Scanner;

/**
 * 
 */

/**
 * @author Dawid
 *
 */
public class Shell {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Prompt prompt = new Prompt("$");
		String text = "";
		Scanner consoleReader = new Scanner(System.in);
		while (!(text.equals("exit"))) {
			System.out.print("Type command: ");
			text = consoleReader.nextLine();
			System.out.println(text);
		}
		System.out.println("Application is closing!");
		System.exit(0);
		
	}

}
