// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeArm extends SubsystemBase {

  private VictorSP motor;
  private DigitalInput msOpen, msClosed;

  public IntakeArm() {
    motor = new VictorSP(Constants.IntakeArm.VICTOR_PORT);
    msOpen = new DigitalInput(Constants.IntakeArm.OPEN_SWITCH_PORT);
    msClosed = new DigitalInput(Constants.IntakeArm.CLOSED_SWITCH_PORT);
  }

  @Override
  public void periodic() {}

  public void setState(IntakeArmState wantedState) {
    switch(wantedState) {
      case OPEN:
        motor.set(Constants.IntakeArm.OPEN_STATE_MOTOR_SPEED);
      case CLOSED:
        motor.set(Constants.IntakeArm.CLOSED_STATE_MOTOR_SPEED);
      default:
        break;
    }
  }

  public void zeroMotor() {
    motor.set(0);
  }

  public IntakeArmState getState() {
    if(msOpen.get() && !msClosed.get()) {
      return IntakeArmState.OPEN;
    } else if(msClosed.get() && !msOpen.get()) {
      return IntakeArmState.CLOSED;
    } else {
      return IntakeArmState.INTERMEDIATE;
    }
  }

  public enum IntakeArmState {
    OPEN, CLOSED, INTERMEDIATE;
  }
}
