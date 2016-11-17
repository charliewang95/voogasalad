package test;

import authoring.AuthoringController;
import authoring.view.MainView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;
import voogasalad_overwatch.AuthorEnvironment;

public class UITest extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		Rectangle2D primaryScreenBounds = Screen.getPrimary().getVisualBounds();
		
		double width = primaryScreenBounds.getWidth();
		double height = primaryScreenBounds.getHeight() - 20;
		//TODO adjust task bar height for Windows OS
		
		AuthorEnvironment env = new AuthorEnvironment();
		AuthoringController controller = new AuthoringController(env);
		MainView mainView = new MainView(controller);
		mainView.setPositionAndSize(0, 0, width, height);
		mainView.layout();
		Scene scn = new Scene(mainView.getUI());
		Stage stage = new Stage();
		stage.setWidth(width);
		stage.setScene(scn);
		stage.show();
		
		scn.widthProperty().addListener((val, oldWidth, newWidth) -> {
			mainView.setWidth(newWidth.doubleValue());
			mainView.layout();
		});
		scn.heightProperty().addListener((val, oldHeight, newHeight) -> {
			mainView.setHeight(newHeight.doubleValue());
			mainView.layout();
		});
	}
	
}
