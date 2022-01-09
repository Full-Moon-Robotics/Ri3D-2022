// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Climber;

/** Raises the climber while held. */
public class RaiseClimber extends CommandBase {
    private final Climber m_climber;

    /**
     * Create a new RaiseClimber
     *
     * @param climber the climber subsystem.
     */
    public RaiseClimber(Climber climber) {
      addRequirements(climber);
      m_climber = climber;
    }

    /**
     * Sets the climber motors to run.
     * The speed only needs to be set once.
     * If speed was set in execute(), activating LowerClimber simultaneously would be unsafe.
     */
    @Override
    public void initialize() {
      m_climber.run_climber(Constants.RAISE_SPEED);
    }

    /**
     * Stops running the climber when released.
     */
    @Override
    public void end(boolean interrupted) {
      m_climber.run_climber(0.0);
    }

    // Implement if appropriate sensors are added
    @Override
    public boolean isFinished() {
      return false;
    }
}
