package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.util.function.UnaryOperator;
import javafx.scene.Node;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.StageStyle;
import javafx.util.converter.IntegerStringConverter;


/**
 * represents a dialogue for taking in commitments
 */
public class DialogueForMax {

  private final Controller controller;

  /**
   * constructs a dialogue for max
   *
   * @param controller the controller to be used
   */
  public DialogueForMax(Controller controller) {
    this.controller = controller;
  }

  /**
   * This method creates a dialogue box that asks the user for the
   * maximum number of events and tasks
   *
   * @param currentEvent the number of events present
   * @param currentTask the number of tasks present
   */
  public void askForMax(int currentTask, int currentEvent) {
    ButtonType submitButtonType =
        new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);
    Dialog<Void> dialog = new Dialog<>();
    dialog.setTitle("Max");
    dialog.getDialogPane().getButtonTypes().addAll(submitButtonType);

    Node submitButton = dialog.getDialogPane().lookupButton(submitButtonType);
    submitButton.setDisable(false);
    GridPane grid = new GridPane();

    Label maxEventsLabel = new Label("  Maximum Events: ");
    Label maxTasksLabel = new Label("  Maximum Tasks: ");

    TextField maxEvents = createIntegerField(currentEvent);
    TextField maxTasks = createIntegerField(currentTask);

    grid.add(maxEventsLabel, 1, 1);
    grid.add(maxEvents, 2, 1);
    grid.add(maxTasksLabel, 1, 2);
    grid.add(maxTasks, 2, 2);
    dialog.getDialogPane().setContent(grid);

    dialog.initStyle(StageStyle.UNDECORATED);
    dialog.initModality(Modality.APPLICATION_MODAL);

    dialog.show();

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == submitButtonType) {
        int maxEventsValue = Integer.parseInt(maxEvents.getText());
        int maxTasksValue = Integer.parseInt(maxTasks.getText());
        controller.setMax(maxEventsValue, maxTasksValue);
      }
      return null;
    });
  }

  /**
   * Creates a TextField that only allows integer values.
   */
  private TextField createIntegerField(int current) {
    TextField textField = new TextField();
    UnaryOperator<TextFormatter.Change> filter = change -> {
      String newText = change.getControlNewText();
      if (newText.matches("\\d*")) {
        return change;
      }
      return null;
    };
    TextFormatter<Integer> textFormatter =
        new TextFormatter<>(new IntegerStringConverter(), current, filter);
    textField.setTextFormatter(textFormatter);
    return textField;
  }
}
