// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import frc.robot.Constants;

/**
 * Interface for the climbing winch.
 */
public class Climber extends SubsystemBase {

    private CANSparkMax climbMotor;
    
    /** Creates a new Climber and prepares its motor.
     * 
     * @see Climber
    */
    public Climber() {
        super();
        climbMotor = new CANSparkMax(Constants.CLIMB_MOTOR_ID, MotorType.kBrushless);
        climbMotor.restoreFactoryDefaults();
    }

    /**
     * Set climber speed.
     */
    public void runClimber(double speed) {
        climbMotor.set(speed);
    }
}
