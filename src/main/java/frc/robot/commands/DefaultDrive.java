package frc.robot.commands;

import java.util.function.DoubleSupplier;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.Drivetrain;

public class DefaultDrive extends CommandBase {
    
    /** Drivetrain subsystem this command is acting upon */
    private Drivetrain m_drivetrain;
    /** Provides input for throttle */
    private DoubleSupplier m_throttleSupplier;
    /** Provides input for turning */
    private DoubleSupplier m_turnSupplier;

    /**
     * Create a new {@link DefaultDrive} command
     * @param throttle supplier for throttle value
     * @param turn supplier for turn value
     * @param drivetrain drivetrain subsystem to act upon
     */
    public DefaultDrive(DoubleSupplier throttle, DoubleSupplier turn, Drivetrain drivetrain) {
        addRequirements(drivetrain);

        // store references to passed subsystem and suppliers
        m_drivetrain = drivetrain;
        m_throttleSupplier = throttle;
        m_turnSupplier = turn;
    }

    @Override
    public void execute() {
        m_drivetrain.arcadeDrive(m_throttleSupplier.getAsDouble(),
            m_turnSupplier.getAsDouble());        
    }

}
