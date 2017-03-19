package bot;

import java.awt.Color;

import robocode.AdvancedRobot;
import robocode.HitRobotEvent;
import robocode.ScannedRobotEvent;

//INSPIRED ON SPIN BOT
public class CranberryShooter extends AdvancedRobot
{
	int TRACK_FIRE = 5;

	public void run()
	{
		initialize();

		// Loop forever
		while (true)
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

	/**
	 * onScannedRobot: We have a target. Go get it.
	 */
	public void onScannedRobot(ScannedRobotEvent e)
	{
		fire(TRACK_FIRE);
	}

	/**
	 * onHitRobot: If it's our fault, we'll stop turning and moving, so we need
	 * to turn again to keep spinning.
	 */
	public void onHitRobot(HitRobotEvent e)
	{
		if (e.getBearing() > -10 && e.getBearing() < 10)
		{
			fire(TRACK_FIRE);
		}
		if (e.isMyFault())
		{
			turnRight(10);
		}
	}

	private void initialize()
	{
		// Set colors
		setBodyColor(Color.pink);
		setGunColor(Color.red);
		setRadarColor(Color.pink);
		setScanColor(Color.yellow);
	}
}
