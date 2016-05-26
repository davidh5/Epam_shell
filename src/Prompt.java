
public class Prompt {
	
	private String promptSign;
	private boolean isPromptSetToShowDirectory;
	
	public Prompt(String promptSign) {
		super();
		isPromptSetToShowDirectory = false;
		this.promptSign = promptSign;
	}
	
	/**
	 * @return the isPromptPath
	 */
	public boolean isPromptSetToShowDirectory() {
		return isPromptSetToShowDirectory;
	}

	/**
	 * @param isPromptSetToShowDirectory the isPromptPath to set
	 */
	public void setPromptSetToShowDirectory(boolean isPromptSetToShowDirectory) {
		this.isPromptSetToShowDirectory = isPromptSetToShowDirectory;
	}

	/**
	 * @return the promptSign
	 */
	public String getPromptSign() {
		return promptSign;
	}

	/**
	 * @param promptSign the promptSign to set
	 */
	public void setPromptSign(String promptSign) {
		this.promptSign = promptSign;
	}


	
}
