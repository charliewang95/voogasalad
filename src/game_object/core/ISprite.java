package game_object.core;

import game_object.simulation.IBodyWithImage;
import game_object.simulation.ICollisionBody;
import game_object.simulation.IPhysicsBody;
import game_object.visualization.ISpriteVisualization;

public interface ISprite extends IPhysicsBody, ICollisionBody, IBodyWithImage, ISpriteVisualization {

	void setValid(boolean valid);
	
	boolean isValid();
	
	boolean isFacingLeft();
	
	ChildSprites getChildSprites();
	
}
