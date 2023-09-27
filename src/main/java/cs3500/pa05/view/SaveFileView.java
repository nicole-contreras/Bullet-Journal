package cs3500.pa05.view;

import cs3500.pa05.model.BujoFileInformation;
import java.io.File;
import javafx.stage.FileChooser;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * This class represents the view for saving a file.
 */
public class SaveFileView implements SaveView {

  /**
   * shows a dialog box to save a file.
   *
   * @param file the file to be saved
   */
  @Override
  public void savePopUp(BujoFileInformation file) {
    FileChooser fileChooser = new FileChooser();

    if (file.getSelectedDirectory() == null) {
      File fileChosen = fileChooser.showSaveDialog(null);
      if (fileChosen != null) {
        String fileName = fileChosen.getName();
        if (!fileName.toLowerCase().endsWith(".bujo")) {
          fileName += ".bujo"; // appending if not alr present
          fileChosen = new File(fileChosen.getParentFile(), fileName);
          file.setFileName(fileName);
          file.setSelectedDirectory(fileChosen.getAbsoluteFile());
        }
      }
    } else {
      File preExistingFile = new File(file.getSelectedDirectory(), file.getFileName());
      Notifications.create()
          .title("File Saved")
          .text(preExistingFile.getName() + " was saved")
          .graphic(null)
          .hideAfter(Duration.seconds(5.0))
          .show();
    }
  }
}
