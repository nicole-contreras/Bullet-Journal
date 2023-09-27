package cs3500.pa05.view;

import cs3500.pa05.controller.Task;
import cs3500.pa05.model.Event;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;

/**
 * This class represents a mini viewer.
 */
public class MiniViewer {

  /**
   * Constructs a MiniViewer.
   *
   * @param selectedItem  the selected item to be viewed
   */
  public void showDialogue(Object selectedItem) {
    if (selectedItem instanceof Task) {
      ImageView image = new ImageView("taskViewer.png");
      image.setFitHeight(150);
      image.setFitWidth(150);

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle(((Task) selectedItem).getName());
      alert.setHeaderText(null);
      alert.setContentText("Description: " + ((Task) selectedItem).getDescription() + "\n" 
          + "Completed: " + ((Task) selectedItem).getCompleted().isSelected() + "\n" + "Day: "
          + ((Task) selectedItem).getDay());

      alert.setGraphic(image);

      alert.showAndWait();
    } else if (selectedItem instanceof Event) {
      ImageView image = new ImageView("eventViewer.png");
      image.setFitHeight(150);
      image.setFitWidth(150);

      Alert alert = new Alert(Alert.AlertType.INFORMATION);
      alert.setTitle(((Event) selectedItem).getName());
      alert.setHeaderText(null);
      alert.setContentText(
          "Description: " + ((Event) selectedItem).getDescription() + "\n" + "Duration: "
              + ((Event) selectedItem).getDuration()
              + "\n" + "Start Time: " + ((Event) selectedItem).getStartTime() + "\n" + "Day: "
              + ((Event) selectedItem).getDay());
      alert.setGraphic(image);

      alert.showAndWait();
    }
  }
}
