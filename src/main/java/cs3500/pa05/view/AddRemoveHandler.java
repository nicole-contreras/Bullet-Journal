package cs3500.pa05.view;

import javafx.scene.control.TableView;

/**
 * This class is responsible for handling adding and removing items from the TableView.
 */
public abstract class AddRemoveHandler {

  /**
   * Adds the given item to the given day.
   *
   * @param day thet table to be removed from
   */
  public void remove(TableView<?> day) {
    int selectedId = day.getSelectionModel().getSelectedIndex();
    day.getItems().remove(selectedId);
  }
}
