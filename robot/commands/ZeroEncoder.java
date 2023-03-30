package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.subsystems.Arm;

public class ZeroEncoder extends SequentialCommandGroup{
    public ZeroEncoder(Arm arm){
        arm.zero();
        System.out.println("zero");
    }
}
