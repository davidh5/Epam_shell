import java.io.File;
import java.util.Scanner;

/**
 * @author Dawid
 *
 */
public class Shell {
	
	private static final String EXIT_COMMAND = "exit";
	private static final String PROMPT_COMMAND = "prompt";
	private static final String PROMPT_RESET_COMMAND = "reset";
	private static final String PROMPT_CWD_COMMAND = "$cwd";
	private static final String PROMPT_DEFUALT_SIGN = "$";

	public static void main(String[] args) {
		Prompt prompt = new Prompt("$");
		
		String text = "";
		String[] commandParts;
		Scanner consoleReader = new Scanner(System.in);
		
		while (!(text.equals(EXIT_COMMAND))) {
			
			System.out.print(prompt.getPromptSign()+" ");
			
			text = consoleReader.nextLine();
			commandParts = text.split(" ");
			
			switch (commandParts[0]) {
			
			case PROMPT_COMMAND:
				if (commandParts.length == 1 || commandParts.length >2) {
					System.out.println("'Prompt' command parameters are wrong");
					break;
				} else {
					promptChange(prompt, commandParts[1]);
					break;
				}
				
			case EXIT_COMMAND:
				System.out.println("Shell is closing!");
				System.exit(0);
				break;
				
			default:
				System.out.println(commandParts[0]+":unknown command");
				break;
			}
		}
	}
	
	/**
	 * @param prompt Prompt object which defines the prompt sign in shell
	 * @param parameter Second part of typed command
	 */
	public static void promptChange(Prompt prompt, String parameter) {
		
		switch (parameter) {
		
		case PROMPT_RESET_COMMAND:
			prompt.setPromptSign(PROMPT_DEFUALT_SIGN);
			break;
		
		case PROMPT_CWD_COMMAND:
			File fileToObtainPath = new File("");
			prompt.setPromptSign(fileToObtainPath.getAbsolutePath());
			break;
		
		default:
			prompt.setPromptSign(parameter);
			break;
		}
	}
}
