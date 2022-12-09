package org.firstinspires.ftc.teamcode.autons.Misc;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.hardware.ServoEx;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Treads.thing.Drivethreadcomment;
import org.firstinspires.ftc.teamcode.Treads.thing.Drivethreadcomment22;
import org.firstinspires.ftc.teamcode.commands.InstantThreadCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideMidBackCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFrontCommands.SlideMidFrontCommand;
import org.firstinspires.ftc.teamcode.commands.ThreadCommand;
import org.firstinspires.ftc.teamcode.driveTrainAuton.MatchOpMode;
import org.firstinspires.ftc.teamcode.driveTrainAuton.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

@Autonomous(group = "RED/BLUE")
public class TestAutonWithoutCam extends MatchOpMode {
//    private ATDetector tagDetector;

    private static double startPoseX = 0;
    private static double startPoseY = 0;
    private static double startPoseHeading = 0;

    // Gamepad
//    private GamepadEx driverGamepad;

    // Subsystems
    private Arm arm;
    private ClawServos clawServos;
    private Drivetrain drivetrain;
    private Slide slide;


    @Override
    public void robotInit() {
        clawServos = new ClawServos( telemetry, hardwareMap);
        arm = new Arm(telemetry, hardwareMap);
        slide = new Slide(telemetry, hardwareMap);
        drivetrain = new Drivetrain(new SampleMecanumDrive(hardwareMap), telemetry, hardwareMap);
        drivetrain.init();
        drivetrain.setPoseEstimate(new Pose2d(startPoseX, startPoseY, Math.toRadians(startPoseHeading)));

//        while (!isStarted() && !isStopRequested()){
//            waitForStart();
//        }
    }

    public void matchStart() {
//        waitForStart();
        schedule(
                new SequentialCommandGroup(
                        new InstantThreadCommand(
                                slide::slideMid

//                                ()->(slide::slideMid)
                        ),
//                        new WaitCommand(2500),
//                        new ThreadCommand(new SlideMidFrontCommand(slide, arm, clawServos)),
                        new InstantCommand(() ->
                                new Thread(() -> {
                                    slide.slideLow();
                                    arm.moveHighB();
                                    clawServos.clawClose();
                                }).start()),

                        new InstantCommand(
                            () -> new Thread(
                                    () -> new SlideMidFrontCommand(slide, arm, clawServos)
                            )
                        )
//                        new WaitCommand(2000),
//                        new InstantCommand(() ->
//                                new Thread(() -> {
//                                    slide.slideMid();
//                                    arm.moveIntakeB();
//                                    clawServos.clawClose();
//                                }).start()),
//new WaitCommand(3000),
//                        new InstantCommand(() ->
//                                new Thread(() -> {new SlideMidFrontCommand(slide,arm, clawServos );
//                                }).start())
//                )
//                        new Drivethreadcomment(drivetrain, slide, arm, clawServos),
//                        new WaitCommand(1000),
//                        new Drivethreadcomment22(drivetrain, slide, arm, clawServos)

                ) );
    }
};