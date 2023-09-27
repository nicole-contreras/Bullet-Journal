package cs3500.pa05.model;

import java.io.File;

/**
 * To hold a .bujo file's information
 */
public class BujoFileInformation {
  private File selectedDirectory = null;
  private String fileName;
  private String cssFile;

  /**
   * Returns the directory saved
   *
   * @return the selected Directory
   */
  public File getSelectedDirectory() {
    return selectedDirectory;
  }

  /**
   * Sets selected directory to the given file
   *
   * @param selectedDirectory to be set as the selected directory
   */
  public void setSelectedDirectory(File selectedDirectory) {
    this.selectedDirectory = selectedDirectory;
  }

  /**
   * retrieves the file name
   *
   * @return the filename
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * Sets the name of the file
   *
   * @param fileName to be set as the filename
   */
  public void setFileName(String fileName) {
    this.fileName = fileName;
  }


  /**
   * Sets the cssFile to the given file path as a string
   *
   * @param cssFile to be set as the css file
   */
  public void setCssFile(String cssFile) {
    this.cssFile = cssFile;
  }

  /**
   * Retrieves the saved string path of the css File
   *
   * @return the css file
   */
  public String getCssFile() {
    return cssFile;
  }
}
