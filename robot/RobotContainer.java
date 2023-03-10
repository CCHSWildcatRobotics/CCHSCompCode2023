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

import frc.robot.commands.CloseGrabber;
import frc.robot.commands.DriveForward;
import frc.robot.commands.ExtendHook;
import frc.robot.commands.LiftArm;
import frc.robot.commands.LowerArm;
import frc.robot.commands.OpenGrabber;
import frc.robot.commands.RetractHook;
import frc.robot.commands.DriveBack;
import frc.robot.commands.TankDrive;
import frc.robot.commands.TurnLeft;
import frc.robot.commands.TurnRight;
import frc.robot.subsystems.*;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.commands.autons.ChargeStation2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS


/**
 * This class is where the bulk of the robot should be declared.  Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls).  Instead, the structure of the robot
 * (including subsystems, commands, and button mappings) should be declared here.
 */
public class RobotContainer {

  private final SendableChooser<Command> autonChooser = new SendableChooser<Command>();

  private static RobotContainer m_robotContainer = new RobotContainer();

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
// The robot's subsystems
    public final Grabber m_grabber = new Grabber();
    public final Drivetrain m_drivetrain = new Drivetrain();
    public final Arm m_arm = new Arm();
    public final Hook m_hook = new Hook();

// Joysticks
private final Joystick rightJoy = new Joystick(1);
private final Joystick leftJoy = new Joystick(0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

  
  // A chooser for autonomous commands
  SendableChooser<Command> m_chooser = new SendableChooser<>();

  /**
  * The container for the robot.  Contains subsystems, OI devices, and commands.
  */
  private RobotContainer() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Smartdashboard Subsystems


    // SmartDashboard Buttons
    
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SMARTDASHBOARD
    // Configure the button bindings
    configureButtonBindings();

    // Configure default commands
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND
    m_drivetrain.setDefaultCommand(new TankDrive(() -> getleftJoy().getY(), () -> getrightJoy().getY(), m_drivetrain));
    //autonChooser.setDefaultOption("Choose an Autonomous Command", new PrintCommand("Select a command"));
    autonChooser.setDefaultOption("ChargeStation DriverStation 2", new ChargeStation2());


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SUBSYSTEM_DEFAULT_COMMAND

    // Configure autonomous sendable chooser
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

    SmartDashboard.putData("Auto Mode", autonChooser);
  }

  public static RobotContainer getInstance() {
    return m_robotContainer;
  }

  /**
   * Use this method to define your button->command mappings.  Buttons can be created by
   * instantiating a {@link GenericHID} or one of its subclasses ({@link
   * edu.wpi.first.wpilibj.Joystick} or {@link XboxController}), and then passing it to a
   * {@link edu.wpi.first.wpilibj2.command.button.JoystickButton}.
   */
  private void configureButtonBindings() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
// Create some buttons
      new JoystickButton(leftJoy, 1).whenPressed(new OpenGrabber(m_grabber));
      new JoystickButton(rightJoy, 1).whenPressed(new CloseGrabber(m_grabber));
      new JoystickButton(leftJoy, 4).whenPressed(new RetractHook(m_hook));
      new JoystickButton(leftJoy, 3).whenPressed(new ExtendHook(m_hook));
      new POVButton(leftJoy, 180).whenPressed(new LiftArm(m_arm));
      new POVButton(leftJoy, 0).whenPressed(new LowerArm(m_arm));
      new POVButton(rightJoy, 0).whileHeld(new DriveForward(m_drivetrain));
      new POVButton(rightJoy, 180).whileHeld(new DriveBack(m_drivetrain));
      new POVButton(rightJoy, 90).whileHeld(new TurnLeft(m_drivetrain));
      new POVButton(rightJoy, 270).whileHeld(new TurnRight(m_drivetrain));
      // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=BUTTONS
  }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
public Joystick getleftJoy() {
        return leftJoy;
    }

public Joystick getrightJoy() {
        return rightJoy;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  */
  public Command getAutonomousCommand() {
    // The selected command will be run in autonomous
    return m_chooser.getSelected();
  }
  

}

