package cs3500.pa05.controller;


import cs3500.pa05.view.EventAddPopUp;
import cs3500.pa05.view.TaskAddPopUp;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


/**
 * This class is responsible for handling menu events.
 */
public class HandleMenuEvent implements EventHandler<ActionEvent> {

  private final Controller controller;


  /**
   * Constructs a HandleMenuEvent.
   *
   * @param controller the controller to be used
   */
  public HandleMenuEvent(Controller controller) {
    this.controller = controller;
  }

  /**
   * Handles the given event.
   *
   * @param event the event to be handled
   */
  @Override
  public void handle(ActionEvent event) {
    if (event.getSource().toString().contains("newEvent")) {
      new EventAddPopUp(controller).displayPopUp();
    }
    if (event.getSource().toString().contains("newTask")) {
      new TaskAddPopUp(controller).displayPopUp();
    }

    if (event.getSource().toString().contains("removeEvent")) {
      controller.remove(true);
    }
    if (event.getSource().toString().contains("removeTask")) {
      controller.remove(false);
    }
  }
}
