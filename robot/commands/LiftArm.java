package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Arm;

public class LiftArm extends SequentialCommandGroup{
    public LiftArm(Arm arm){
        addCommands(
            new InstantCommand(arm::extend),
            new WaitCommand(0.5),
            new InstantCommand(arm::cancel)
        );
    }
}
