// RobotBuilder Version: 5.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

// ROBOTBUILDER TYPE: Subsystem.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.kDrivetrain;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

// END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class Drivetrain extends SubsystemBase {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonFX frontLeft;
    private WPI_TalonFX backLeft;
    private MotorControllerGroup left;
    private WPI_TalonFX frontRight;
    private WPI_TalonFX backRight;
    private MotorControllerGroup right;
    private DifferentialDrive differentialDrive;
    private double balanceSpeed;
    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    /**
    *
    */
    public Drivetrain() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        frontLeft = new WPI_TalonFX(kDrivetrain.FRONT_LEFT);
        frontLeft.setInverted(kDrivetrain.INVERTED);

        backLeft = new WPI_TalonFX(1);
        backLeft.setInverted(kDrivetrain.INVERTED);

        frontRight = new WPI_TalonFX(4);
        frontRight.setInverted(!kDrivetrain.INVERTED);

        backRight = new WPI_TalonFX(3);
        backRight.setInverted(!kDrivetrain.INVERTED);

        frontLeft.setNeutralMode(NeutralMode.Brake);
        backLeft.setNeutralMode(NeutralMode.Brake);
        frontRight.setNeutralMode(NeutralMode.Brake);
        backRight.setNeutralMode(NeutralMode.Brake);

        left = new MotorControllerGroup(frontLeft, backLeft);
        right = new MotorControllerGroup(frontRight, backRight);

        differentialDrive = new DifferentialDrive(left, right);
        differentialDrive.setMaxOutput(kDrivetrain.MAX_SPEED);
        SmartDashboard.putData(differentialDrive);
        // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }

    @Override
    public void periodic() {
        // This method will be called once per scheduler run

    }

    @Override
    public void simulationPeriodic() {
        // This method will be called once per scheduler run when in simulation

    }

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void drive(double left, double right) {
        differentialDrive.tankDrive(left, right, true);
    }

    public void arcadeDrive(double speed, double turn) {
        differentialDrive.arcadeDrive(speed, turn);
    }
    public void driveAuto(double speed) {
        right.set(speed);
        left.set(speed);
        differentialDrive.feed();
    }

    public void leftAuto() {
        differentialDrive.tankDrive(-0.5, 0.5);
    }

    public void rightAuto() {
        differentialDrive.tankDrive(0.5, -0.5);
    }

    public void stop() {
        differentialDrive.tankDrive(0, 0);
    }

}
