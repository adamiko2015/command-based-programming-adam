// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.motorcontrol.VictorSP;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class IntakeRollers extends SubsystemBase {
  private VictorSP motor;
  private IntakeRollersState state = IntakeRollersState.OFF;

  public IntakeRollers() {
    motor = new VictorSP(Constants.IntakeRollers.VICTOR_PORT);
  }

  @Override
  public void periodic() {}

  public void setState(IntakeRollersState wantedState) { // I'm assuming that out is 1
    if(wantedState == IntakeRollersState.OUT) motor.set(1);
    else if(wantedState == IntakeRollersState.IN) motor.set(-1);
    else motor.set(0);

    this.state = wantedState;
  }

  public IntakeRollersState getState() {
    return state;
  }

  public enum IntakeRollersState {
    IN, OUT, OFF;
  }
}
