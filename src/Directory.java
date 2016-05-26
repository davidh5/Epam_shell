import java.io.File;

public class Directory {
	
	private File directory;
	
	public Directory(File directory) {
		super();
		this.directory = directory;
	}
	
	/**
	 * @return the directory
	 */
	public File getDirectory() {
		return directory;
	}

	/**
	 * @param directory
	 */
	public void setDirectory(File directory) {
		this.directory = directory;
	}


	
}
