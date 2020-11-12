package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Controller {

  @FXML
  private GridPane mainWindow;
  @FXML
  private TextArea textArea;
  @FXML
  private Label message;

  public void saveClicked(ActionEvent event) {
    message.setText("");
    if (textArea.getText().trim().length() == 0) {
      setErrorMessage();
    } else {
      File file = getFile();
      if (file != null) {
        saveFile(file, textArea.getText());
        setSuccessMessage(file);
      }
    }
  }

  private File getFile() {
    Stage stage = (Stage) mainWindow.getScene().getWindow();
    FileChooser fileChooser = new FileChooser();
    fileChooser.setInitialDirectory(new File(System.getProperty("user.home")));
    fileChooser.setTitle("Save text");
    fileChooser.getExtensionFilters().addAll(
        new FileChooser.ExtensionFilter("All Files", "*.*"),
        new FileChooser.ExtensionFilter("TXT Files", "*.txt")
    );
    return fileChooser.showSaveDialog(stage);
  }

  private void saveFile(File file, String content) {
    try {
      FileWriter fileWriter = new FileWriter(file);
      fileWriter.write(content);
      fileWriter.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void setErrorMessage(){
    message.setText("At least one no-whitespace character required.");
    message.setTextFill(Color.RED);
  }

  private void setSuccessMessage(File file){
    message.setText("Your content has been saved to " + file.getAbsolutePath());
    message.setTextFill(Color.BLACK);
  }

}
