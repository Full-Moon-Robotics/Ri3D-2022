package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

public class Drivetrain extends SubsystemBase {
    
    // declare drive motor ESCs
    private CANSparkMax leftA = new CANSparkMax(LEFT_DRIVE_A_ID, MotorType.kBrushless);
    private CANSparkMax leftB = new CANSparkMax(LEFT_DRIVE_B_ID, MotorType.kBrushless);

    private CANSparkMax rightA = new CANSparkMax(RIGHT_DRIVE_A_ID, MotorType.kBrushless);
    private CANSparkMax rightB = new CANSparkMax(RIGHT_DRIVE_B_ID, MotorType.kBrushless);

    private DifferentialDrive differentialDrive = new DifferentialDrive(leftA, rightA);

    /**
     * 
     */
    public Drivetrain() {
        super();

        leftA.restoreFactoryDefaults();
        leftB.restoreFactoryDefaults();

        rightA.restoreFactoryDefaults();
        rightB.restoreFactoryDefaults();

        leftB.follow(leftA);
        rightB.follow(leftB);
        // TODO finish ESC config when we have more info on them
    }

    /**
     * Use a basic arcade drive with given input parameters
     * @param throttle -1.0 .. 1.0 for speed
     * @param turn -1.0 .. 1.0 for turn
     */
    public void arcadeDrive(double throttle, double turn) {
        differentialDrive.arcadeDrive(throttle, turn);
    }

}
