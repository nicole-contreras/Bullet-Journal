package wrapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.mock;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.model.CustomThemeHandler;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

/**
 * To test the CustomThemeHandler class and it's methods
 */
public class TestCustomThemeHandler {
  private CustomThemeHandler customThemeHandler;
  private Scanner scanner;
  private Controller controller;
  private Controller mockController;
  private CustomThemeHandler mockCustomThemeHandler;

  /**
   * Initial test conditions
   */
  @BeforeEach
  void setup() {
    try {
      FileWriter clear = new FileWriter("src/test/resources/testCustomCss.css", false);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    controller = new Controller();
    customThemeHandler = new CustomThemeHandler(controller, "src/test/resources/testCustomCss.css");
    try {
      scanner = new Scanner(Path.of("src/test/resources/testCustomCss.css"));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    mockController = mock(Controller.class);
    mockCustomThemeHandler = new CustomThemeHandler(mockController, "src/test/resources/dummy.css");
  }

  /**
   * To test the setRootColor method
   */
  @Test
  void setRootColorTest() {
    customThemeHandler.setRootColor("fe0666");

    assertEquals(".root {", scanner.nextLine());
    assertEquals("    -fx-font-family: \"System\";", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
    assertEquals(".root {", scanner.nextLine());
    assertEquals("    -fx-base: #fe0666;", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
  }

  /**
   * To test the setLabelColor method
   */
  @Test
  void setLabelColorTest() {
    customThemeHandler.setLabelColor("fe0666");
    assertEquals(".root {", scanner.nextLine());
    assertEquals("    -fx-font-family: \"System\";", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
    assertEquals("#sundayEventLabel, #sundayTaskLabel, #mondayEventLabel, #mondayTaskLabel,"
        + " #tuesdayEventLabel, #tuesdayTaskLabel, #wednesdayEventLabel, #wednesdayTaskLabel, "
        + "#thursdayEventLabel, #thursdayTaskLabel, #fridayEventLabel, #fridayTaskLabel, "
        + "#saturdayEventLabel, #saturdayTaskLabel {", scanner.nextLine());
    assertEquals("    -fx-background-color:  #fe0666;", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
  }

  /**
   * To test the setAccentColor method
   */
  @Test
  void setAccentColorTest() {
    customThemeHandler.setAccentColor("fe0666");
    assertEquals(".root {", scanner.nextLine());
    assertEquals("    -fx-font-family: \"System\";", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
    assertEquals(".column-header, .tab {", scanner.nextLine());
    assertEquals("    -fx-background-color:  #fe0666;", scanner.nextLine());
    assertEquals("    -fx-border-color:  #fe0666;", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
  }

  /**
   * To test the setFontColor method
   */
  @Test
  void setTextColorTest() {
    customThemeHandler.setTextColor("fe0666");
    assertEquals(".root {", scanner.nextLine());
    assertEquals("    -fx-font-family: \"System\";", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
    assertEquals(".label {", scanner.nextLine());
    assertEquals("    -fx-text-fill: #fe0666;", scanner.nextLine());
    assertEquals("}", scanner.nextLine());
  }

  /*
   * Test the exception by giving an invalid Path
   */
  @Test
  void testCustomThemeHandlerInvalidPath() {
    assertThrows(RuntimeException.class, () -> new CustomThemeHandler(mockController, ""));
  }

  /*
   * Tests the exception of RootColorException by giving an invalid color
   */
  @Test
  void testSetRootColorException(@TempDir Path tempDir) {
    mockCustomThemeHandler.assignCss();
    assertThrows(RuntimeException.class, () -> mockCustomThemeHandler.setRootColor("FFFFFF"));
  }

  /*
   * Tests the exception of setLabelColor by giving an invalid color
   */
  @Test
  void testSetLabelColorException(@TempDir Path tempDir) {
    mockCustomThemeHandler.assignCss();
    assertThrows(RuntimeException.class, () -> mockCustomThemeHandler.setLabelColor("FFFFFF"));
  }

  /*
   * Tests the exception of setAccentColor by giving an invalid color
   */
  @Test
  void testSetAccentColorException(@TempDir Path tempDir) {
    mockCustomThemeHandler.assignCss();
    assertThrows(RuntimeException.class, () -> mockCustomThemeHandler.setAccentColor("FFFFFF"));
  }

  /*
   * Tests the exception of BackgroundColor by giving an invalid color
   */
  @Test
  void testSetBackgroundColorException(@TempDir Path tempDir) {
    mockCustomThemeHandler.assignCss();
    assertThrows(RuntimeException.class, () -> mockCustomThemeHandler.setTextColor("FFFFFF"));
  }
}
