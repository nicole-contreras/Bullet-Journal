package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import cs3500.pa05.view.MiniViewer;
import java.time.DayOfWeek;
import java.util.Map;
import javafx.event.EventHandler;
import javafx.scene.control.TableView;
import javafx.scene.input.ContextMenuEvent;

/**
 * This class is responsible for handling right clicks on the TableView.
 */
public class RightClickHandler implements EventHandler<ContextMenuEvent> {

  /**
   * Adds right clicks to the given tables.
   *
   * @param taskTable  the taskTable to be used
   * @param eventTable the eventTable to be used
   */
  public void addRightClicks(Map<DayOfWeek, TableView<Task>> taskTable,
                             Map<DayOfWeek, TableView<Event>> eventTable) {
    for (DayOfWeek day : taskTable.keySet()) {
      taskTable.get(day).setOnContextMenuRequested(this);
    }
    for (DayOfWeek day : eventTable.keySet()) {
      eventTable.get(day).setOnContextMenuRequested(this);
    }
  }

  /**
   * Handles the given event.
   *
   * @param event the event to be handled
   */
  @Override
  public void handle(ContextMenuEvent event) {
    TableView<?> tableView = (TableView<?>) event.getSource();
    Object selectedItem = tableView.getSelectionModel().getSelectedItem();

    // Show a dialogue with the information of the selected item
    new MiniViewer().showDialogue(selectedItem);
  }
}
