package ui;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class DebugView extends View {

	@Override
	protected void layoutSelf() {
		this.clearUI();
		Rectangle rect = new Rectangle(0,0,this.getWidth(),this.getHeight());
		rect.setFill(Color.BROWN);
		this.addUI(rect);
	}

}
