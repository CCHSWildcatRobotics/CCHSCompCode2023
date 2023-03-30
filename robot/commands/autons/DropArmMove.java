package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.commands.DropArm;
import frc.robot.commands.LiftArm;
import frc.robot.commands.OpenGrabber;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;
import frc.robot.subsystems.Grabber;
public class DropArmMove  extends SequentialCommandGroup{
    public DropArmMove(Drivetrain drivetrain, Arm arm, Grabber grabber){
        addCommands(
            new DropArm(arm),
            new WaitCommand(1.5),
            new LiftArm(arm),
            new WaitCommand(3.5),
            new MoveForward(drivetrain),
            new WaitCommand(2),
            new OpenGrabber(grabber),
            new WaitCommand(1),
            new MoveBackward(drivetrain)
            

        );
    }
}
