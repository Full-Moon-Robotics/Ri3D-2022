package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.drive.DifferentialDrive.WheelSpeeds;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {
    
    // declare drive motor ESCs
    private CANSparkMax leftA = new CANSparkMax(LEFT_DRIVE_A_ID, MotorType.kBrushless);
    private CANSparkMax leftB = new CANSparkMax(LEFT_DRIVE_B_ID, MotorType.kBrushless);

    private CANSparkMax rightA = new CANSparkMax(RIGHT_DRIVE_A_ID, MotorType.kBrushless);
    private CANSparkMax rightB = new CANSparkMax(RIGHT_DRIVE_B_ID, MotorType.kBrushless);

    /**
     * 
     */
    public Drivetrain() {
        super();

        leftA.restoreFactoryDefaults();
        leftB.restoreFactoryDefaults();

        rightA.restoreFactoryDefaults();
        rightB.restoreFactoryDefaults();

        leftA.setIdleMode(IdleMode.kBrake);
        leftB.setIdleMode(IdleMode.kBrake);

        rightA.setIdleMode(IdleMode.kBrake);
        rightB.setIdleMode(IdleMode.kBrake);

        // As of 2022, drivetrain motors are not automatically inverted
        // invert the right side of the drivetrain so forward moves it forward
        rightA.setInverted(true);

        leftB.follow(leftA);
        rightB.follow(rightA);
    }

    /**
     * Use a basic arcade drive with given input parameters
     * @param throttle -1.0 .. 1.0 for speed
     * @param turn -1.0 .. 1.0 for turn
     */
    public void arcadeDrive(double throttle, double turn) {
        // convert from forward and turn speeds to individual wheel speeds
        WheelSpeeds w = DifferentialDrive.arcadeDriveIK(throttle, turn, true);

        leftA.set(w.left);
        rightA.set(w.right);
    }

    

}
