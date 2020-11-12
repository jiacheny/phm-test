package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.loadui.testfx.GuiTest;
import org.testfx.api.FxToolkit;
import org.testfx.framework.junit.ApplicationTest;

import java.io.File;

import static org.junit.Assert.*;

/**
 * Created by UC196987 Jiachen Yan on 3/19/2019
 */

public class MainTest extends ApplicationTest {

  TextArea textArea;
  Label message;
  Button saveButton;

  @Override
  public void start(Stage stage) throws Exception {
    Parent mainNode = FXMLLoader.load(Main.class.getResource("sample.fxml"));
    stage.setScene(new Scene(mainNode));
    stage.show();
    stage.toFront();
  }

  @Before
  public void setUp() throws Exception {
    message = GuiTest.find("#message");
    saveButton = GuiTest.find("#saveButton");
    textArea = GuiTest.find("#textArea");
  }

  @After
  public void tearDown() throws Exception {
    FxToolkit.hideStage();
    release(new KeyCode[]{});
    release(new MouseButton[]{});
    message = null;
    saveButton = null;
    textArea = null;
  }

  @Test
  public void whitespaceContentTest() {
    clickOn(textArea);
    write("\n\n  \n\n");
    clickOn(saveButton);
    assertEquals("At least one no-whitespace character required.", message.getText());
  }

  @Test
  public void standardTest() {
    clickOn(textArea);
    write("T\n\nT");
    clickOn(saveButton);

    // because testfx cannot control system native window dialog
    // keyboard shortcut will solve the issue
    type(KeyCode.T);
    type(KeyCode.E);
    type(KeyCode.S);
    type(KeyCode.T);
    type(KeyCode.TAB);
    type(KeyCode.TAB);
    type(KeyCode.TAB);
    type(KeyCode.ENTER);

    String filePath = System.getProperty("user.home") + "\\test";
    File file = new File(filePath);
    assertEquals("Your content has been saved to " + filePath, message.getText());

    //check if exists and remove the test file
    assertTrue("Expected file is not saved.", file.exists());
    file.delete();
    assertFalse("Failed to delete testing file.", file.exists());
  }

}