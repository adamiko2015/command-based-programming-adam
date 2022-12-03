// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commandGroups;

import edu.wpi.first.wpilibj2.command.PrintCommand;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import frc.robot.commands.SetElevatorState;
import frc.robot.commands.SetIntakeArmState;
import frc.robot.commands.SetIntakeRollersState;
import frc.robot.subsystems.ElevatorSubsystem;
import frc.robot.subsystems.IntakeArm;
import frc.robot.subsystems.IntakeRollers;
import frc.robot.subsystems.ElevatorSubsystem.ElevatorState;
import frc.robot.subsystems.IntakeArm.IntakeArmState;
import frc.robot.subsystems.IntakeRollers.IntakeRollersState;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class Collect extends SequentialCommandGroup {

  public Collect(IntakeArm intakeArmSubsystem, IntakeRollers intakeRollersSubsystem, ElevatorSubsystem elevatorSubsystem) {
    addCommands(
      new SetElevatorState(elevatorSubsystem, ElevatorState.BOTTOM),
      parallel(
        new SetIntakeArmState(intakeArmSubsystem, IntakeArmState.OPEN),
        new SetIntakeRollersState(intakeRollersSubsystem, IntakeRollersState.IN)
      ),
      new PrintCommand("Command Group Finished!")
    );
  }
}
