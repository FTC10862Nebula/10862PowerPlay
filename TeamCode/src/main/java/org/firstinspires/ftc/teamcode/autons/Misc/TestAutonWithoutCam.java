package org.firstinspires.ftc.teamcode.autons.Misc;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.autons.AutonCommands.RightHighJunctionCommandNew;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.TurnCommandSampleMecDrive;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideHighBCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideLowBCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideMidBCommand;
import org.firstinspires.ftc.teamcode.driveTrainAuton.MatchOpMode;
import org.firstinspires.ftc.teamcode.driveTrainAuton.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;
import org.firstinspires.ftc.teamcode.util.PoseStorage;

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
//    private Drivetrain drivetrain;
    private Slide slide;
    public SampleMecanumDrive mecanumDrive;


    @Override
    public void robotInit() {
        clawServos = new ClawServos( telemetry, hardwareMap);
        arm = new Arm(telemetry, hardwareMap);
        slide = new Slide(telemetry, hardwareMap);
        mecanumDrive = new SampleMecanumDrive(hardwareMap);
//        drivetrain = new Drivetrain(new SampleMecanumDrive(hardwareMap), telemetry, hardwareMap);
//        drivetrain.init();
//        drivetrain.setPoseEstimate(new Pose2d(startPoseX, startPoseY, Math.toRadians(startPoseHeading)));
    }

    public void matchStart() {
//        waitForStart();
        schedule(
                new SequentialCommandGroup(
                        new TurnCommandSampleMecDrive(mecanumDrive, 12)
//                        new SlideLowBCommand(slide, arm, clawServos,true),
//                        new WaitCommand(1500),
//                        new SlideMidBCommand(slide, arm, clawServos,true),
//                        new WaitCommand(1500),
//                        new SlideHighBCommand(slide, arm, clawServos,true),
//                        new WaitCommand(1500)

//                        new DropAutoConeCommand(clawServos, slide, arm,true)

//                        new RightHighJunctionCommandNew(drivetrain, slide, arm, clawServos)

//                        new RightSplineJunctionCommand(drivetrain, slide, arm, clawServos)
                )
        );
//        PoseStorage.currentPose = drivetrain.getPoseEstimate();
    }


};