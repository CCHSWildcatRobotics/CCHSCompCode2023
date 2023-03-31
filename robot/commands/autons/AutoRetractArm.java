package frc.robot.commands.autons;


import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.ExtendArm;
import frc.robot.commands.ExtendHook;
import frc.robot.commands.LiftArm;
import frc.robot.commands.RetractArm;
import frc.robot.commands.RetractHook;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Hook;

public class AutoRetractArm extends SequentialCommandGroup{
    public AutoRetractArm(Arm m_arm, Hook hook) {
        // Add your commands in the addCommands() call, e.g.
        // addCommands(new FooCommand(), new BarCommand());
        //public Arm m_arm = new Arm();
    
        addCommands(
            new RetractHook(hook),
            new RetractArm(m_arm)
            .withTimeout(2)
        );
                
      }
}
