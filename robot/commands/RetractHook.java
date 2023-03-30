package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Hook;

public class RetractHook extends SequentialCommandGroup {
    public RetractHook(Hook hook) {
        addCommands(
                new InstantCommand(hook::extend),
                new WaitCommand(0.5),
                new InstantCommand(hook::stop));
    }
}
