
public class Prompt {
	
	private String promptSign;
	private boolean isPromptSetToShowDirectory;
	
	/**
	 * Constructor for the Prompt class
	 * @param promptSign String object which defines new prompt sign
	 */
	public Prompt(String promptSign) {
		super();
		isPromptSetToShowDirectory = false;
		this.promptSign = promptSign;
	}
	
	/**
	 * Function that tells if current prompt shows current working directory path
	 * @return the isPromptSetToShowDirectory
	 */
	public boolean isPromptSetToShowDirectory() {
		return isPromptSetToShowDirectory;
	}

	/**
	 * Function that is used to set variable isPromptSetToShowDirectory. This variable shows if current prompt is showing directory path
	 * @param isPromptSetToShowDirectory the isPromptSetToShowDirectory to set
	 */
	public void setPromptSetToShowDirectory(boolean isPromptSetToShowDirectory) {
		this.isPromptSetToShowDirectory = isPromptSetToShowDirectory;
	}

	/**
	 * Function that is used to return current prompt sign
	 * @return the promptSign
	 */
	public String getPromptSign() {
		return promptSign;
	}

	/**
	 * Function that is used to set new prompt sign string
	 * @param promptSign the promptSign to set
	 */
	public void setPromptSign(String promptSign) {
		this.promptSign = promptSign;
	}


	
}
