package cs3500.pa05.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import cs3500.pa05.json.BujoJson;
import cs3500.pa05.json.EventJson;
import cs3500.pa05.json.TaskJson;
import cs3500.pa05.model.BujoFileInformation;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.TableHandler;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * This class is responsible for reading a bujo file and parsing it into a TableView.
 */
public class BujoReader {

  private final TableHandler tableHandler;
  private final BujoFileInformation bujoFile;

  /**
   * Constructs a BujoReader.
   *
   * @param tableHandler the tableHandler to be used
   * @param bujoFile     the bujoFile to be used
   */
  public BujoReader(TableHandler tableHandler, BujoFileInformation bujoFile) {
    this.tableHandler = tableHandler;
    this.bujoFile = bujoFile;
  }

  /**
   * Parses the given file into a TableView.
   *
   * @param file the file to be parsed
   */
  public void readFromFile(File file) {
    Scanner sc;

    try {
      sc = new Scanner(new FileInputStream(file));
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    StringBuilder jsonNodeString = new StringBuilder();

    while (sc.hasNext()) {
      jsonNodeString.append(sc.next());
    }

    ObjectMapper mapper = new ObjectMapper();

    JsonNode jsonNode = null;
    try {
      jsonNode = mapper.readTree(jsonNodeString.toString());
      BujoJson metaData = mapper.convertValue(jsonNode, BujoJson.class);

      tableHandler.setEventsMap(parseToTableViewEvent(metaData.events()));
      tableHandler.setTasksMap(parseToTaskView(metaData.tasks()));
      tableHandler.setMaxTasks(metaData.maxTasks());
      tableHandler.setMaxEvents(metaData.maxEvents());
      bujoFile.setFileName(file.getName());
      bujoFile.setSelectedDirectory(file.getAbsoluteFile());
      bujoFile.setCssFile(metaData.cssFile());
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * Parses the given events into a TableView.
   *
   * @param events the tasks to be parsed
   * @return the TableView of events
   */
  private HashMap<DayOfWeek, TableView<Event>> parseToTableViewEvent(
      HashMap<DayOfWeek, List<EventJson>> events) {
    HashMap<DayOfWeek, TableView<Event>> hashMap = new HashMap<>();

    for (Map.Entry<DayOfWeek, List<EventJson>> mapElement : events.entrySet()) {
      DayOfWeek day = mapElement.getKey();
      TableView<Event> table = new TableView<>();

      for (EventJson eventJson : mapElement.getValue()) {
        TableColumn<Event, String> columnName = new TableColumn<>();
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Event, String> columnDescription = new TableColumn<>();
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Event, String> columnStartTime = new TableColumn<>();
        columnStartTime.setCellValueFactory(new PropertyValueFactory<>("startTime"));

        TableColumn<Event, String> columnDuration = new TableColumn<>();
        columnDuration.setCellValueFactory(new PropertyValueFactory<>("duration"));

        Event event = new Event(eventJson.name(), eventJson.description(),
            eventJson.time(), eventJson.duration(), day);

        table.getColumns().addAll(columnName, columnDescription, columnStartTime, columnDuration);
        table.getItems().add(event);
      }
      hashMap.put(day, table);
    }
    return hashMap;
  }

  /**
   * Parses the given tasks into a TableView.
   *
   * @param tasks the tasks to be parsed
   * @return the TableView of tasks
   */
  private HashMap<DayOfWeek, TableView<Task>> parseToTaskView(
      HashMap<DayOfWeek, List<TaskJson>> tasks) {

    HashMap<DayOfWeek, TableView<Task>> hashMap = new HashMap<>();

    for (Map.Entry<DayOfWeek, List<TaskJson>> mapElement : tasks.entrySet()) {
      DayOfWeek day = mapElement.getKey();
      TableView<Task> table = new TableView<>();

      for (TaskJson taskJson : mapElement.getValue()) {
        CheckBox checkBox = new CheckBox();
        checkBox.setSelected(taskJson.completed());

        TableColumn<Task, String> columnName = new TableColumn<>();
        columnName.setCellValueFactory(new PropertyValueFactory<>("name"));

        TableColumn<Task, String> columnDescription = new TableColumn<>();
        columnDescription.setCellValueFactory(new PropertyValueFactory<>("description"));

        TableColumn<Task, CheckBox> columnCompleted = new TableColumn<>();
        columnCompleted.setCellValueFactory(new PropertyValueFactory<>("completed"));

        table.getColumns().addAll(columnName, columnDescription);

        Task task = new Task(taskJson.name(), taskJson.description(), checkBox, day);
        table.getItems().add(task);
      }

      hashMap.put(day, table);

    }
    return hashMap;
  }

}
