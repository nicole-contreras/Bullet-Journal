package cs3500.pa05.view;


import cs3500.pa05.controller.Controller;
import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;

/**
 * the main view for the journal
 */
public class BulletJournalGui implements BulletJournalView {
  private final FXMLLoader loader;

  /**
   * constructs a new BulletJournalGui
   *
   * @param controller the controller to be used
   */
  public BulletJournalGui(Controller controller) {
    // look up and store the layout
    this.loader = new FXMLLoader();
    this.loader.setLocation(getClass().getClassLoader().getResource("bullet_journal.fxml"));
    this.loader.setController(controller);
  }


  /**
   * loads the scene
   *
   * @return the scene
   */
  @Override
  public Scene load() {
    // load the layout
    try {
      return this.loader.load();
    } catch (IOException exc) {
      throw new IllegalStateException("Unable to load layout.");
    }
  }
}
