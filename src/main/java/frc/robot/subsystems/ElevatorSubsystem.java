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
    if(state == ElevatorState.TOP) {
      motor.set(1);
    } else if(state == ElevatorState.BOTTOM) {
      motor.set(-1);
    }
  }

  public void zeroMotor() {
    motor.set(0);
  }

  public ElevatorState getState() {
    if(encoder.get() == 10) {
      return ElevatorState.TOP;
    } else if(encoder.get() == 0) {
      return ElevatorState.BOTTOM;
    } else {
      return ElevatorState.INTERMEDIATE;
    }
  }

  public enum ElevatorState {
    TOP, INTERMEDIATE, BOTTOM;
  }
}
