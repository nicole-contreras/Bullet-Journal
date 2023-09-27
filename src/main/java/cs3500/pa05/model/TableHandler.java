package cs3500.pa05.model;

import cs3500.pa05.controller.Task;
import java.time.DayOfWeek;
import java.util.Map;
import javafx.scene.control.TableView;

/**
 * To handle actions related to the event and task tables
 */
public class TableHandler {
  private int maxTasks;
  private int maxEvents;
  private Map<DayOfWeek, TableView<Task>> tasksMap;
  private Map<DayOfWeek, TableView<Event>> eventsMap;

  /**
   * To instantiate a TableHandler
   */
  public TableHandler() {

  }

  /**
   * To instantiate a TableHandler
   *
   * @param tasksMap the map of tasks and their days of the week
   * @param eventsMap the map of events and their days of the week
   */
  public TableHandler(Map<DayOfWeek, TableView<Task>> tasksMap,
                      Map<DayOfWeek, TableView<Event>> eventsMap) {
    this.tasksMap = tasksMap;
    this.eventsMap = eventsMap;
  }

  /**
   * To set the max amount of events and tasks
   *
   * @param maxAmounts the integer list to be set as the max amounts,
   *                   (index 0 as the max events, index 1 as the max tasks)
   */
  public void max(Integer[] maxAmounts) {
    this.maxEvents = maxAmounts[0];
    this.maxTasks = maxAmounts[1];
  }

  /**
   * Retrieves the hashmap of all the tasks with its associated day
   *
   * @return this TableHandler's tasksMap
   */
  public Map<DayOfWeek, TableView<Task>> getTasksMap() {
    return this.tasksMap;
  }

  /**
   * Retrieves the hashmap of all the events with its associated day
   *
   * @return this TableHandler's eventsMap
   */
  public Map<DayOfWeek, TableView<Event>> getEventsMap() {
    return this.eventsMap;
  }

  /**
   * Retrieves the maximum events
   *
   * @return this TableHandler's maxEvents
   */
  public int getMaxEvents() {
    return maxEvents;
  }

  /**
   * Retrieves the maximum events of tasks
   *
   * @return this TableHandler's maxTasks
   */
  public int getMaxTasks() {
    return maxTasks;
  }


  /**
   * To set this TableHandler's eventsMap
   *
   * @param eventsMap to be set as the eventsMap
   */
  public void setEventsMap(
      Map<DayOfWeek, TableView<Event>> eventsMap) {
    this.eventsMap = eventsMap;
  }

  /**
   * To set this TableHandler's maxEvents
   *
   * @param maxEvents to be set as the maxEvents
   */
  public void setMaxEvents(int maxEvents) {
    this.maxEvents = maxEvents;
  }

  /**
   * To set this TableHandler's tasksMap
   *
   * @param tasksMap to be set as the tasksMap
   */
  public void setTasksMap(
      Map<DayOfWeek, TableView<Task>> tasksMap) {
    this.tasksMap = tasksMap;
  }

  /**
   * To set this TableHandler's maxTasks
   *
   * @param maxTasks to be set as the maxTasks
   */
  public void setMaxTasks(int maxTasks) {
    this.maxTasks = maxTasks;
  }
}
