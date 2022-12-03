// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    public final class IntakeArm {
        public static final int VICTOR_PORT = 1;

        public static final int OPEN_SWITCH_PORT = 2;
        public static final int CLOSED_SWITCH_PORT = 3;
        
        public static final double OPEN_STATE_MOTOR_SPEED = 1;
        public static final double CLOSED_STATE_MOTOR_SPEED = -1;
    }

    public final class IntakeRollers {
        public static final int VICTOR_PORT = 2;

        public static final double OUT_STATE_MOTOR_SPEED = 1;
        public static final double IN_STATE_MOTOR_SPEED = -1;
    }

    public final class Elevator {
        public static final int VICTOR_PORT = 0;

        public static final int ENCODER_PORT_A = 0;
        public static final int ENCODER_PORT_B = 1;

        public static final int TOP_ENCODER_VALUE = 10;
        public static final int BOTTOM_ENCODER_VALUE = 0;

        public static final double TOP_STATE_MOTOR_SPEED = 1;
        public static final double BOTTOM_STATE_MOTOR_SPEED = -1;
    }
}
