package cs3500.pa05.controller;

import cs3500.pa05.model.Event;
import javafx.event.EventHandler;
import javafx.scene.control.TableColumn;

/**
 * This class is responsible for editing the table.
 */
public class TableEditor implements EventHandler<TableColumn.CellEditEvent> {
  private final String itemToChange;

  /**
   * Constructs a TableEditor.
   *
   * @param itemToChange the item to be changed
   */
  public TableEditor(String itemToChange) {
    this.itemToChange = itemToChange;
  }

  /**
   * Edits the given event in the table
   *
   * @param event the event to be edited
   */
  @Override
  public void handle(TableColumn.CellEditEvent event) {
    Object item = event.getRowValue();
    if (this.itemToChange.equals("Name")) {
      if (item instanceof Task) {
        ((Task) item).setName(event.getNewValue().toString());
      } else {
        ((Event) item).setName(event.getNewValue().toString());
      }
    } else if (this.itemToChange.equals("Description")) {
      if (item instanceof Task) {

        ((Task) item).setDescription(event.getNewValue().toString());
      } else {
        ((Event) item).setDescription(event.getNewValue().toString());
      }
    } else if (this.itemToChange.equals("StartTime")) {
      ((Event) item).setStartTime(event.getNewValue().toString());
    } else {
      ((Event) item).setDuration(event.getNewValue().toString());
    }
  }
}
