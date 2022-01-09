// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj.PS4Controller;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import frc.robot.commands.*;
import frc.robot.subsystems.*;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {
    // Subsystems
    private final Drivetrain drivetrain = new Drivetrain();
    private final Intake m_intake;
    private final Arm m_arm;
    private final Climber m_climber;

    // JOYSTICK
    private PS4Controller controller = new PS4Controller(0);

    // Axis suppliers
    final DoubleSupplier throttleSupply = () -> -controller.getLeftY();
    final DoubleSupplier turnSupply = () -> controller.getRightX();

    // Triggers
    private final JoystickButton collectButton;
	private final JoystickButton outtakeButton;
	private final JoystickButton lowerArmButton;
    private final JoystickButton raiseArmButton;
	private final JoystickButton lowerClimberButton;
    private final JoystickButton raiseClimberButton;

    /** The container for the robot. Contains subsystems, OI devices, and commands. */
    public RobotContainer() {

        drivetrain.setDefaultCommand(new DefaultDrive(
            throttleSupply, turnSupply, drivetrain));

        m_intake = new Intake();
        m_arm = new Arm();
        m_climber = new Climber();

        collectButton = new JoystickButton(controller, Constants.COLLECT_BUTTON.value);
        outtakeButton = new JoystickButton(controller, Constants.OUTAKE_BUTTON.value);
        lowerArmButton = new JoystickButton(controller, Constants.LOWER_ARM_BUTTON.value);
        raiseArmButton = new JoystickButton(controller, Constants.RAISE_ARM_BUTTON.value);
        lowerClimberButton = new JoystickButton(controller, Constants.LOWER_CLIMBER_BUTTON.value);
        raiseClimberButton = new JoystickButton(controller, Constants.RAISE_CLIMBER_BUTTON.value);

        // Configure the button bindings
        configureButtonBindings();
    }

    /**
     * Use this method to define your button->command mappings. Buttons can be created by
     * instantiating a {@link GenericHID} or one of its subclasses ({@link
     * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a {@link
     * edu.wpi.first.wpilibj2.command.button.JoystickButton}.
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
     * Use this to pass the autonomous command to the main {@link Robot} class.
     *
     * @return the command to run in autonomous
     */
    public Command getAutonomousCommand() {
      // An ExampleCommand will run in autonomous
      return null;
    }
}
