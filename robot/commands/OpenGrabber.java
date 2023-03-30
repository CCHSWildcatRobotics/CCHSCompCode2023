package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;
import frc.robot.subsystems.Grabber;

public class OpenGrabber extends SequentialCommandGroup {
    public OpenGrabber(Grabber grabber) {
        addCommands(
                new InstantCommand(grabber::extend),
                new WaitCommand(0.5),
                new InstantCommand(grabber::stop));
    }
}
