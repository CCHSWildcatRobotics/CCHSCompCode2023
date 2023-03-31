package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DropArm;
import frc.robot.commands.ExtendHook;
import frc.robot.commands.LiftArm;
import frc.robot.commands.OpenGrabber;
import frc.robot.commands.RetractHook;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Grabber;
import frc.robot.subsystems.Hook;
public class AutoMidMove  extends SequentialCommandGroup{
    public AutoMidMove(Drivetrain drivetrain, Arm arm, Grabber grabber, Hook hook){
        addCommands(
            new RetractHook(hook),
            new DropArm(arm),
            new WaitCommand(1),
            new LiftArm(arm),
            new WaitCommand(1.5),
            new MoveForward(drivetrain, hook),
            new AutoExtendArm(arm, hook),
            new OpenGrabber(grabber),
            new WaitCommand(0.2),
            new AutoRetractArm(arm, hook),
            new MoveBackward(drivetrain, hook)
            

        );
    }
}
