// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.PS4Controller.Button;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    // IDs
    public static final int INTAKE_MOTOR_ID = 12;
    public static final int CLIMB_MOTOR_ID = 10;
    public static final int ARM_MOTOR_ID = 11;
    public static final int LEFT_DRIVE_A_ID = 5;
    public static final int LEFT_DRIVE_B_ID = 6;
    public static final int RIGHT_DRIVE_A_ID = 8;
    public static final int RIGHT_DRIVE_B_ID = 9;
    public static final int PS4_PORT = 8; // Placeholder value

    // Hard-coded speeds
    public static final double RAISE_SPEED = 0.5; // Untested value
    public static final double LOWER_SPEED = -0.5; // Untested value
    public static final double INTAKE_SPEED = 0.5; // Untested value
    public static final double OUTTAKE_SPEED = -0.5; // Untested value
    public static final double RAISE_ARM_SPEED = 0.5; // Untested value
    public static final double LOWER_ARM_SPEED = -0.5; // Untested value
    public static final double AUTO_SPEED = 0.1; // Untested value
    public static final double AUTO_ANGLE = 0.0; // Drive straight
    public static final double AUTO_TIME = 5.0; // Untested value; in seconds

    // Controller Buttons
    public static final Button COLLECT_BUTTON = Button.kL2;
    public static final Button OUTAKE_BUTTON = Button.kR2;
    public static final Button LOWER_ARM_BUTTON = Button.kL1;
    public static final Button RAISE_ARM_BUTTON = Button.kR1;
    public static final Button LOWER_CLIMBER_BUTTON = Button.kCircle;
    public static final Button RAISE_CLIMBER_BUTTON = Button.kCross;
}
