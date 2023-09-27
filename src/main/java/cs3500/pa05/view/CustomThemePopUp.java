package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.CustomThemeHandler;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ColorPicker;
import javafx.scene.control.Label;

/**
 * This class represents a custom theme pop up.
 */
public class CustomThemePopUp extends AddPopUp {
  private CustomThemeHandler handler;

  /**
   * Constructs a custom theme pop up.
   *
   * @param handler the handler to be used
   */
  public CustomThemePopUp(CustomThemeHandler handler) {
    super(new Controller());
    this.handler = handler;
  }

  /**
   * Displays the pop up.
   */
  @Override
  public void displayPopUp() {
    dialog.setResizable(true);


    ColorPicker rootColor = new ColorPicker();
    Label hexInstructions = new Label("  Select the colors for your own theme ");
    Label rootLabel = new Label("  Root Color: ");

    grid.add(hexInstructions, 1, 0);
    grid.add(rootLabel, 1, 1);
    grid.add(rootColor, 2, 1);

    ColorPicker labelColor = new ColorPicker();
    Label labelLabel = new Label("  Label Color: ");

    grid.add(labelLabel, 1, 2);
    grid.add(labelColor, 2, 2);

    Label accentLabel = new Label("  Accent Color: ");

    ColorPicker accentColor = new ColorPicker();
    grid.add(accentLabel, 1, 3);
    grid.add(accentColor, 2, 3);

    ColorPicker backgroundColor = new ColorPicker();
    Label backgroundLabel = new Label("  Text Color: ");

    grid.add(backgroundLabel, 1, 4);
    grid.add(backgroundColor, 2, 4);


    dialog.getDialogPane().getButtonTypes().addAll(submitButtonType, ButtonType.CANCEL);
    submitButton = dialog.getDialogPane().lookupButton(submitButtonType);

    dialog.getDialogPane().setContent(grid);
    dialog.show();

    dialog.setResultConverter(dialogButton -> {
      if (dialogButton == submitButtonType) {
        String colorRoot = rootColor.getValue().toString();
        String colorLabel = labelColor.getValue().toString();
        String colorAccent = accentColor.getValue().toString();
        String colorBackground = backgroundColor.getValue().toString();

        handler.setRootColor(colorRoot.substring(2, colorRoot.length() - 2));
        handler.setLabelColor(colorLabel.substring(2, colorRoot.length() - 2));
        handler.setAccentColor(colorAccent.substring(2, colorRoot.length() - 2));
        handler.setTextColor(colorBackground.substring(2, colorRoot.length() - 2));
        handler.assignCss();
        return null;
      }
      return null;
    });
  }
}