package cs3500.pa05.controller;

import cs3500.pa05.model.BujoFileInformation;
import cs3500.pa05.model.Event;
import cs3500.pa05.model.TableHandler;
import cs3500.pa05.view.DialogueForMax;
import cs3500.pa05.view.OpenFile;
import cs3500.pa05.view.SaveCssFileView;
import cs3500.pa05.view.SaveFileView;
import cs3500.pa05.view.SplashScreen;
import cs3500.pa05.view.TableViewEditor;
import java.io.File;
import java.time.DayOfWeek;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javafx.fxml.FXML;
import javafx.scene.ImageCursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Delegates any actions of the user according to the view and model
 */
public class Controller {

  private final BujoFileInformation bujoFile = new BujoFileInformation();
  private final TableViewEditor tableViewEditor = new TableViewEditor();
  private final DialogueForMax dialogueForMax = new DialogueForMax(this);
  @FXML
  private MenuItem custom;
  @FXML
  private MenuItem darkMode;
  @FXML
  private Menu event;
  @FXML
  private Menu file;
  @FXML
  private Tab friday;
  @FXML
  private TableView<Event> fridayEvent;
  @FXML
  private TableColumn<Event, String> fridayEventDescription;
  @FXML
  private TableColumn<Event, String> fridayEventDuration;
  @FXML
  private TableColumn<Event, String> fridayEventName;
  @FXML
  private TableColumn<Event, String> fridayEventStartTime;
  @FXML
  private TableView<Task> fridayTask;
  @FXML
  private TableColumn<Task, Boolean> fridayTaskCompleted;
  @FXML
  private TableColumn<Task, String> fridayTaskDescription;
  @FXML
  private TableColumn<Task, String> fridayTaskName;
  @FXML
  private MenuItem lightMode;
  @FXML
  private MenuBar menuBar;
  @FXML
  private Tab monday;
  @FXML
  private TableView<Event> mondayEvent;
  @FXML
  private TableColumn<Event, String> mondayEventDescription;
  @FXML
  private TableColumn<Event, String> mondayEventDuration;
  @FXML
  private TableColumn<Event, String> mondayEventName;
  @FXML
  private TableColumn<Event, String> mondayEventStartTime;
  @FXML
  private TableView<Task> mondayTask;
  @FXML
  private TableColumn<Task, Boolean> mondayTaskCompleted;
  @FXML
  private TableColumn<Task, String> mondayTaskDescription;
  @FXML
  private TableColumn<Task, String> mondayTaskName;
  @FXML
  private MenuItem newEvent;
  @FXML
  private MenuItem newTask;
  @FXML
  private MenuItem newWeek;
  @FXML
  private BorderPane borderPane;
  @FXML
  private MenuItem openFile;
  @FXML
  private MenuItem playfulMode;
  @FXML
  private MenuItem removeEvent;
  @FXML
  private MenuItem removeTask;
  @FXML
  private Tab saturday;
  @FXML
  private TableView<Event> saturdayEvent;
  @FXML
  private TableColumn<Event, String> saturdayEventDescription;
  @FXML
  private TableColumn<Event, String> saturdayEventDuration;
  @FXML
  private TableColumn<Event, String> saturdayEventName;
  @FXML
  private TableColumn<Event, String> saturdayEventStartTime;
  @FXML
  private TableView<Task> saturdayTask;
  @FXML
  private TableColumn<Task, Boolean> saturdayTaskCompleted;
  @FXML
  private TableColumn<Task, String> saturdayTaskDescription;
  @FXML
  private TableColumn<Task, String> saturdayTaskName;
  @FXML
  private MenuItem saveFile;
  @FXML
  private Tab sunday;
  @FXML
  private TableView<Event> sundayEvent;
  @FXML
  private TableColumn<Event, String> sundayEventDescription;
  @FXML
  private TableColumn<Event, String> sundayEventDuration;
  @FXML
  private TableColumn<Event, String> sundayEventName;
  @FXML
  private TableColumn<Event, String> sundayEventStartTime;
  @FXML
  private TableView<Task> sundayTask;
  @FXML
  private TableColumn<Task, Boolean> sundayTaskCompleted;
  @FXML
  private TableColumn<Task, String> sundayTaskDescription;
  @FXML
  private TableColumn<Task, String> sundayTaskName;
  @FXML
  private Menu task;
  @FXML
  private Menu themes;
  @FXML
  private Tab thursday;
  @FXML
  private TableView<Event> thursdayEvent;
  @FXML
  private TableColumn<Event, String> thursdayEventDescription;
  @FXML
  private TableColumn<Event, String> thursdayEventDuration;
  @FXML
  private TableColumn<Event, String> thursdayEventName;
  @FXML
  private TableColumn<Event, String> thursdayEventStartTime;
  @FXML
  private TableView<Task> thursdayTask;
  @FXML
  private TableColumn<Task, Boolean> thursdayTaskCompleted;
  @FXML
  private TableColumn<Task, String> thursdayTaskDescription;
  @FXML
  private TableColumn<Task, String> thursdayTaskName;
  @FXML
  private Tab tuesday;
  @FXML
  private TableColumn<Event, String> tuesdayEventDuration;
  @FXML
  private TableView<Event> tuesdayEvent;
  @FXML
  private TableColumn<Event, String> tuesdayEventDescription;
  @FXML
  private TableColumn<Event, String> tuesdayEventName;
  @FXML
  private TableColumn<Event, String> tuesdayEventStartTime;
  @FXML
  private TableView<Task> tuesdayTask;
  @FXML
  private TableColumn<Task, Boolean> tuesdayTaskCompleted;
  @FXML
  private TableColumn<Task, String> tuesdayTaskDescription;
  @FXML
  private TableColumn<Task, String> tuesdayTaskName;
  @FXML
  private Tab wednesday;
  @FXML
  private Button editMax;
  @FXML
  private TableView<Event> wednesdayEvent;
  @FXML
  private TableColumn<Event, String> wednesdayEventDescription;
  @FXML
  private TableColumn<Event, String> wednesdayEventDuration;
  @FXML
  private TableColumn<Event, String> wednesdayEventName;
  @FXML
  private TableColumn<Event, String> wednesdayEventStartTime;
  @FXML
  private TableView<Task> wednesdayTask;
  @FXML
  private Scene root;
  @FXML
  private AnchorPane anchor;
  @FXML
  private TableColumn<Task, Boolean> wednesdayTaskCompleted;
  @FXML
  private TableColumn<Task, String> wednesdayTaskDescription;
  @FXML
  private TableColumn<Task, String> wednesdayTaskName;
  @FXML
  private MenuItem weekTemplate;
  @FXML
  private TabPane weekView;
  private HashMap<DayOfWeek, TableView<Task>> taskMap;
  private HashMap<DayOfWeek, TableView<Event>> eventMap;
  private TableHandler tableHandler = new TableHandler();

  /**
   * Initializes the actions of the menu bar items.
   */
  private void initMenuItems() {
    newEvent.setOnAction(new HandleMenuEvent(this));
    removeEvent.setOnAction(new HandleMenuEvent(this));
    newTask.setOnAction(new HandleMenuEvent(this));
    removeTask.setOnAction(new HandleMenuEvent(this));

    newWeek.setOnAction(e -> newWeekFileResponse());
    weekTemplate.setOnAction(e -> templateResponse());
    openFile.setOnAction(e -> openFileResponse());
    saveFile.setOnAction(e -> saveFileResponse());
    lightMode.setOnAction(e -> setStyleSheetResponse("lightMode.css"));
    darkMode.setOnAction(e -> setStyleSheetResponse("darkMode.css"));
    playfulMode.setOnAction(e -> setStyleSheetResponse("playfulMode.css"));
    custom.setOnAction(e -> new SaveCssFileView(this).savePopUp(bujoFile));
    editMax.setOnAction(
        e -> dialogueForMax.askForMax(tableHandler.getMaxTasks(), tableHandler.getMaxEvents()));
    new ShortcutHandler(this, bujoFile).handleShortcuts(tableHandler);
  }

  /**
   * The action event of the menu bar item "New Week".
   */
  public void newWeekFileResponse() {
    saveFileResponse();

    if (bujoFile.getSelectedDirectory() != null) {
      for (DayOfWeek day : taskMap.keySet()) {
        taskMap.get(day).getItems().clear();
      }
      for (DayOfWeek day : eventMap.keySet()) {
        eventMap.get(day).getItems().clear();
      }
      setStyleSheetResponse("lightMode.css");
      bujoFile.setFileName(null);
      bujoFile.setSelectedDirectory(null);

      bujoFile.setCssFile("lightMode.css");

      tableHandler.setEventsMap(new HashMap<>());
      tableHandler.setTasksMap(new HashMap<>());
    }
  }

  /**
   * The action event of the menu bar item "Open As Template".
   */
  public void templateResponse() {
    new OpenFile(tableHandler, bujoFile).displayPopUp();

    if (bujoFile.getSelectedDirectory() != null) {
      for (DayOfWeek day : taskMap.keySet()) {
        taskMap.get(day).getItems().clear();
      }
      for (DayOfWeek day : eventMap.keySet()) {
        eventMap.get(day).getItems().clear();
      }
      setStyleSheetResponse(bujoFile.getCssFile());
      bujoFile.setFileName(null);
      bujoFile.setSelectedDirectory(null);

      tableHandler.setEventsMap(new HashMap<>());
      tableHandler.setTasksMap(new HashMap<>());
    }
  }

  /**
   * The action event of the menu bar item "Open File".
   */
  public void openFileResponse() {
    new OpenFile(tableHandler, bujoFile).displayPopUp();

    if (bujoFile.getSelectedDirectory() != null) {
      eventMap = new HashMap<>(tableHandler.getEventsMap());

      for (DayOfWeek day : eventMap.keySet()) {
        switch (day) {
          case MONDAY -> mondayEvent.setItems(eventMap.get(day).getItems());
          case TUESDAY -> tuesdayEvent.setItems(eventMap.get(day).getItems());
          case WEDNESDAY -> wednesdayEvent.setItems(eventMap.get(day).getItems());
          case THURSDAY -> thursdayEvent.setItems(eventMap.get(day).getItems());
          case FRIDAY -> fridayEvent.setItems(eventMap.get(day).getItems());
          case SATURDAY -> saturdayEvent.setItems(eventMap.get(day).getItems());
          case SUNDAY -> sundayEvent.setItems(eventMap.get(day).getItems());
          default -> {
            break;
          }
        }
      }

      taskMap = new HashMap<>(tableHandler.getTasksMap());

      for (DayOfWeek day : taskMap.keySet()) {
        switch (day) {
          case MONDAY -> mondayTask.setItems(taskMap.get(day).getItems());
          case TUESDAY -> tuesdayTask.setItems(taskMap.get(day).getItems());
          case WEDNESDAY -> wednesdayTask.setItems(taskMap.get(day).getItems());
          case THURSDAY -> thursdayTask.setItems(taskMap.get(day).getItems());
          case FRIDAY -> fridayTask.setItems(taskMap.get(day).getItems());
          case SATURDAY -> saturdayTask.setItems(taskMap.get(day).getItems());
          case SUNDAY -> sundayTask.setItems(taskMap.get(day).getItems());
          default -> {
            break;
          }
        }
      }
      setStyleSheetResponse(bujoFile.getCssFile());
    }
  }

  /**
   * Initializes the columns of each TableView
   */
  private void initColumns() {
    List<TableColumn<?, ?>> events =
        Arrays.asList(sundayEventDescription, mondayEventName, mondayEventDescription,
            mondayEventStartTime, mondayEventDuration, tuesdayEventName, tuesdayEventDescription,
            tuesdayEventStartTime, tuesdayEventDuration, wednesdayEventName,
            wednesdayEventDescription, wednesdayEventStartTime, wednesdayEventDuration,
            thursdayEventName, thursdayEventDescription, thursdayEventStartTime,
            thursdayEventDuration, fridayEventName, fridayEventDescription,
            fridayEventStartTime, fridayEventDuration, saturdayEventName, saturdayEventDescription,
            saturdayEventStartTime, saturdayEventDuration, sundayEventName,
            sundayEventStartTime, sundayEventDuration, mondayTaskName, mondayTaskDescription,
            mondayTaskCompleted, tuesdayTaskName, tuesdayTaskDescription, tuesdayTaskCompleted,
            wednesdayTaskName, wednesdayTaskDescription, wednesdayTaskCompleted, thursdayTaskName,
            thursdayTaskDescription, thursdayTaskCompleted, fridayTaskName, fridayTaskDescription,
            fridayTaskCompleted, saturdayTaskName, saturdayTaskDescription, saturdayTaskCompleted,
            sundayTaskName, sundayTaskDescription, sundayTaskCompleted);

    for (TableColumn column : events) {
      if (column.getId().contains("Name")) {
        column.setCellValueFactory(new PropertyValueFactory<>("name"));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setOnEditCommit(new TableEditor("Name"));
      }
      if (column.getId().contains("Description")) {
        column.setCellValueFactory(new PropertyValueFactory<>("description"));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setOnEditCommit(new TableEditor("Description"));
      }
      if (column.getId().contains("StartTime")) {
        column.setCellValueFactory(new PropertyValueFactory<>("startTime"));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setOnEditCommit(new TableEditor("StartTime"));
      }
      if (column.getId().contains("Duration")) {
        column.setCellValueFactory(new PropertyValueFactory<>("duration"));
        column.setCellFactory(TextFieldTableCell.forTableColumn());
        column.setOnEditCommit(new TableEditor("Duration"));
      }
      if (column.getId().contains("Completed")) {
        column.setCellValueFactory(new PropertyValueFactory<>("completed"));
      }
    }
  }

  /**
   * Loads the splash screen and initializes the menu and table items.
   */
  @FXML
  public void run() {
    new SplashScreen().loadSplashScreen(anchor, borderPane, this);
    initMenuItems();
    initColumns();
    initTables();
    root.getStylesheets().add("lightMode.css");
  }

  /**
   * returns the root which is the scene.
   *
   * @return the scene
   */
  public Scene getRoot() {
    return root;
  }

  /**
   * Delegates to the view to ask for the max number of tasks and events.
   */
  public void askForMax() {
    dialogueForMax.askForMax(tableHandler.getMaxTasks(), tableHandler.getMaxEvents());
  }

  /**
   * Sets the max number of tasks and events.
   *
   * @param maxEvents the max number of events
   * @param maxTasks  the max number of tasks
   */
  public void setMax(int maxEvents, int maxTasks) {
    tableHandler.max(new Integer[] {maxEvents, maxTasks});
  }

  /**
   * Initializes the hashmap that maps the day of the week to the table.
   */
  private void initTables() {
    taskMap = new HashMap<>(Map.of(DayOfWeek.MONDAY, mondayTask,
        DayOfWeek.TUESDAY, tuesdayTask, DayOfWeek.WEDNESDAY, wednesdayTask,
        DayOfWeek.THURSDAY, thursdayTask, DayOfWeek.FRIDAY, fridayTask,
        DayOfWeek.SATURDAY, saturdayTask, DayOfWeek.SUNDAY, sundayTask));
    eventMap = new HashMap<>(Map.of(DayOfWeek.MONDAY, mondayEvent,
        DayOfWeek.TUESDAY, tuesdayEvent, DayOfWeek.WEDNESDAY, wednesdayEvent,
        DayOfWeek.THURSDAY, thursdayEvent, DayOfWeek.FRIDAY, fridayEvent,
        DayOfWeek.SATURDAY, saturdayEvent, DayOfWeek.SUNDAY, sundayEvent));
    tableHandler = new TableHandler(taskMap, eventMap);
    new RightClickHandler().addRightClicks(taskMap, eventMap);
  }


  /**
   * Delegates to the view to remove the event user requested
   *
   * @param isEvent the event that has been clicked
   */
  public void remove(Boolean isEvent) {
    tableViewEditor.remove(isEvent);
  }

  /**
   * Delegates to the model to add the task user requested
   *
   * @param name        the name of task
   * @param description the description of task
   * @param day         the day of task
   */
  public void addTask(String name, String description, DayOfWeek day) {
    int maxTasks = tableHandler.getMaxTasks();
    tableHandler.setTasksMap(tableViewEditor.addTask(name, description, day, taskMap, maxTasks));
  }

  /**
   * Delegates to the model to add the event user requested
   *
   * @param name        the name of task
   * @param description the description of task
   * @param start       the start time of task
   * @param duration    the duration of task
   * @param day         the day of task
   */
  public void addEvent(String name, String description, String start, String duration,
                       DayOfWeek day) {
    int maxEvents = tableHandler.getMaxEvents();

    tableHandler.setEventsMap(
        tableViewEditor.addEvent(name, description, start, duration, day, eventMap,
            maxEvents));
  }

  /**
   * Action event that is called when the user clicks the save button.
   * Delegates to the view to have a popup that saves the file.
   */
  public void saveFileResponse() {
    new SaveFileView().savePopUp(bujoFile);

    if (bujoFile.getSelectedDirectory() != null) {
      String path = root.getStylesheets().toString();
      if (path.contains("/src")) {
        path = path.substring(path.indexOf("src"), path.length() - 1);
      }

      if (path.contains("notificationpopup.css")) {
        path = path.substring(path.indexOf("notificationpopup.css, ") + 23, path.length() - 1);
      }

      ParseInformation parse =
          new ParseInformation(bujoFile.getSelectedDirectory().toString(), eventMap, taskMap,
              path, tableHandler.getMaxEvents(),
              tableHandler.getMaxTasks());

      parse.saveFile();
    }
  }

  /**
   * sets the stylesheet of the scene.
   *
   * @param stylesheet the stylesheet to be set
   */
  public void setStyleSheetResponse(String stylesheet) {

    root.getStylesheets().clear();

    File file = null;
    if (!stylesheet.contains("src")) {
      file = new File("src/main/resources/" + stylesheet);
    } else {
      file = new File(stylesheet);
    }
    root.getStylesheets().add(file.toURI().toString());
  }

}
