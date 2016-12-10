package game_engine.enemyai;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

import game_object.acting.ActionName;
import game_object.character.ICharacter;
import game_object.character.IMover;
import game_object.weapon.Projectile;

/**
 * abstract class for all enemy controller; contains the universal input
 * executer
 * 
 * @author Charlie Wang
 *
 */
public abstract class AbstractEnemyController implements IEnemyController {

	protected Random myRandom;
	protected Set<Projectile> myProjectiles;

	public AbstractEnemyController() {
		myRandom = new Random();
		myProjectiles = new HashSet<Projectile>();
	}

	public void executeInput(IMover enemy, Set<ActionName> events) {
		myProjectiles = new HashSet<Projectile>();
		for (ActionName e : events) {
			if (e == ActionName.JUMP)
				enemy.jumpUp();
			else if (e == ActionName.MOVE_LEFT)
				enemy.moveLeft();
			else if (e == ActionName.MOVE_RIGHT)
				enemy.moveRight();
			else if (e == ActionName.SHOOT) {
				ICharacter character = (ICharacter) enemy;
				Projectile p = ProjectileManager.addProjectile(character);
				if (p != null) {
					myProjectiles.add(ProjectileManager.addProjectile(character));
				}
			}
		}
	}

	public Set<Projectile> getNewProjectiles() {
		return myProjectiles;
	}
}
