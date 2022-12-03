// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.subsystems.IntakeRollers;
import frc.robot.subsystems.IntakeRollers.IntakeRollersState;

public class SetIntakeRollersState extends CommandBase {

  private IntakeRollers rollers;
  private IntakeRollersState wantedState;

  public SetIntakeRollersState(IntakeRollers rollers, IntakeRollersState wantedState) {
    this.rollers = rollers;
    this.wantedState = wantedState;
    addRequirements(rollers);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    System.out.println("Setting rollers state from " + rollers.getState().toString() + " to " + wantedState.toString());
    rollers.setState(wantedState);
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {}

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    System.out.println("Finished setting rollers state");
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return rollers.getState() == wantedState;
  }
}
