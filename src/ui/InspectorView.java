package ui;

import game_object.core.ISprite;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.VBox;

public class InspectorView extends View implements ISubscriber {
	
	private SpriteView inspectedSpriteView;
	private VBox configs;
	private VBox xBox;
	private VBox yBox;
	
	public interface ITextChangeHandler {
		void handle(String newVal);
	}

	public InspectorView(AuthoringController controller) {
		super(controller);
	}
	
	@Override
	public void didUpdate(IPublisher target) {
		if (target instanceof AuthoringController) {
			inspectedSpriteView = ((AuthoringController) target).getSelectedSpriteView();
			updateUI();
		}
	}
	
	@Override
	protected void initUI() {
		this.getController().addSubscriber(this);
		configs = new VBox();
		this.addUI(configs);
	}

	@Override
	protected void layoutSelf() {
		configs.setPrefWidth(this.getWidth());
		configs.setPrefHeight(this.getHeight());
	}
	
	private void updateUI() {
		configs.getChildren().clear();
		ISprite sprite = inspectedSpriteView.getSprite();
		xBox = makeDoubleInputBox("position X", sprite.getPosition().getX(), 
				(newVal) -> {
					inspectedSpriteView.setPositionX(Double.parseDouble(newVal));
				});
		yBox = makeDoubleInputBox("position Y", sprite.getPosition().getY(), 
				(newVal) -> {
					inspectedSpriteView.setPositionY(Double.parseDouble(newVal));
				});
		configs.getChildren().addAll(xBox, yBox);
	}
	
	private VBox makeDoubleInputBox(String title, double defaultValue, 
			ITextChangeHandler handler) {
		VBox box = new VBox();
		Label label = new Label(title);
		TextField tf = new TextField(defaultValue + "");
		box.getChildren().addAll(label, tf);
		box.setPadding(new Insets(5,5,5,5));
		tf.setOnKeyPressed(event -> {
			if (event.getCode() == KeyCode.ENTER) {
				handler.handle(tf.getText());
			}
		});
		tf.focusedProperty().addListener((obs, oldVal, newVal) -> {
			if (!newVal) {
				handler.handle(tf.getText());
			}
		});
		return box;
	}

}
