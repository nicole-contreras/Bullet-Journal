package wrapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.TaskJson;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * This class is used to test the TaskJson class.
 */
public class TestTaskJson {

  /**
   * This method is used to test the serialization of a TaskJson object.
   */
  @Test
  public void testSerialization() {
    String name = "Task 1";
    String description = "Description for Task 1";
    boolean completed = false;
    TaskJson taskJson = new TaskJson(name, description, completed);

    ObjectMapper mapper = new ObjectMapper();
    String json = null;
    try {
      json = mapper.writeValueAsString(taskJson);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    String expectedJson =
        "{\"name\":\"Task 1\",\"description\":\"Description for Task 1\",\"completed\":false}";
    Assertions.assertEquals(expectedJson, json);
  }

  /**
   * This method is used to test the deserialization of a TaskJson object.
   */
  @Test
  public void testDeserialization() {
    String json =
        "{\"name\":\"Task 1\",\"description\":\"Description for Task 1\",\"completed\":false}";

    ObjectMapper mapper = new ObjectMapper();
    TaskJson taskJson = null;
    try {
      taskJson = mapper.readValue(json, TaskJson.class);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }

    String expectedName = "Task 1";
    String expectedDescription = "Description for Task 1";
    boolean expectedCompleted = false;
    Assertions.assertEquals(expectedName, taskJson.name());
    Assertions.assertEquals(expectedDescription, taskJson.description());
    Assertions.assertEquals(expectedCompleted, taskJson.completed());
  }
}
