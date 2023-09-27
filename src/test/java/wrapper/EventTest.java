package wrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import cs3500.pa05.model.Event;
import java.time.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 *  Represents the test for an Event class
 */
public class EventTest {

  private Event event1;

  /**
   *  initializes the event before each test
   */
  @BeforeEach
  public void setUp() {
    event1 = new Event("Beach Day", "Going to the beach", "11:00",
        "1:00", DayOfWeek.MONDAY);
  }

  /**
   *  Tests the setters and getters for Duration
   */
  @Test
  public void testSetGetDuration() {

    assertEquals("1:00", event1.getDuration());

    event1.setDuration("3:00");

    assertEquals("3:00", event1.getDuration());
  }

  /**
   *  Tests the setters and getters for Name
   */
  @Test
  public void testSetGetName() {

    assertEquals("Beach Day", event1.getName());

    event1.setName("Pizza Day");

    assertEquals("Pizza Day", event1.getName());

  }

  /**
   *  Tests the setters and getters for Description
   */
  @Test
  public void testSetGetDescription() {

    assertEquals("Going to the beach", event1.getDescription());

    event1.setDescription("Going to the beach ft kids");

    assertEquals("Going to the beach ft kids", event1.getDescription());

  }

  /**
   *  Tests the setters and getters for Start Time
   */
  @Test
  public void testSetGetStartTime() {

    assertEquals("11:00", event1.getStartTime());

    event1.setStartTime("12:20");

    assertEquals("12:20", event1.getStartTime());

  }

  /**
   *  Tests the setters and getters for DayOfWeek
   */
  @Test
  public void testGetDay() {
    assertEquals(DayOfWeek.MONDAY, event1.getDay());

    Event event2 = new Event("Beach Day", "Going to the beach", "11:00",
        "1:00", DayOfWeek.FRIDAY);

    assertEquals(DayOfWeek.FRIDAY, event2.getDay());

  }
}
