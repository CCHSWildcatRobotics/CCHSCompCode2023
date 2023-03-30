// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.LiftArm;
import frc.robot.subsystems.Arm;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class MoveBackward extends SequentialCommandGroup {
  /** Creates a new MoveForward. */

  public MoveBackward(Drivetrain drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    //public Arm m_arm = new Arm();

    addCommands(
        new RunCommand(() -> drivetrain.driveAuto(-0.25), drivetrain)
            //.andThen(() -> m_arm.retract(), m_arm)
            //.andThen(() -> m_arm.retract(), m_arm)
            
            .withTimeout(2.0)
            .andThen(() -> drivetrain.stop(), drivetrain));
            
  }
}
