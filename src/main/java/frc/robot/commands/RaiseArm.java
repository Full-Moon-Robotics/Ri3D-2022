// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Arm;

/** Raises the arm while held. */
public class RaiseArm extends CommandBase {
    private final Arm m_arm;

    /**
     * Create a new RaiseArm command
     *
     * @param arm the arm subsystem.
     */
    public RaiseArm(Arm arm) {
      addRequirements(arm);
      m_arm = arm;
    }

    /**
     * Sets the arm motors to run.
     * The speed only needs to be set once.
     */
    @Override
    public void initialize() {
      m_arm.runArm(Constants.RAISE_ARM_SPEED);
    }

    /**
     * Stops running the arm when released.
     */
    @Override
    public void end(boolean interrupted) {
      m_arm.runArm(0.0);
    }

    // Implement with current monitoring as time allows
    @Override
    public boolean isFinished() {
      return false;
    }
}
