package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Class for the Outtake Mechanism
 */
public class Arm extends SubsystemBase{
    
    private CANSparkMax armMotor;
    
    /**
     * Constructor for Outtake Motor. 
     * Initializes Outtake and sets up its outtake motor. 
     * 
     * @see Arm
     */
    public Arm(){
        super();
        armMotor = new CANSparkMax(Constants.ARM_MOTOR_ID, MotorType.kBrushed);
        armMotor.restoreFactoryDefaults();
    }
    
    /**
     * Activates the outtake motor with the specified speed and direction
     *
     * @param velocity the speed at which the motor should run. The sign (+ or -) indicated
     * direction while the value between 0.0 and 1.0 specifies motor speed
     */
    public void runArm(double velocity) {
        armMotor.set(velocity);
    }
}
