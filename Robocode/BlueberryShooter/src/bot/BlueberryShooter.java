package bot;
import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;

import java.awt.*;

//INSPIRED IN spin + TRACKER
public class BlueberryShooter extends AdvancedRobot
{
	String victimName; // Name of the robot we're currently tracking
	double wandTurnAmt; // How much to turn our wand when searching
	int timeTurnerLoops = 0; // Keeps track of how long we've been searching for our target
	int bombardaPower = 5; // Fire power
	
	public void run()
	{
		drinkPolyjuicePotion();
		while (true)
		{
			crucio();
			confundus();			
		}
	}

	/**
	 * onScannedRobot: Fire hard!
	 */
	public void onScannedRobot(ScannedRobotEvent e)
	{
		//SPIN
		fire(bombardaPower);
		
		//TRACKER
		if (victimName != null && !e.getName().equals(victimName)) {
			return;
		}

		// If we don't have a target, well, now we do!
		if (victimName == null) {
			victimName = e.getName();
			out.println("Tracking " + victimName);
		}
		// This is our target.  Reset timeTurnerLoops (see the run method)
		timeTurnerLoops = 0;
		// If our target is too far away, turn and move toward it.
		if (e.getDistance() > 150) {
			wandTurnAmt = e.getBearing() + (getHeading() - getRadarHeading());
			turnGunRight(wandTurnAmt);
			turnRight(e.getBearing()); // and see how much Tracker improves...
			// (you'll have to make Tracker an AdvancedRobot)
			ahead(e.getDistance() - 140);
			return;
		}

		// Our target is close.
		wandTurnAmt = e.getBearing() + (getHeading() - getRadarHeading());
		turnGunRight(wandTurnAmt);
		fire(bombardaPower);

		// Our target is too close!  Back up.
		if (e.getDistance() < 100) {
			if (e.getBearing() > -90 && e.getBearing() <= 90) {
				back(40);
			} else {
				ahead(40);
			}
		}
		scan();
	}

	/**
	 * onHitRobot: If it's our fault, we'll stop turning and moving, so we need
	 * to turn again to keep spinning.
	 */
	public void onHitRobot(HitRobotEvent e)
	{
		//spin
		if (e.getBearing() > -10 && e.getBearing() < 10)
		{
			fire(bombardaPower);
		}
		if (e.isMyFault())
		{
			turnRight(10);
		}		
	}

	private void drinkPolyjuicePotion()
	{
		// Set colors
		setBodyColor(Color.blue);
		setGunColor(Color.blue);
		setRadarColor(Color.black);
		setScanColor(Color.yellow);
	}
	
	//ajusta variaveis para procurar novo alvo
	private void crucio(){
		timeTurnerLoops++;
		// If we've haven't seen our target for 2 turns, look left
		if (timeTurnerLoops > 2) {
			wandTurnAmt = -10;
		}
		// If we still haven't seen our target for 5 turns, look right
		if (timeTurnerLoops > 5) {
			wandTurnAmt = 10;
		}
		// If we *still* haven't seen our target after 10 turns, find another target
		if (timeTurnerLoops > 11) {
			victimName = null;
		}
	}

	// moves like spin to confuse enemy
	private void confundus()
	{
		// Tell the game that when we take move,
		// we'll also want to turn right... a lot.
		setTurnRight(10000);
		// Limit our speed to 5
		setMaxVelocity(5);
		// Start moving (and turning)
		ahead(10000);
		// Repeat.
	}
}
