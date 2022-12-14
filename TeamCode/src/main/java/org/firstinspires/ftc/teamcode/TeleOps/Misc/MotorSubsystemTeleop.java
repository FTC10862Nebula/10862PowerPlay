package org.firstinspires.ftc.teamcode.TeleOps.Misc;

import com.acmerobotics.dashboard.config.Config;
import com.arcrobotics.ftclib.command.button.Button;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.GamepadTrigger;
import org.firstinspires.ftc.teamcode.driveTrainAuton.MatchOpMode;
import org.firstinspires.ftc.teamcode.subsystems.MotorSubsystem;

//@Disabled
@Config
@TeleOp(name = "MotorsubsystemTeleop")
public class MotorSubsystemTeleop extends MatchOpMode {
    private static double startPoseX = 0;
    private static double startPoseY = 0;
    private static double startPoseHeading = 0;

    //Motors and Servos
    private MotorEx testMotor;
    // Gamepad
    private GamepadEx driverGamepad, operatorGamepad;
    // Subsystems
    private MotorSubsystem motorSubsystem;

    @Override
    public void robotInit() {
        driverGamepad = new GamepadEx(gamepad1);
        operatorGamepad = new GamepadEx(gamepad2);

        motorSubsystem = new MotorSubsystem(telemetry, hardwareMap);
    }

    //Buttons
    public Button one, two;

    @Override
    public void configureButtons() {
        one = (new GamepadTrigger(operatorGamepad, GamepadKeys.Trigger.RIGHT_TRIGGER)
                .whenPressed(motorSubsystem::setUpSpeed)
                .whenReleased(motorSubsystem::stop)
        );
        two = (new GamepadTrigger(operatorGamepad, GamepadKeys.Trigger.LEFT_TRIGGER)
                .whenPressed(motorSubsystem::setDownSpeed)
                .whenReleased(motorSubsystem::stop)
        );

    }

    @Override
    public void matchLoop() { }
    @Override
    public void disabledPeriodic() { }
    @Override
    public void matchStart() { }
    @Override
    public void robotPeriodic(){ }
}
