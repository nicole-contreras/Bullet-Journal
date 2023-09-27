package wrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import cs3500.pa05.model.BujoFileInformation;
import java.io.File;
import org.junit.jupiter.api.Test;

/**
 * Represents the tests for a BujoFileInformation
 */
public class TestBujoFileInformation {

  /**
   * Tests the getters and setters for SelectedDirectory
   */
  @Test
  public void testGetSetSelectedDirectory() {
    BujoFileInformation fileInformation = new BujoFileInformation();

    // Test initial state
    assertNull(fileInformation.getSelectedDirectory());

    // Set selected directory
    File directory = new File("src/test/resources/tester.bujo");
    fileInformation.setSelectedDirectory(directory);

    // Test getSelectedDirectory()
    assertEquals(directory, fileInformation.getSelectedDirectory());
  }


  /**
   * Tests the getters and setters for FileName
   */
  @Test
  public void testGetSetFileName() {
    BujoFileInformation fileInformation = new BujoFileInformation();

    // Test initial state
    assertNull(fileInformation.getFileName());

    // Set file name
    String fileName = "example.txt";
    fileInformation.setFileName(fileName);

    // Test getFileName()
    assertEquals(fileName, fileInformation.getFileName());
  }

  /**
   * Tests the getters and setters for cssFile
   */
  @Test
  public void testGetSetCssFile() {
    BujoFileInformation fileInformation = new BujoFileInformation();

    // Test initial state
    assertNull(fileInformation.getCssFile());

    // Set CSS file
    String cssFile = "styles.css";
    fileInformation.setCssFile(cssFile);

    // Test getCssFile()
    assertEquals(cssFile, fileInformation.getCssFile());
  }
}
