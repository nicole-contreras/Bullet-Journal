package wrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.EventJson;
import org.junit.jupiter.api.Test;

/**
 * Tester for EventJson
 */
public class TestEventJson {
  /**
   * tests the serialisation
   */
  @Test
  public void testSerialization() {
    // Create an event
    String name = "Test 1";
    String description = "Description for Test 1";
    String startTime = "09:00";
    String duration = "11:11";
    EventJson eventJson = new EventJson(name, description, startTime, duration);

    // Serialize the event to JSON
    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(eventJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    // Verify the serialized JSON
    String expectedJson =
        "{\"name\":\"Test 1\",\"description\":\"Description for Test 1\","
            +
            "\"starttime\":\"09:00\",\"duration\":\"11:11\"}";
    assertEquals(expectedJson, json);
  }

  /**
   * tests the deserialization
   */
  @Test
  public void testDeserialization() {
    // Prepare JSON data
    String json =
        "{\"name\":\"Event 1\",\"description\":\"Description for Event 1\","
            +
            "\"starttime\":\"09:00\",\"duration\":\"11:11\"}";

    // Deserialize the JSON to an EventJson object
    ObjectMapper mapper = new ObjectMapper();
    EventJson eventJson = null;
    try {
      eventJson = mapper.readValue(json, EventJson.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    // Verify the deserialized object
    String expectedName = "Event 1";
    String expectedDescription = "Description for Event 1";
    String expectedStartTime = "09:00";
    assertEquals(expectedName, eventJson.name());
    assertEquals(expectedDescription, eventJson.description());
    assertEquals(expectedStartTime, eventJson.time());
    assertEquals("11:11", eventJson.duration());
  }
}
