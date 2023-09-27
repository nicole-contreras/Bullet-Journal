package cs3500.pa05.model;

import java.time.DayOfWeek;

/**
 * To represent an event in the bullet journal
 */
public class Event {
  private String name;
  private String description;
  private String startTime;
  private String duration;
  private final DayOfWeek day;

  /**
   * To instantiate an Event
   *
   * @param day day of the event
   * @param description the description of task
   * @param startTime the time the event start
   * @param duration the length of the event
   * @param name the name of the event
   */
  public Event(String name, String description, String startTime, String duration, DayOfWeek day) {
    this.name = name;
    this.description = description;
    this.startTime = startTime;
    this.duration = duration;
    this.day = day;

  }

  /**
   * Retrieves the name of the event
   *
   * @return this Event's name
   */
  public String getName() {
    return this.name;
  }

  /**
   * Retrieves the description of the event
   *
   * @return this Event's description
   */
  public String getDescription() {
    return this.description;
  }

  /**
   * Retrieves the start time of the event
   *
   * @return this Event's start time
   */
  public String getStartTime() {
    return this.startTime;
  }

  /**
   * Retrieves the duration of the event
   *
   * @return this Event's duration
   */
  public String getDuration() {
    return this.duration;
  }


  /**
   * To set this Event's name
   *
   * @param name to be set as this event's name
   */
  public void setName(String name) {
    this.name = name;

  }

  /**
   * To set this Event's description
   *
   * @param description to be set as this event's description
   */
  public void setDescription(String description) {
    this.description = description;
  }

  /**
   * To set this Event's start time
   *
   * @param startTime to be set as this event's start time
   */
  public void setStartTime(String startTime) {
    this.startTime = startTime;
  }

  /**
   * To set this Event's duration
   *
   * @param duration to be set as this event's duration
   */
  public void setDuration(String duration) {
    this.duration = duration;
  }

  /**
   * Retrieves the day the event is on
   *
   * @return this Event's day of the week
   */
  public DayOfWeek getDay() {
    return this.day;
  }
}
