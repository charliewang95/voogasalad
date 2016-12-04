package authoring;

import java.io.File;

import authoring.controller.CanvasViewController;
import authoring.controller.ComponentController;
import authoring.controller.chat.ChatController;
import authoring.controller.run.TestGameController;
import authoring.updating.AbstractPublisher;
import authoring.view.canvas.SpriteView;
import game_engine.physics.PhysicsParameterSetOptions;
import game_object.level.Level;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import serializing.Marshaller;

public class AuthoringController extends AbstractPublisher {
	
	private AuthorEnvironment myEnvironment;
	private SpriteView selectedSpriteView;
	private Scene myScene;
	
	private CanvasViewController canvasViewController;
	private ComponentController componentController;
	private TestGameController testGameController;
	private ChatController chatController;
	private Marshaller marshaller;
	
	public AuthoringController(AuthorEnvironment environment) {
		myEnvironment = environment;
		canvasViewController = new CanvasViewController();
		componentController = new ComponentController();
		testGameController = new TestGameController(this);
		chatController = new ChatController();
		marshaller = new Marshaller();
	}
	
	public CanvasViewController getCanvasViewController() {
		return canvasViewController;
	}
	
	public ComponentController getComponentController() {
		return componentController;
	}
	
	public TestGameController getTestGameController() {
		return testGameController;
	}
	
	public ChatController getChatController() {
		return chatController;
	}
	
	public Marshaller getMarshaller() {
		return marshaller;
	}
	
	public AuthorEnvironment getEnvironment() {
		return myEnvironment;
	}
	
	public void selectSpriteView(SpriteView spriteView) {
		if (spriteView == null) return;
		if (selectedSpriteView != null) {
			selectedSpriteView.indicateDeselection();
		}
		spriteView.indicateSelection();
		selectedSpriteView = spriteView;
		this.notifySubscribers();
	}
	
	public SpriteView getSelectedSpriteView() {
		return selectedSpriteView;
	}
	
	public void setScene(Scene scene) {
		myScene = scene;
		myScene.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.DELETE || event.getCode() == KeyCode.BACK_SPACE) {
				canvasViewController.delete(selectedSpriteView);
			}
			else if (event.getCode() == KeyCode.ESCAPE) {
				if (selectedSpriteView != null) {
					selectedSpriteView.indicateDeselection();
					selectedSpriteView = null;
					this.notifySubscribers();
				}
			}
		});
		File f = new File("css/style.css");
		scene.getStylesheets().clear();
		scene.getStylesheets().add(f.getPath());
	}
	
	public void setMouseCursor(Cursor type) {
		myScene.setCursor(type);
	}
	
	public void setParameter(Level level, PhysicsParameterSetOptions option, double value) {
		level.getPhysicsParameters().set(option, value);
		this.notifySubscribers();
	}

}
