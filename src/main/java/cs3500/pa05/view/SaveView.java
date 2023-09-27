package cs3500.pa05.view;

import cs3500.pa05.model.BujoFileInformation;

/**
 * Represents a SaveView that allows the user to save their bujo file.
 */
public interface SaveView {

  /**
   * Displays a dialog box to save a file.
   *
   * @param bujo the information to be saved
   */
  void savePopUp(BujoFileInformation bujo);
}
