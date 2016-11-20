package game_engine.physics;

import game_object.simulation.IPhysicsBody;

public class PhysicsEngineWithFriction extends PhysicsEngine {

	protected double calculateNewHorizontalVelocity(IPhysicsBody body, double elapsedTime) {
		double vx = body.getVelocity().getXVelocity();
		double friction = (body.getVelocity().getYVelocity() == 0) ? myParams.getGroundFriction()
				: myParams.getAirFriction();
		double newvx = vx * (1 - friction);
		if (newvx < myParams.getMinThreshold()) {
			newvx = 0;
		}
		return newvx;
	}

	public void setParameters(String parameter, double value) {
		if (parameter.equals("gravity")) {
			myParams.setGravity(value);
		} else if (parameter.equals("airfriction")) {
			myParams.setAirFriction(value);
		} else if (parameter.equals("groundfriction")) {
			myParams.setGroundFriction(value);
		} else if (parameter.equals("minthreshold")) {
			myParams.setMinThreshold(value);
		} else if (parameter.equals("maxthreshold")) {
			myParams.setMaxThreshold(value);
		} else {
			//
		}
	}
}