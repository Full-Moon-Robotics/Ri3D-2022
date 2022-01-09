// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Intake;

/** Runs the intake in reverse while held. */
public class Outtake extends CommandBase {
    private final Intake m_intake;

    /**
     * Create a new Outtake command
     *
     * @param intake the intake subsystem.
     */
    public Outtake(Intake intake) {
      addRequirements(intake);
      m_intake = intake;
    }

    /**
     * Sets the intake motors to run.
     * The speed only needs to be set once.
     */
    @Override
    public void initialize() {
      m_intake.runIntake(Constants.OUTTAKE_SPEED);
    }

    /**
     * Stops running the intake when released.
     */
    @Override
    public void end(boolean interrupted) {
      m_intake.runIntake(0.0);
    }

    // Implement with current monitoring as time allows
    @Override
    public boolean isFinished() {
      return false;
    }
}
