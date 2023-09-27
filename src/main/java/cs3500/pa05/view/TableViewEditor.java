package cs3500.pa05.view;

import cs3500.pa05.controller.Task;
import cs3500.pa05.model.Event;
import java.time.DayOfWeek;
import java.util.Map;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableView;

/**
 * represents a class to edit the view of the table
 */
public class TableViewEditor {
  Map<DayOfWeek, TableView<Task>> tasksMap;
  Map<DayOfWeek, TableView<Event>> eventsMap;

  /**
   * adds a task to the table
   *
   * @param name        the name of the task
   * @param description the description of the task
   * @param day         the day of the task
   * @param tasks       the current view of the table
   * @param maxTasks    the max number of tasks
   * @return the new view of the table
   */
  public Map<DayOfWeek, TableView<Task>> addTask(String name, String description, DayOfWeek day,
                                                 Map<DayOfWeek, TableView<Task>> tasks,
                                                 int maxTasks) {
    this.tasksMap = tasks;
    Task task = new Task(name, description, new CheckBox(), day);
    HandleTaskMap handleTaskMap = new HandleTaskMap();
    handleTaskMap.add(task, tasksMap.get(day), maxTasks);
    return tasks;
  }


  /**
   * adds an event to the table
   *
   * @param name        name of the event
   * @param description description of the event
   * @param start       start time of the event
   * @param duration    duration of the event
   * @param day         day of the event
   * @param events      current view of the table
   * @param maxEvents   max number of events
   * @return new view of the table
   */
  public Map<DayOfWeek, TableView<Event>> addEvent(String name, String description, String start,
                                                   String duration,
                                                   DayOfWeek day,
                                                   Map<DayOfWeek, TableView<Event>> events,
                                                   int maxEvents) {
    this.eventsMap = events;
    Event event = new Event(name, description, start, duration, day);
    HandleEventMap handleEventView = new HandleEventMap();
    handleEventView.add(event, eventsMap.get(day), maxEvents);
    return events;
  }


  /**
   * removes a task or event from the table
   *
   * @param isEvent whether or not the item is an event
   */
  public void remove(Boolean isEvent) {
    for (DayOfWeek dayOfWeek : DayOfWeek.values()) {
      if (isEvent) {
        if (eventsMap != null) {
          if (eventsMap.get(dayOfWeek).isFocused()) {
            switch (dayOfWeek) {
              case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY ->
                  new HandleEventMap().remove(eventsMap.get(dayOfWeek));
              default -> {
                break;
              }
            }
          }
        }
      } else {
        if (tasksMap != null) {
          if (tasksMap.get(dayOfWeek).isFocused()) {
            switch (dayOfWeek) {
              case MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY ->
                  new HandleTaskMap().remove(tasksMap.get(dayOfWeek));
              default -> {
                break;
              }
            }
          }
        }
      }
    }
  }
}
