package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Interface for the Cargo intake.
 */
public class Intake extends SubsystemBase{
    
    private CANSparkMax intakeMotor;
    
    /**
     * Creates a new Intake and prepares its motor.
     * 
     * @see Intake
     */
    public Intake(){
        super();
        intakeMotor = new CANSparkMax(Constants.INTAKE_MOTOR_ID, MotorType.kBrushed);
        intakeMotor.restoreFactoryDefaults();

    }
    
    /**
     * Sets an angular velocity for the motor.
     * Ranges from -1.0 to 1.0 (0 is no rotation).
     *
     * @param speed the intended direction (sign) and percent of maximum motor speed (0 to 1) 
     */
    public void runIntake(double speed) {
        // For expected behavior (positive values taking in balls), the sign is flipped.
        intakeMotor.set(speed);
    }

}
