package cs3500.pa05.view;

import cs3500.pa05.model.Event;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;

/**
 * adds an event to the day
 */
public class HandleEventMap extends AddRemoveHandler {

  /**
   * adds an event to the day
   *
   * @param event     the event to be added
   * @param day       the day to add the event to
   * @param maxEvents the max number of events allowed
   */
  public void add(Event event, TableView<Event> day, int maxEvents) {
    ObservableList<Event> events = day.getItems();
    if (events.size() < maxEvents) {
      events.add(event);
      day.setItems(events);
    } else {
      Alert dialog = new Alert(Alert.AlertType.ERROR);
      dialog.setTitle("max events reached");
      dialog.setContentText("max events reached");
      dialog.show();
    }
  }
}
