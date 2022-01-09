package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

/**
 * Class for the Outtake Mechanism
 */
public class Outtake extends SubsystemBase{
    
    private CANSparkMax outtakeMotor;
    private boolean running;
    
    /**
     * Constructor for Outtake Motor. 
     * Initializes Outtake and sets up its outtake motor. 
     * 
     * @see Outtake
     */
    public Outtake(){
        super();
        outtakeMotor = new CANSparkMax(Constants.OUTTAKE_MOTOR_ID, MotorType.kBrushed);
        outtakeMotor.restoreFactoryDefaults();
        outtakeMotor.setInverted(true);
        running = false;
    }
    
    /**
     * Activates the outtake motor with the specified speed and direction
     *
     * @param velocity the speed at which the motor should run. The sign (+ or -) indicated
     * direction while the value between 0.0 and 1.0 specifies motor speed
     */
    public void run_outtake(double velocity) {
        outtakeMotor.set(-velocity);
    }

    public boolean getRunning() { return running; }

    public void toggleRunning() { running = !running; }

}
