package cs3500.pa05.controller;

import cs3500.pa05.json.BujoJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import cs3500.pa05.model.Event;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javafx.scene.control.TableView;

/**
 * This class is responsible for parsing information from the TableView into a BujoJson.
 */
public class ParseInformation implements BujoWriter {

  private final BujoPersistence bujoPersistence;

  /**
   * Constructs a ParseInformation.
   *
   * @param fileDirectory the fileDirectory to be used
   * @param eventsTable   the eventsTable to be used
   * @param taskTable     the taskTable to be used
   * @param cssFile       the cssFile to be used
   * @param maxEvents     the maxEvents to be used
   * @param maxTasks      the maxTasks to be used
   */
  public ParseInformation(String fileDirectory, HashMap<DayOfWeek, TableView<Event>> eventsTable,
                          HashMap<DayOfWeek, TableView<Task>> taskTable,
                          String cssFile, int maxEvents, int maxTasks) {

    BujoJson bujoJson = parseToBujoJson(eventsTable, taskTable, cssFile, maxEvents, maxTasks);
    bujoPersistence = new BujoPersistence(fileDirectory, bujoJson);
  }

  /**
   * Calls bujoPersistence to save the file.
   */
  @Override
  public void saveFile() {
    bujoPersistence.saveFile();
  }

  /**
   * Serializes an event to an eventJson
   *
   * @param event the event to be serialized
   * @return the eventJson
   */
  private EventJson parseToEventJson(Event event) {
    return new EventJson(event.getName(), event.getDescription(), event.getStartTime(),
        event.getDuration());
  }

  /**
   * Serializes a task to an taskJson
   *
   * @param task the task to be serialized
   * @return the taskJson
   */
  private TaskJson parseToTaskJson(Task task) {
    return new TaskJson(task.getName(), task.getDescription(), task.getCompleted().isSelected());
  }

  /**
   * Serializes a HashMap of events Table and task Table to an bujoJson
   *
   * @param eventsTable the eventsTable to be serialized
   * @param taskTable   the taskTable to be serialized
   * @param cssFile     the cssFile to be serialized
   * @param maxEvents   the maxEvents to be serialized
   * @param maxTasks    the maxTasks to be serialized
   * @return the bujoJson
   */
  private BujoJson parseToBujoJson(HashMap<DayOfWeek, TableView<Event>> eventsTable,
                                   HashMap<DayOfWeek, TableView<Task>> taskTable,
                                   String cssFile, int maxEvents, int maxTasks) {

    HashMap<DayOfWeek, List<EventJson>> events = new HashMap<>();
    for (DayOfWeek day : eventsTable.keySet()) {
      List<EventJson> eventJsonList = new ArrayList<>();
      for (Event e : eventsTable.get(day).getItems()) {
        eventJsonList.add(parseToEventJson(e));
      }
      events.put(day, eventJsonList);
    }

    HashMap<DayOfWeek, List<TaskJson>> task = new HashMap<>();
    for (DayOfWeek day : taskTable.keySet()) {
      List<TaskJson> taskJsonList = new ArrayList<>();
      for (Task t : taskTable.get(day).getItems()) {
        taskJsonList.add(parseToTaskJson(t));
      }
      task.put(day, taskJsonList);
    }

    return new BujoJson(events, task, cssFile, maxEvents, maxTasks);
  }
}

