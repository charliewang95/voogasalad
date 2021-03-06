package game_object.simulation;

import game_engine.collision.CollisionEngine.CollisionDirection;
import game_object.block.Block;
import game_object.character.Enemy;
import game_object.character.Hero;
import game_object.powerup.IPowerUp;

public interface ICollisionBody extends IBodyWithPosition {
	
	void setCategoryBitMask(int categoryBitMask);
	
	int getCategoryBitMask();
	
	void setCollisionBitMask(int collisionBitMask);
	
	int getCollisionBitMask();
	
	void onCollideWith(ICollisionBody otherBody, CollisionDirection collisionDirection);
	
	void onCollideWith(Hero h, CollisionDirection collisionDirection);
	
	void onCollideWith(Enemy e, CollisionDirection collisionDirection);
	
	void onCollideWith(Block b, CollisionDirection collisionDirection);
	
	void onCollideWith(IPowerUp p, CollisionDirection collisionDirection);
	
}
