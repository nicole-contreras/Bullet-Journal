package cs3500.pa05.view;

import cs3500.pa05.controller.Task;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 * This class handles the task map.
 */
public class HandleTaskMap extends AddRemoveHandler {
  /**
   * Adds a task to the task map.
   *
   * @param task     the task to be added
   * @param day      the day to be added to
   * @param maxTasks the maximum number of tasks
   */
  public void add(Task task, TableView<Task> day, int maxTasks) {
    ObservableList<Task> tasks = day.getItems();
    if (tasks.size() < maxTasks) {
      tasks.add(task);
      day.setItems(tasks);
    } else {
      Alert dialog = new Alert(Alert.AlertType.ERROR);
      dialog.setTitle("max tasks reached");
      dialog.setContentText("max tasks reached");
      dialog.show();
    }
  }

}

