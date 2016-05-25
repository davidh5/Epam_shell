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
	private static final String TREE_COMMAND = "tree";
	private static final String CD_COMMAND = "cd";
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
					showDirectoryContent(currentDirectory);
				}
				break;
				
			case TREE_COMMAND:
				if (commandParts.length != 1) {
					System.out.println("'Tree' command should be run without any parameters");
				} else {
					int indent = 0;
					showDirectoryTree(currentDirectory, indent);
				}
				break;
				
			case CD_COMMAND:
				changeDirectory(currentDirectory, commandParts[1]);
				break;
				
			case EXIT_COMMAND:
				System.out.println("Shell is closing!");
				System.exit(0);
				break;
				
			
				
			default:
				System.out.println(commandParts[0]+" : unknown command");
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
	private static void promptChange(Prompt prompt, String parameter, File directory) {
		
		switch (parameter) {
		
		case PROMPT_RESET_COMMAND:
			prompt.setPromptSign(PROMPT_DEFUALT_SIGN);
			break;
		
		case PROMPT_CWD_COMMAND:
			try {
				prompt.setPromptSign(directory.getCanonicalPath());
			} catch (IOException e) {
				e.printStackTrace();
			}
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
	private static void showDirectoryContent(File directory) {
		
		File[] files = directory.listFiles();
		
		try {
			System.out.println("Content of " + directory.getCanonicalPath());
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		for (File f : files) {
			if (f.isDirectory()) {
				System.out.println("DIR \t" + f.getName());
			} else {
				System.out.println("FILE \t" + f.getName());
			}
		}
		
	}
	
	/**
	 * @param directory Directory which content should be displayed
	 * @param indent Variable describing in which depth we are in directories tree
	 */
	private static void showDirectoryTree(File directory, int indent) {
		if (indent == 0) {
			try {
				String pathOfCurrentDirectory = directory.getCanonicalPath();
				String nameOfCurrentDirectory = pathOfCurrentDirectory.substring(pathOfCurrentDirectory.lastIndexOf("\\")+1);
				System.out.println(nameOfCurrentDirectory);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		File[] directories = directory.listFiles();
		for (File f : directories) {
			if (f.isDirectory()) {
				getIndentString(indent);
				System.out.println(f.getName());
				showDirectoryTree(f, indent+1);
			}
		}
		
	}
	
	private static void getIndentString(int indent) {
	    for (int i = 0; i <= indent; i++) {
	    	System.out.print('-');
	    }
	}
	
	private static void changeDirectory(File directory, String parameter) {
		
	}
}
