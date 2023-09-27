package cs3500.pa05.controller;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.controller.BujoWriter;
import cs3500.pa05.json.BujoJson;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * Represents a class that writes to a .bujo file
 */

public class BujoPersistence implements BujoWriter {

  private final String filePath;
  private final BujoJson metaData;

  /**
   * Instantiates the filePath to write to and the information of the file
   *
   * @param filePath the path to write to
   * @param metaData the information of the file
   */
  public BujoPersistence(String filePath, BujoJson metaData) {
    this.filePath = filePath;
    this.metaData = metaData;
  }


  /**
   * saves the file to the given path
   */
  @Override
  public void saveFile() {
    Path path = Path.of(filePath);

    ObjectMapper mapper = new ObjectMapper();
    JsonNode metaDataJson = mapper.convertValue(metaData, JsonNode.class);

    byte[] data = metaDataJson.toString().getBytes();

    try {
      Files.write(path, data);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}
