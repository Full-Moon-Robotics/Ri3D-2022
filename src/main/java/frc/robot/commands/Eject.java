// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Outtake;

/** Runs the outtake while held. */
public class Eject extends CommandBase {
    private final Outtake m_outtake;

    /**
     * Create a new Eject command
     *
     * @param outtake the outtake subsystem.
     */
    public Eject(Outtake outtake) {
      addRequirements(outtake);
      m_outtake = outtake;
    }

    /**
     * Toggles the outtake between on and off.
     */
    @Override
    public void initialize() {
      if(!m_outtake.getRunning()) {
        m_outtake.runOuttake(Constants.OUTTAKE_SPEED);
      } else {
        m_outtake.runOuttake(0.0);
      }
      m_outtake.toggleRunning();
    }

    // Implement with current monitoring as time allows
    @Override
    public boolean isFinished() {
      return false;
    }
}
