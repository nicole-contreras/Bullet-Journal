package wrapper;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.BujoJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the BujoJson class.
 */
public class TestBujoJson {

  /**
   * Tests the serialization of the record by converting it into a jsonNode
   */
  @Test
  public void testSerialization() {
    // Create an
    EventJson event1 = new EventJson("party", "39th bday party",
        "12:00", "01:00");
    EventJson event2 = new EventJson("soccer", "kid's soccer games",
        "3:30", "01:45");
    List<EventJson> events = new ArrayList<>(List.of(event1, event2));

    TaskJson task1 = new TaskJson("pick up sammy", "pick up from school",
        true);
    TaskJson task2 = new TaskJson("buy wine", "buy for Peter",
        false);

    HashMap<DayOfWeek, List<TaskJson>> taskMap = new HashMap<>();
    taskMap.put(DayOfWeek.MONDAY, asList(task1));
    taskMap.put(DayOfWeek.TUESDAY, new ArrayList<>(List.of(task2)));

    HashMap<DayOfWeek, List<EventJson>> eventMap = new HashMap<>();
    eventMap.put(DayOfWeek.MONDAY, asList(event1));
    eventMap.put(DayOfWeek.TUESDAY, asList(event2));

    BujoJson bujoJson = new BujoJson(eventMap, taskMap, "testing.css", 12, 0);

    // Serialize the event to JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(bujoJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    // Verify the serialized JSON
    String jsonEvents;
    try {
      jsonEvents = mapper.writeValueAsString(bujoJson.events().size());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // testing only the size as hashmap iterates through keys randomly
    assertEquals(
        "2",
        jsonEvents);

    String jsonTasks;
    try {
      jsonTasks = mapper.writeValueAsString(bujoJson.tasks().size());
    } catch (Exception e) {
      throw new RuntimeException(e);
    }

    // testing only the size as hashmap iterates through keys randomly
    assertEquals(
        "2",
        jsonTasks);

    assertTrue(json.toString().contains("testing.css"));
    assertTrue(json.toString().contains("0"));
    assertTrue(json.toString().contains("12"));
  }

  /**
   * Tests the deserialization of the record
   */
  @Test
  public void testDeserialization() {
    // Prepare JSON data
    String json =
        "{\"events\":{\"TUESDAY\":[{\"name\":\"soccer\",\"description\":\"kid's soccer games\","
            +
            "\"starttime\":\"3:30\",\"duration\":\"01:45\"}],"
            +
            "\"MONDAY\":[{\"name\":\"party\",\"description\":\"39th bday"
            +
            " party\",\"starttime\":\"12:00\",\"duration\":\"01:00\"}]},"
            +
            "\"tasks\":{\"TUESDAY\":[{\"name\":\"buy wine\",\""
            +
            "description\":\"buy for Peter\",\"completed\":false}],"
            +
            "\"MONDAY\":[{\"name\":\"pick up sammy\",\"description"
            + "\""
            +
            ":\"pick up from school\",\"completed\":true}]},\"theme\":\"testing.css\","
            +
            "\"maxevents\":0,\"maxtasks\":0}";

    // Deserialize the JSON to an EventJson object
    ObjectMapper mapper = new ObjectMapper();
    BujoJson bujoJson = null;
    try {
      bujoJson = mapper.readValue(json, BujoJson.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    // Verify the deserialized object
    EventJson event1 = new EventJson("party", "39th bday party",
        "12:00", "01:00");
    EventJson event2 = new EventJson("soccer", "kid's soccer games",
        "3:30", "01:45");
    HashMap<DayOfWeek, List<EventJson>> expectedEvents = new HashMap<>();
    expectedEvents.put(DayOfWeek.MONDAY, List.of(event1));
    expectedEvents.put(DayOfWeek.TUESDAY, List.of(event2));

    TaskJson task1 = new TaskJson("pick up sammy", "pick up from school",
        true);
    TaskJson task2 = new TaskJson("buy wine", "buy for Peter",
        false);

    HashMap<DayOfWeek, List<TaskJson>> expectedTasks = new HashMap<>();
    expectedTasks.put(DayOfWeek.MONDAY, asList(task1));
    expectedTasks.put(DayOfWeek.TUESDAY, new ArrayList<>(List.of(task2)));


    assertEquals(expectedTasks, bujoJson.tasks());
    assertEquals(expectedEvents, bujoJson.events());
    assertEquals("testing.css", bujoJson.cssFile());
    assertEquals(0, bujoJson.maxEvents());
    assertEquals(0, bujoJson.maxTasks());

  }
}
