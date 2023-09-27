package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * represents a popup window that allows the user to add a task.
 */
public class TaskAddPopUp extends AddPopUp {

  /**
   * constructs a TaskAddPopUp.
   *
   * @param controller the controller to be used
   */
  public TaskAddPopUp(Controller controller) {
    super(controller);
  }

  /**
   * displays the popup window.
   */
  @Override
  public void displayPopUp() {
    super.displayPopUp();
    addAdditionalTaskFields();
    addTextFieldListeners();
    dialog.show();
  }

  /**
   * adds the additional fields for a task.
   */
  private void addAdditionalTaskFields() {
    Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
    stage.getIcons().add(new Image("newTask.png"));

    dialog.setTitle("New Task");
    dialog.setHeaderText("Please enter the required fields to create a new task");
    dialog.getDialogPane().setContent(grid);
    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == submitButtonType) {
        controller.addTask(txtFields.get(0).getText(), description.getText(), comboBox.getValue());
        return new String[] {
            txtFields.get(0).getText(),
            comboBox.getValue().toString()
        };
      }
      return null;
    });
  }
}
