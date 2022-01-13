package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import static frc.robot.Constants.*;

/**
 * Class for the Arm Mechanism
 */
public class Arm extends SubsystemBase{
    
    private CANSparkMax armMotor;
    
    /**
     * Initializes {@link Arm} and sets up its motor. 
     */
    public Arm(){
        super();
        armMotor = new CANSparkMax(ARM_MOTOR_ID, MotorType.kBrushless);
        armMotor.restoreFactoryDefaults();
        // Brake mode kills energy in the motor by shorting all wires
        // With high gear reductions, brake mode can highly slow down movement
        // Use PID instead to reliably hold a motor in place
        armMotor.setIdleMode(IdleMode.kBrake);
    }
    
    /**
     * Activates the arm motor with the specified speed and direction
     *
     * @param velocity the speed at which the motor should run. The sign (+ or -) indicated
     * direction while the value between 0.0 and 1.0 specifies motor speed
     */
    public void runArm(double velocity) {
        armMotor.set(velocity);
    }
}
