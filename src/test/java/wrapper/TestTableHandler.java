package wrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.controller.Task;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.TableHandler;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.TableView;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 * test class for TableHandler
 */
public class TestTableHandler {
  private TableHandler tableHandler;

  /**
   * initializes the tableHandler before each test
   */
  @BeforeEach
  public void setUp() {
    Map<DayOfWeek, TableView<Task>> tasksMap = new HashMap<>();
    Map<DayOfWeek, TableView<Event>> eventsMap = new HashMap<>();
    tableHandler = new TableHandler(tasksMap, eventsMap);
  }

  /**
   * tests the max method
   */
  @Test
  public void testMax() {
    Integer[] maxAmounts = {5, 10};
    tableHandler.max(maxAmounts);
    assertEquals(5, tableHandler.getMaxEvents());
    assertEquals(10, tableHandler.getMaxTasks());
  }

  /**
   * tests the getTasksMap method
   */
  @Test
  public void testGetTasksMap() {
    assertEquals("{}", tableHandler.getTasksMap().toString());
  }

  /**
   * tests the getEventsMap method
   */
  @Test
  public void testGetEventsMap() {
    assertEquals("{}", tableHandler.getEventsMap().toString());
  }

  /**
   * tests the setEventsMap method
   */
  @Test
  public void testSetEventsMap() {
    Map<DayOfWeek, TableView<Event>> eventsMap = new HashMap<>();
    tableHandler.setEventsMap(eventsMap);
    assertEquals("{}", tableHandler.getEventsMap().toString());
  }

  /**
   * tests the setTasksMap method
   */
  @Test
  public void testSetTasksMap() {
    Map<DayOfWeek, TableView<Task>> tasksMap = new HashMap<>();
    tableHandler.setTasksMap(tasksMap);
    assertEquals("{}", tableHandler.getTasksMap().toString());
  }

  /**
   * tests the setMaxEvents method
   */
  @Test
  public void testSetMaxEvents() {
    assertEquals(0, tableHandler.getMaxEvents());
    tableHandler.setMaxEvents(5);
    assertEquals(5, tableHandler.getMaxEvents());
  }

  /**
   * tests the setMaxTasks method
   */
  @Test
  public void testSetMaxTasks() {
    assertEquals(0, tableHandler.getMaxTasks());
    tableHandler.setMaxTasks(2);
    assertEquals(2, tableHandler.getMaxTasks());
  }
}
