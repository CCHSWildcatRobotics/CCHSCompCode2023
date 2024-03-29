// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: RobotContainer.

package frc.robot;

import frc.robot.commands.*;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.autons.MoveBackward;
import frc.robot.commands.autons.MoveForward;
import frc.robot.commands.autons.AutoBalance;
import frc.robot.commands.autons.AutoExtendArm;
import frc.robot.commands.autons.AutoMidMove;
import frc.robot.commands.autons.AutoBottomMove;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 * This class is where the bulk of the robot should be declared. Since
 * Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in
 * the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of
 * the robot
 * (including subsystems, commands, and button mappings) should be declared
 * here.
 */
public class RobotContainer {

  private final SendableChooser<Command> autonChooser = new SendableChooser<Command>();

  // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
  // The robot's subsystems
  private final Grabber m_grabber = new Grabber();
  private final Drivetrain m_drivetrain = new Drivetrain();
  private final Arm m_arm = new Arm();
  private final Hook m_hook = new Hook();

  // Joysticks
  private final Joystick rightJoy = new Joystick(1);
  private final Joystick leftJoy = new Joystick(0);

  // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  // A chooser for autonomous commands

  /**
   * The container for the robot. Contains subsystems, OI devices, and commands.
   */
  public RobotContainer() {
    m_drivetrain.setDefaultCommand(new TankDrive(() -> leftJoy.getY(), () -> rightJoy.getY(), m_drivetrain));

    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    autonChooser.setDefaultOption("Choose an Autonomous Command", new PrintCommand("Select a command"));
    autonChooser.addOption("Move Back", new MoveBackward(m_drivetrain, m_hook));
    autonChooser.addOption("AutoBalance", new AutoBalance(m_drivetrain, m_hook));
    autonChooser.addOption("Drop Arm Move Back", new AutoBottomMove(m_drivetrain, m_arm, m_grabber, m_hook));
    autonChooser.addOption("Move Forward", new MoveForward(m_drivetrain, m_hook));
    autonChooser.addOption("AutoExtendArm", new AutoExtendArm(m_arm, m_hook));
    autonChooser.addOption("Tier 2 Auto", new AutoMidMove(m_drivetrain, m_arm, m_grabber, m_hook));
    SmartDashboard.putData("Auto Mode", autonChooser);
  }

  /**
   * Use this method to define your button->command mappings. Buttons can be
   * created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing
   * it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
    // Create some buttons
    new JoystickButton(leftJoy, 1).onTrue(new OpenGrabber(m_grabber));
    new JoystickButton(rightJoy, 1).onTrue(new CloseGrabber(m_grabber));
    new JoystickButton(leftJoy, 4).onTrue(new RetractHook(m_hook));
    new JoystickButton(leftJoy, 3).onTrue(new ExtendHook(m_hook));
    new POVButton(leftJoy, 180).onTrue(new DropArm(m_arm));
    new POVButton(leftJoy, 0).onTrue(new LiftArm(m_arm));
    new POVButton(rightJoy, 0).whileTrue(new DriveForward(m_drivetrain));
    new POVButton(rightJoy, 180).whileTrue(new DriveBack(m_drivetrain));
    new POVButton(rightJoy, 90).whileTrue(new TurnLeft(m_drivetrain));
    new POVButton(rightJoy, 270).whileTrue(new TurnRight(m_drivetrain));
    new JoystickButton(rightJoy, 3).whileTrue(new RetractArm(m_arm));
    new JoystickButton(rightJoy, 4).whileTrue(new ExtendArm(m_arm));
    //new JoystickButton(rightJoy, 2).whileTrue(new ZeroEncoder(m_arm));


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
   */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return autonChooser.getSelected();
  }

}
