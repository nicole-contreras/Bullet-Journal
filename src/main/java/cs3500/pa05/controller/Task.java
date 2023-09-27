package cs3500.pa05.controller;

import java.time.DayOfWeek;
import javafx.scene.control.CheckBox;

/**
 * This class represents a task.
 */
public class Task {
  private String name;
  private String description;
  private CheckBox completed;
  private final DayOfWeek day;


  /**
   * Constructs a Task.
   *
   * @param name        the name to be used
   * @param description the description to be used
   * @param complete    the complete to be used
   * @param day         the day to be used
   */
  public Task(String name, String description, CheckBox complete, DayOfWeek day) {
    this.name = name;
    this.description = description;
    this.completed = complete;
    this.day = day;
  }

  /**
   * Gets the name of the task.
   *
   * @return the name of the task
   */
  public String getName() {
    return this.name;
  }

  /**
   * Gets the description of the task.
   *
   * @return the description of the task
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Gets the completed status of the task.
   *
   * @return the completed status of the task
   */
  public CheckBox getCompleted() {
    return this.completed;
  }

  /**
   * sets the name of the task.
   *
   * @param name the name to be used
   */
  public void setName(String name) {
    this.name = name;
  }

  /**
   * sets the description of the task.
   *
   * @param description the description to be used
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * sets the completed status of the task.
   *
   * @param completed the completed status to be used
   */
  public void setCompleted(CheckBox completed) {
    this.completed = completed;
  }

  /**
   * overrides the toString to organize the task.
   *
   * @return the string of the task organized
   */

  @Override
  public String toString() {
    return "Task{"
        +
        "name='"
        + name
        + '\''
        +
        ", description='"
        + description
        + '\''
        +
        ", completed=" + completed
        +
        '}';
  }

  /**
   * return the day of the task.
   *
   * @return day the day to be used
   */
  public DayOfWeek getDay() {
    return this.day;
  }
}
