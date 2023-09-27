package cs3500.pa05.model;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.view.CustomThemePopUp;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * To perform actions related to creating custom themes
 */
public class CustomThemeHandler {
  private final FileWriter fileWriter;
  private final Controller controller;
  private final File cssFile;

  /**
   * To instantiate a CustomThemeHandler
   *
   * @param controller the application's controller
   * @param customCss the string filepath/filename for the css file to be made
   */
  public CustomThemeHandler(Controller controller, String customCss) {
    this.controller = controller;
    if (!customCss.contains("src")) {
      this.cssFile = new File("src/main/resources/" + customCss);
    } else {
      this.cssFile = new File(customCss);
    }
    try {
      this.fileWriter = new FileWriter(cssFile, true);
      fileWriter.append("""
          .root {
              -fx-font-family: "System";
          }
          """);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * To trigger the custom theme creator popup
   */
  public void handleCustomTheme() {
    new CustomThemePopUp(this).displayPopUp();
  }

  /**
   * To trigger the save css file popup
   */
  public void assignCss() {
    try {
      fileWriter.close();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    controller.setStyleSheetResponse(cssFile.toString());
  }


  /**
   * To set the base color of the bullet journal
   *
   * @param color the color to set as the root color
   */
  public void setRootColor(String color) {
    try {
      fileWriter.append(".root {\n"
          + "    -fx-base: #" + color + ";\n"
          + "}\n");
      fileWriter.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * To set the label color of the bullet journal
   *
   * @param color the color to set as the label color
   */
  public void setLabelColor(String color) {
    try {
      fileWriter.append("#sundayEventLabel, #sundayTaskLabel, #mondayEventLabel, #mondayTaskLabel,"
          + " #tuesdayEventLabel, #tuesdayTaskLabel, #wednesdayEventLabel, #wednesdayTaskLabel, "
          + "#thursdayEventLabel, #thursdayTaskLabel, #fridayEventLabel, #fridayTaskLabel, "
          + "#saturdayEventLabel, #saturdayTaskLabel {\n"
          + "    -fx-background-color:  #" + color + ";\n"
          + "}\n");
      fileWriter.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * To set the accent color of the bullet journal
   *
   * @param color the color to set as the accent color
   */
  public void setAccentColor(String color) {
    try {
      fileWriter.append(".column-header, .tab {\n"
          + "    -fx-background-color:  #" + color + ";\n"
          + "    -fx-border-color:  #" + color + ";\n"
          + "}\n");
      fileWriter.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * To set the text fields color of the bullet journal
   *
   * @param color the color to set as the background color
   */
  public void setTextColor(String color) {
    try {
      fileWriter.append(".label {\n"
          + "    -fx-text-fill: #" + color + ";\n"
          + "}\n");;
      fileWriter.flush();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

}
