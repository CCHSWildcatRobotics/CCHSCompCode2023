package frc.robot.commands.autons;


import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.LiftArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hook;

public class MoveForward extends SequentialCommandGroup{
    public MoveForward(Drivetrain drivetrain, Hook hook) {
        // Add your commands in the addCommands() call, e.g.
        // addCommands(new FooCommand(), new BarCommand());
        //public Arm m_arm = new Arm();
    
        addCommands(
            
            new RunCommand(() -> drivetrain.driveAuto(0.15), drivetrain)
                //.andThen(() -> m_arm.retract(), m_arm)
                //.andThen(() -> m_arm.retract(), m_arm)
                
                .withTimeout(1.40)
                .andThen(() -> drivetrain.stop(), drivetrain));
                
      }
}
