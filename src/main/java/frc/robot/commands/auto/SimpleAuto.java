// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.auto;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

/** A trivial auto routine that drives at a set direction and angle for some time.
 * <p> While a more complex auto routine is obviously more valuable, driving forward still scores points.
 * Keep a simple auto routine to drive forward, and/or a routine to drive forward and score one ball as insurance.
 * <p> Keeping another simple routine that relies on encoders instead of a timer is slightly more effective on a robot with functioning encoders.
*/
public class SimpleAuto extends CommandBase {
    private final Drivetrain m_drivetrain;
    private final double speed;
    private final double angle;
    private final double time;

    private final Timer timer;

    /**
     * Create a new {@link SimpleAuto} command
     * 
     * @param drivetrain {@link Drivetrain}
     * @param speed A constant speed to drive at (-1.0 to 1.0, negative is backwards)
     * @param angle A constant angle to head towards (-1.0 to 1.0)
     * @param time How many seconds to run
     */
    public SimpleAuto(Drivetrain drivetrain, double speed, double angle, double time) {
      addRequirements(drivetrain);
      m_drivetrain = drivetrain;
      this.speed = speed;
      this.angle = angle;
      this.time = time;
      timer = new Timer();
      timer.reset();
      timer.start();
    }

    /**
     * Drives forward at a constant speed and angle.
     */
    @Override
    public void initialize() {
      m_drivetrain.arcadeDrive(speed, angle);
    }

    /**
     * Stop driving.
     */
    @Override
    public void end(boolean interrupted) {
      m_drivetrain.arcadeDrive(0.0, 0.0);
    }

    /**
     * Finished after some amount of time has passed.
     */
    @Override
    public boolean isFinished() {
      return timer.hasElapsed(time);
    }
}
