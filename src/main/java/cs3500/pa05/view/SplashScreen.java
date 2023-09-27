package cs3500.pa05.view;

import cs3500.pa05.controller.Controller;
import java.io.IOException;
import java.util.Objects;
import javafx.animation.FadeTransition;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 * represents a class to load the splash screen
 */
public class SplashScreen {

  /**
   * loads the splash screen
   *
   * @param anchor     the anchor pane to display on
   * @param borderPane the border pane to show after finish with splash screen
   * @param controller the controller
   */
  public void loadSplashScreen(AnchorPane anchor, BorderPane borderPane, Controller controller) {
    try {
      StackPane splashScreen = FXMLLoader.load(
          Objects.requireNonNull(getClass().getClassLoader().getResource("splashScreen.fxml")));
      anchor.getChildren().setAll(splashScreen);

      FadeTransition fadeOut = new FadeTransition(Duration.seconds(5), splashScreen);
      fadeOut.setFromValue(1);
      fadeOut.setToValue(0);
      fadeOut.setCycleCount(1);
      fadeOut.play();
      fadeOut.setOnFinished(event -> {
        anchor.getChildren().setAll(borderPane);
        controller.askForMax();

      });
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
