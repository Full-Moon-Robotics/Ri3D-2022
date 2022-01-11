// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.commands.auto.*;
import frc.robot.subsystems.*;
import static frc.robot.Constants.*;

/** Robot container with subsystems, OI devices, and commands. */
public class RobotContainer {
    // Subsystems
    private final Drivetrain drivetrain;
    private final Intake m_intake;
    private final Arm m_arm;
    private final Climber m_climber;

    // User input
    private final PS4Controller controller;
    private final DoubleSupplier throttleSupply;
    private final DoubleSupplier turnSupply;

    // Triggers
    private final JoystickButton collectButton;
    private final JoystickButton outtakeButton;
    private final JoystickButton lowerArmButton;
    private final JoystickButton raiseArmButton;
    private final JoystickButton lowerClimberButton;
    private final JoystickButton raiseClimberButton;

    /** Constructs a {@link RobotContainer} by initializing all robot system abstractions and commands.
     * <p> Only construct one.
     * Changing the button mappings should be done in {@link Constants}.
    */
    public RobotContainer() {
        drivetrain = new Drivetrain();
        m_intake = new Intake();
        m_arm = new Arm();
        m_climber = new Climber();

        controller = new PS4Controller(PS4_PORT);
        // https://docs.oracle.com/javase/tutorial/java/javaOO/lambdaexpressions.html#syntax
        throttleSupply = () -> -controller.getLeftY();
        turnSupply = () -> controller.getRightX();

        collectButton = new JoystickButton(controller, COLLECT_BUTTON.value);
        outtakeButton = new JoystickButton(controller, OUTAKE_BUTTON.value);
        lowerArmButton = new JoystickButton(controller, LOWER_ARM_BUTTON.value);
        raiseArmButton = new JoystickButton(controller, RAISE_ARM_BUTTON.value);
        lowerClimberButton = new JoystickButton(controller, LOWER_CLIMBER_BUTTON.value);
        raiseClimberButton = new JoystickButton(controller, RAISE_CLIMBER_BUTTON.value);

        drivetrain.setDefaultCommand(new DefaultDrive(
            throttleSupply, turnSupply, drivetrain));

        configureButtonBindings();
    }

    /**
     * Binds the buttons declared earlier in the constructor to commands.
     * <p> Once bound a single time here, the command will be called every time it has an appropriate input.
     * Button methods can be chained, to put multiple commands on one button with different or identical conditions.
     * Be careful about similarly named methods: whenHeld and whileHeld sound similar, but behave differently!
     */
    private void configureButtonBindings() {
        collectButton.whenHeld(new Collect(m_intake));
        outtakeButton.whenHeld(new Outtake(m_intake));
        lowerArmButton.whenHeld(new LowerArm(m_arm));
        raiseArmButton.whenHeld(new RaiseArm(m_arm));
        lowerClimberButton.whenHeld(new LowerClimber(m_climber));
        raiseClimberButton.whenHeld(new RaiseClimber(m_climber));
    }

    /**
     * Returns the {@link SimpleAuto} command to run in autonomous.
     * <p> A more sophisicated version of the this method would link to the dashboard and provide multiple options.
     */
    public Command getAutonomousCommand() {
      return new SimpleAuto(drivetrain, AUTO_SPEED, AUTO_ANGLE, AUTO_TIME);
    }
}
