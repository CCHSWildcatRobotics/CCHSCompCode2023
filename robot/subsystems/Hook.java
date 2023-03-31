package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Hook extends SubsystemBase{
    private final DoubleSolenoid pistons;

    public Hook(){
        pistons = new DoubleSolenoid(PneumaticsModuleType.REVPH, 5, 6);
        extend();
    }

    public void extend(){
        pistons.set(Value.kForward);
    }

    public void retract(){
        pistons.set(Value.kReverse);
    }

    public void stop(){
        pistons.set(Value.kOff);
    }
}
