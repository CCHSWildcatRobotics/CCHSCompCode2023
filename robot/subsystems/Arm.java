package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Arm extends SubsystemBase {
    private final DoubleSolenoid pistons;
    private final CANSparkMax left, right;

    public Arm() {
        pistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, 0, 1);
        left = new CANSparkMax(11, MotorType.kBrushless);
        right = new CANSparkMax(12, MotorType.kBrushless);
        right.setInverted(true);
        left.setInverted(false);
        retract();

        left.getEncoder().setPosition(getLeftArmPosition());
        right.getEncoder().setPosition(getRightArmPosition());

    }
    public void zero(){
        //right.getEncoder().setPosition(0);
        //left.getEncoder().setPosition(0);
    }
    public double getLeftArmPosition() {
        return left.getEncoder().getPosition();
    }
    public double getRightArmPosition(){
        return right.getEncoder().getPosition();
    }
    public void extend() {
        pistons.set(Value.kForward);
    }

    public void retract() {
        pistons.set(Value.kReverse);
    }

    public void cancel() {
        pistons.set(Value.kOff);
    }

    public void run() {
        left.set(0.4);
        right.set(0.4);
    }

    public void reverse() {
        left.set(-0.4);
        right.set(-0.4);
    }

    public void stop() {
        left.set(0);
        right.set(0);
    }

    @Override
    public void periodic() {
        SmartDashboard.putNumber("Left Arm extension", getLeftArmPosition());
        SmartDashboard.putNumber("Right Arm extension", getRightArmPosition());
        boolean isExtended = getRightArmPosition() > Constants.kArm.MAX_EXTENSION-2;
        boolean isRetracted = getRightArmPosition() < Constants.kArm.MIN_EXTENSION;
        SmartDashboard.putBoolean("is extended", isExtended);
        SmartDashboard.putBoolean("is retracted", isRetracted);
    }
}
