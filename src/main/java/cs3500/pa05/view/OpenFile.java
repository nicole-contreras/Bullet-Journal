package cs3500.pa05.view;

import cs3500.pa05.controller.BujoReader;
import cs3500.pa05.model.BujoFileInformation;
import cs3500.pa05.model.TableHandler;
import java.io.File;
import javafx.scene.control.Label;
import javafx.stage.FileChooser;

/**
 * This class represents the pop up that opens a file.
 */
public class OpenFile implements PopUp {

  private final TableHandler tableHandler;
  private final BujoFileInformation bujoFile;

  /**
   * Constructs an OpenFile.
   *
   * @param tableHandler the tableHandler to be used
   * @param bujoFile     the bujoFile to be used
   */
  public OpenFile(TableHandler tableHandler, BujoFileInformation bujoFile) {
    this.tableHandler = tableHandler;
    this.bujoFile = bujoFile;
  }

  /**
   * Displays the pop up.
   */
  @Override
  public void displayPopUp() {
    final Label fileLabel = new Label();

    // get the file selected
    FileChooser fileChooser = new FileChooser();

    // Set extension filter
    FileChooser.ExtensionFilter extFilter =
        new FileChooser.ExtensionFilter("TEXT files (*.bujo)", "*.bujo");
    fileChooser.getExtensionFilters().add(extFilter);

    // Show open file dialog
    File file = fileChooser.showOpenDialog(null);
    if (file != null) {
      fileLabel.setText(file.getPath());
      new BujoReader(tableHandler, bujoFile).readFromFile(file);
    }
  }
}
