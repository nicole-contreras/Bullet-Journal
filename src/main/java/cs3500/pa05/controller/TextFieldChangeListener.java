package cs3500.pa05.controller;

import java.util.ArrayList;
import java.util.regex.Pattern;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.Node;
import javafx.scene.control.TextField;

/**
 * This class is responsible for listening to changes in a TextField.
 */
public class TextFieldChangeListener implements ChangeListener<String> {

  private final ArrayList<TextField> textFields;
  private final Node submitButton;

  /**
   * Constructs a TextFieldChangeListener.
   *
   * @param submitButton the submitButton to be used
   * @param textFields   the textFields to be used
   */
  public TextFieldChangeListener(Node submitButton, ArrayList<TextField> textFields) {
    this.submitButton = submitButton;
    this.textFields = textFields;
  }

  /**
   * Called when the value of an ObservableValue changes.
   *
   * @param observable the observable to be used
   * @param oldValue   the oldValue to be used
   * @param newValue   the newValue to be used
   */
  @Override
  public void changed(ObservableValue<? extends String> observable, String oldValue,
                      String newValue) {
    boolean allFieldsCompleted = true;
    for (TextField textField : textFields) {
      if (textField.getText().isEmpty()) {
        allFieldsCompleted = false;
        break;
      }

      if (textFields.size() > 1) {
        Pattern format = Pattern.compile("([01][0-9]|2[0-3]):[0-5][0-9]");
        if (!format.matcher(textFields.get(1).getText()).matches()
            || !format.matcher(textFields.get(2).getText()).matches()) {
          allFieldsCompleted = false;
          break;
        }
      }
    }

    submitButton.setDisable(!allFieldsCompleted);
  }
}
