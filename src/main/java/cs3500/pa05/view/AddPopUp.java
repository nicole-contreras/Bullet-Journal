package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.controller.TextFieldChangeListener;
import java.time.DayOfWeek;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

/**
 * Pop ups for tasks and events creation
 */
public abstract class AddPopUp implements PopUp {

  /**
   * The grid to hold the items in the popup
   */
  protected GridPane grid = new GridPane();

  /**
   * The popup
   */
  protected Dialog dialog = new Dialog<>();

  /**
   * The textfields present in the dialog
   */
  protected ArrayList<TextField> txtFields = new ArrayList<>();

  /**
   * The submitButton present in the dialog
   */
  protected Node submitButton;

  /**
   * The dropdown button present in the dialog
   */
  protected ComboBox<DayOfWeek> comboBox = new ComboBox<>();

  /**
   * The description textField in the dialog
   */
  protected TextField description = new TextField();

  /**
   * The submitButton as a node
   */
  protected ButtonType submitButtonType =
      new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);

  /**
   * The controller
   */
  protected Controller controller;

  /**
   * Creates a label that indicates a field is required.
   *
   * @param controller the controller
   */

  public AddPopUp(Controller controller) {
    this.controller = controller;
  }


  /**
   * Displays the pop up.
   */
  @Override
  public void displayPopUp() {
    dialog.setResizable(true);

    dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, ButtonType.CANCEL);


    submitButton = dialog.getDialogPane().lookupButton(submitButtonType);
    submitButton.setDisable(true);


    ObservableList<DayOfWeek> options = FXCollections.observableArrayList(DayOfWeek.values());
    comboBox = new ComboBox<>(options);
    comboBox.setValue(DayOfWeek.SUNDAY);

    TextField name = new TextField();

    Label nameLabel = new Label("  Name: ");
    txtFields.add(name);

    grid.add(createRequiredTagLabel(), 1, 1);
    grid.add(nameLabel, 1, 1);
    grid.add(name, 2, 1);

    Label descLabel = new Label("  Description: ");

    grid.add(descLabel, 1, 2);
    grid.add(description, 2, 2);

    Label dayLabel = new Label("  Day of Week: ");
    grid.add(createRequiredTagLabel(), 1, 3);
    grid.add(dayLabel, 1, 3);
    grid.add(comboBox, 2, 3);

  }


  /**
   * Creates a label that indicates a field is required.
   *
   * @return the required tag label
   */
  protected Label createRequiredTagLabel() {
    Label requiredTag = new Label("*");
    requiredTag.setTextFill(Color.color(1, 0, 0));
    return requiredTag;
  }

  /**
   * Adds listeners to the text fields.
   */
  protected void addTextFieldListeners() {
    for (TextField field : txtFields) {
      field.textProperty().addListener(new TextFieldChangeListener(submitButton,
          txtFields));
    }
  }
}
