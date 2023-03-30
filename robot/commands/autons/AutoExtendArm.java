package frc.robot.commands.autons;


import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ExtendArm;
import frc.robot.commands.LiftArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

public class AutoExtendArm extends SequentialCommandGroup{
    public AutoExtendArm(Arm m_Arm) {
        // Add your commands in the addCommands() call, e.g.
        // addCommands(new FooCommand(), new BarCommand());
        //public Arm m_arm = new Arm();
    
        addCommands(
            new RunCommand(() -> new ExtendArm(m_Arm))
                //.andThen(() -> m_arm.retract(), m_arm)
                //.andThen(() -> m_arm.retract(), m_arm)
                
                .withTimeout(1.40)
        );
      }
}
