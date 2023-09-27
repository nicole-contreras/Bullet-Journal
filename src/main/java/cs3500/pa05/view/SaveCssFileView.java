package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.BujoFileInformation;
import cs3500.pa05.model.CustomThemeHandler;
import java.util.Optional;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

/**
 * This class represents the view for saving a css file.
 */
public class SaveCssFileView implements SaveView {

  private final Controller controller;

  /**
   * Constructs a SaveCssFileView.
   *
   * @param controller the controller to be used
   */
  public SaveCssFileView(Controller controller) {
    this.controller = controller;
  }

  /**
   * Saves the css file.
   *
   * @param bujo the information to save
   */
  @Override
  public void savePopUp(BujoFileInformation bujo) {
    if (bujo.getCssFile() == null || bujo.getCssFile().contains("lightMode.css")
        || bujo.getCssFile().contains("darkMode.css")
        || bujo.getCssFile().contains("playfulMode.css")) {
      displayPopUp(bujo);
    } else {
      new CustomThemeHandler(controller, bujo.getCssFile()).handleCustomTheme();

      ImageView imageView = new ImageView("crayonIcon.png");
      imageView.setFitHeight(20);
      imageView.setFitWidth(20);

      Notifications.create()
          .title("Changing Theme\n\n")
          .text("Editing " + bujo.getCssFile())
          .graphic(imageView)
          .hideAfter(Duration.seconds(5.0))
          .show();
    }

  }

  /**
   * Displays the pop up.
   *
   * @param bujo the information to save
   */
  private void displayPopUp(BujoFileInformation bujo) {

    Dialog<ButtonType> dialog = new Dialog<>();
    dialog.setTitle("Save CSS File");
    Label text = new Label("Enter file name:    ");

    ButtonType submitButtonType =
        new ButtonType("Submit", ButtonBar.ButtonData.OK_DONE);

    dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, ButtonType.CANCEL);

    TextField name = new TextField();

    GridPane grid = new GridPane();

    grid.add(text, 0, 1);
    grid.add(name, 1, 1);

    dialog.getDialogPane().setContent(grid);

    Stage stage = (Stage) dialog.getDialogPane().getScene().getWindow();
    stage.getIcons().add(new Image("cssIcon.png")); // To add an icon

    Optional<ButtonType> result = dialog.showAndWait();

    Button submitButton = (Button) dialog.getDialogPane().lookupButton(submitButtonType);

    submitButton.setDisable(true); // Initially disable the submit button

    name.textProperty().addListener((observable, oldValue, newValue) -> {
      submitButton.setDisable(
          newValue.trim().isEmpty()); // Enable the submit button when there is non-empty text
    });


    if (result.isPresent() && result.get() == submitButtonType) {
      String fileName = name.getText();
      if (!fileName.toLowerCase().endsWith(".css")) {
        fileName += ".css"; // Append the extension if not already present
      }

      bujo.setCssFile(fileName);
      new CustomThemeHandler(controller, bujo.getCssFile()).handleCustomTheme();

    }
  }
}
