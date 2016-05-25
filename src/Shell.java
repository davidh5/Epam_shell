import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 * @author Dawid
 *
 */
public class Shell {
	
	private static final String EXIT_COMMAND = "exit";
	private static final String DIR_COMMAND = "dir";
	private static final String PROMPT_COMMAND = "prompt";
	private static final String PROMPT_RESET_COMMAND = "reset";
	private static final String PROMPT_CWD_COMMAND = "$cwd";
	private static final String PROMPT_DEFUALT_SIGN = "$";

	public static void main(String[] args) {
		Prompt prompt = new Prompt("$");
		File currentDirectory = new File(".");
		
		
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
					promptChange(prompt, commandParts[1], currentDirectory);
					break;
				}
			
			case DIR_COMMAND:
				if (commandParts.length != 1) {
					System.out.println("'Dir' command should be run without any parameters");
				} else {
					try {
						showDirectoryContent(currentDirectory);
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
				
			case EXIT_COMMAND:
				System.out.println("Shell is closing!");
				System.exit(0);
				break;
				
			
				
			default:
				System.out.println(commandParts[0]+":unknown command");
				break;
			}
		}
		consoleReader.close();
	}
	
	/**
	 * @param prompt Prompt object which defines the prompt sign in shell
	 * @param parameter Second part of typed command
	 * @param directory Current working directory, it is used to show current directory path in prompt
	 */
	public static void promptChange(Prompt prompt, String parameter, File directory) {
		
		switch (parameter) {
		
		case PROMPT_RESET_COMMAND:
			prompt.setPromptSign(PROMPT_DEFUALT_SIGN);
			break;
		
		case PROMPT_CWD_COMMAND:
			prompt.setPromptSign(directory.getAbsolutePath());
			break;
		
		default:
			prompt.setPromptSign(parameter);
			break;
		}
	}
	
	/**
	 * @param directory Directory which content should be displayed
	 *
	 */
	public static void showDirectoryContent(File directory) throws IOException {
		
		File[] files = directory.listFiles();
		try {
		System.out.println("Content of: " + directory.getCanonicalPath());
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		
			
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println("DIR \t" + f.getName());
			} else {
				System.out.println("FILE \t" + f.getName());
			}
		}
		
	}
}
