import java.io.File;

public class Directory {
	
	private File directory;
	
	/**
	 * Constructor for the Directory class
	 * @param directory File object which defines current working directory
	 */
	public Directory(File directory) {
		super();
		this.directory = directory;
	}
	
	/**
	 * Function that is used to get File object which is describing current working directory
	 * @return the directory which is File object of current working directory
	 */
	public File getDirectory() {
		return directory;
	}

	/**
	 * Function that is used to set File object which is describing current working directory
	 * @param directory File object which defines new current working directory
	 */
	public void setDirectory(File directory) {
		this.directory = directory;
	}
}