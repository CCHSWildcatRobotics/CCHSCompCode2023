// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands.autons;

import edu.wpi.first.wpilibj2.command.RunCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.GetBalance;
import frc.robot.subsystems.Drivetrain;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class AutoBalance extends SequentialCommandGroup {
  /** Creates a new MoveForward. */
  public double balanceSpeed;

  public AutoBalance(Drivetrain drivetrain) {
    // Add your commands in the addCommands() call, e.g.
    
    //balanceSpeed = GetBalance.getSpeed();
    System.out.println("Auto"+ balanceSpeed);
    addCommands(new RunCommand(() -> drivetrain.driveAuto(GetBalance.getSpeed()*0.7), drivetrain));
  }
}
