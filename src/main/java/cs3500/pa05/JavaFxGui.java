package cs3500.pa05;

import cs3500.pa05.controller.Controller;
import cs3500.pa05.view.BulletJournalGui;
import cs3500.pa05.view.BulletJournalView;
import javafx.application.Application;
import javafx.stage.Stage;


/**
 * represents the application class for the program
 */
public class JavaFxGui extends Application {

  /**
   * constructs a new JavaFxGui
   */
  public JavaFxGui() {
  }

  /**
   * constructs a new JavaFxGui
   *
   * @param stage the primary stage for this application, onto which
   *              the application scene can be set.
   */
  @Override
  public void start(Stage stage) {
    Controller controller = new Controller();
    // instantiate a simple welcome GUI view
    BulletJournalView guiView = new BulletJournalGui(controller);

    try {
      // load and place the view's scene onto the stage
      stage.setScene(guiView.load());
      controller.run();

      // render the stage
      stage.setResizable(false);
      stage.show();

    } catch (IllegalStateException exc) {
      System.err.println("Unable to load GUI.");
    }
  }
}
