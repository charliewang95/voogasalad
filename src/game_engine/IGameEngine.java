package game_engine;

import java.util.List;

import game_engine.physics.PhysicsParameterSetOptions;
import game_object.acting.KeyEvent;
import game_object.core.ISprite;

/**
 * Basic interface for all game engines
 * 
 * @author Charlie Wang
 */
public interface IGameEngine {
	
	/**
	 * Reads in the Game object and makes the initial map set up
	 */
	public void init();
	
	/**
	 * Closes engine or transit to other levels
	 */
	public void shutdown();

	/**
	 * Update the current map set-up by checking user input or current object parameters
	 */
	public void update(double elapsedTime);

	/**
	 * Draw out the images in each update
	 * TODO: decide how to pass to frontend
	 */
	public List<ISprite> getSprites();
	
	public void setInputList(List<KeyEvent> list);

	public void setParameter(PhysicsParameterSetOptions option, double value);
	
}
