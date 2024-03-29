package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;
import frc.robot.subsystems.Arm;

public class LiftArm extends ParallelCommandGroup{
    public LiftArm(Arm arm){
        addCommands(
            new InstantCommand(arm::retract)
        );
    }
}
