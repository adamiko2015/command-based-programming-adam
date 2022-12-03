// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.IntakeArm.IntakeArmState;

public class SetIntakeArmState extends CommandBase {

  private IntakeArm arm;
  private IntakeArmState wantedState;

  public SetIntakeArmState(IntakeArm arm, IntakeArmState wantedState) {
    this.arm = arm;
    this.wantedState = wantedState;

    addRequirements(arm);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Setting intake arm state from " + arm.getState().toString() + " to " + wantedState.toString());
    arm.setState(wantedState);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    arm.zeroMotor();
    System.out.println("Finished setting intake arm state");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return arm.getState() == wantedState;
  }
}
