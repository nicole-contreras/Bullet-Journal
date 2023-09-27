package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 * This class represents a pop up that allows the user to add a new event.
 */
public class EventAddPopUp extends AddPopUp {

  /**
   * Constructs an EventAddPopUp.
   *
   * @param controller the controller to be used
   */
  public EventAddPopUp(Controller controller) {
    super(controller);
  }

  /**
   * Displays the pop up.
   */
  @Override
  public void displayPopUp() {
    super.displayPopUp();
    addAdditionalEventFields();
    addTextFieldListeners();
    dialog.show();
  }

  /**
   * Adds the additional fields for an event.
   */
  private void addAdditionalEventFields() {
    Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
    stage.getIcons().add(new Image("newEventIcon.png")); // To add an icon


    dialog.setTitle("New Event");

    dialog.setHeaderText("Please enter the required fields to create a new event");


    TextField startTime = new TextField();
    TextField duration = new TextField();

    txtFields.add(startTime);
    txtFields.add(duration);

    Label startTimeLabel = new Label("  Start Time: (HH:MM) ");
    grid.add(createRequiredTagLabel(), 1, 4);
    grid.add(startTimeLabel, 1, 4);
    grid.add(startTime, 2, 4);

    Label durationLabel = new Label("  Duration: (HH:MM) ");
    grid.add(createRequiredTagLabel(), 1, 5);
    grid.add(durationLabel, 1, 5);
    grid.add(duration, 2, 5);


    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == submitButtonType) {
        controller.addEvent(txtFields.get(0).getText(), description.getText(), startTime.getText(),
            duration.getText(), comboBox.getValue());
        return new String[] {
            txtFields.get(0).getText(),
            txtFields.get(1).getText(),
            comboBox.getValue().toString(),
            startTime.getText(),
            duration.getText()
        };
      }
      return null;
    });

    dialog.getDialogPane().setContent(grid);

  }

}
