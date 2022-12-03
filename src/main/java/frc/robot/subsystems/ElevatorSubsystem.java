// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class ElevatorSubsystem extends SubsystemBase {
  
  private VictorSP motor;
  private Encoder encoder;

  public ElevatorSubsystem() {
    motor = new VictorSP(Constants.Elevator.VICTOR_PORT);
    encoder = new Encoder(Constants.Elevator.ENCODER_PORT_A, Constants.Elevator.ENCODER_PORT_B);
  }

  @Override
  public void periodic() {}

  @Override
  public void simulationPeriodic() {}

  public void setState(ElevatorState state) {
    switch(state) {
      case TOP:
        motor.set(Constants.Elevator.TOP_STATE_MOTOR_SPEED);
        break;
      case BOTTOM:
        motor.set(Constants.Elevator.BOTTOM_STATE_MOTOR_SPEED);
        break;
      default:
        break;
    }
  }

  public void zeroMotor() {
    motor.set(0);
  }

  public ElevatorState getState() {
    if(encoder.get() == Constants.Elevator.TOP_ENCODER_VALUE) {
      return ElevatorState.TOP;
    } else if(encoder.get() == Constants.Elevator.BOTTOM_ENCODER_VALUE) {
      return ElevatorState.BOTTOM;
    } else {
      return ElevatorState.INTERMEDIATE;
    }
  }

  public enum ElevatorState {
    TOP, INTERMEDIATE, BOTTOM;
  }
}
