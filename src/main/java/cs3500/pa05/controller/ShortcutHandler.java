package cs3500.pa05.controller;

import cs3500.pa05.model.BujoFileInformation;
import cs3500.pa05.model.CustomThemeHandler;
import cs3500.pa05.model.TableHandler;
import cs3500.pa05.view.EventAddPopUp;
import cs3500.pa05.view.SaveCssFileView;
import cs3500.pa05.view.TaskAddPopUp;
import javafx.scene.input.KeyCode;

/**
 * This class is responsible for handling shortcuts.
 */
public class ShortcutHandler {

  private final Controller controller;
  private final BujoFileInformation bujoFile;

  /**
   * Constructs a ShortcutHandler.
   *
   * @param controller the controller to be used
   * @param bujoFile   the bujoFile to be used
   */
  public ShortcutHandler(Controller controller, BujoFileInformation bujoFile) {
    this.controller = controller;
    this.bujoFile = bujoFile;
  }

  /**
   * Handles the given shortcut event.
   *
   * @param table the table to be used
   */
  public void handleShortcuts(TableHandler table) {
    this.controller.getRoot().setOnKeyPressed(e -> {
      if (e.isShortcutDown()) {
        KeyCode code = e.getCode();
        switch (code) {
          case E:
            new EventAddPopUp(controller).displayPopUp();
            break;
          case T:
            new TaskAddPopUp(controller).displayPopUp();
            break;
          case S:
            controller.saveFileResponse();
            break;
          case O:
            controller.openFileResponse();
            break;
          case N:
            controller.newWeekFileResponse();
            break;
          case R:
            controller.remove(true);
            controller.remove(false);
            break;
          case D:
            controller.setStyleSheetResponse("darkMode.css");
            break;
          case L:
            controller.setStyleSheetResponse("lightMode.css");
            break;
          case P:
            controller.setStyleSheetResponse("playfulMode.css");
            break;
          case C:
            new SaveCssFileView(controller).savePopUp(bujoFile);
            break;
          case W:
            controller.templateResponse();
            break;
          default:
            break;
        }
      }
    });
  }
}
