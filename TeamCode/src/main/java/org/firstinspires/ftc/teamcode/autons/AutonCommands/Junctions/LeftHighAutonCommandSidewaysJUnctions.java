package org.firstinspires.ftc.teamcode.autons.AutonCommands.Junctions;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.StrafeRightCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.TurnCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.TurnToCommand;
import org.firstinspires.ftc.teamcode.commands.IntakeAndDropConeCommands.DropAutoConeCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.Front.PickC4FCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.Front.PickC5FCommand;
import org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PrePickFConeCommands.PrePickC5FCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideLowBCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideBackCommands.SlideMidBCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFCommands.SlideHighFCommand;
import org.firstinspires.ftc.teamcode.commands.Slide.SlideFCommands.SlideResetUpAutonCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;


public class LeftHighAutonCommandSidewaysJUnctions extends SequentialCommandGroup{
    public LeftHighAutonCommandSidewaysJUnctions(Drivetrain drivetrain, Slide slide, Arm arm, ClawServos clawServos){
        addCommands(    //Turn is Counterclockwise
//                new TurnToCommand(drivetrain, 90),
//                new TurnToCommand(drivetrain, 180),
//                new TurnToCommand(drivetrain, 270),
//                new TurnToCommand(drivetrain, 360),
//                new TurnToCommand(drivetrain, 0),

                new SlideMidBCommand(slide, arm, clawServos, true),
                new StrafeRightCommand(drivetrain, 52.7),
                new SlowDriveForwardCommand(drivetrain, -0.8),
                new DropAutoConeCommand(clawServos, slide, arm),

                new InstantCommand(clawServos::clawOpen),

                new WaitCommand(500),
                new PrePickC5FCommand(slide, clawServos, arm),
                new StrafeRightCommand(drivetrain, 16.5),
                new DriveForwardCommand(drivetrain, 26.5),


                new PickC5FCommand(slide, clawServos, arm, drivetrain),
                new SlideLowBCommand(slide, arm, clawServos, true),
                new TurnCommand(drivetrain, -55.3),
                new SlowDriveForwardCommand(drivetrain, -3),
                new DropAutoConeCommand(clawServos, slide, arm),
                new WaitCommand(200),
                new SlowDriveForwardCommand(drivetrain, 1.8),
                new PrePickC5FCommand(slide, clawServos, arm),
                new TurnToCommand(drivetrain, 3, true),
                new SlowDriveForwardCommand(drivetrain, 3),
                new InstantCommand(slide::slideCone4),



                new PickC4FCommand(slide, clawServos, arm, drivetrain),
                new DriveForwardCommand(drivetrain, -35.8),
                new SlideHighFCommand(slide, arm, clawServos, true),
                new TurnToCommand(drivetrain, 264.9),
                new SlowDriveForwardCommand(drivetrain, 2.1),
                new DropAutoConeCommand(clawServos, slide, arm),
                new WaitCommand(300),
                new SlowDriveForwardCommand(drivetrain, -2),

//                new TurnToCommand(drivetrain, 270),


//                new PickC3FCommand(slide, clawServos, arm, drivetrain),
//                new SlideLowAutonBCommand(slide, arm, clawServos),
//                new TurnToCommand(drivetrain, 322),
//                new SlowDriveForwardCommand(drivetrain, -2),
//                new DropAutoConeCommand(clawServos, slide, arm),
//                new WaitCommand(400),
//                new SlowDriveForwardCommand(drivetrain, 1.8),
//                new TurnToCommand(drivetrain, 8),
//                new PrePickC2FCommand(slide, clawServos, arm),
//                new WaitCommand(200),






//                new PickC3BCommand(slide, clawServos, arm, drivetrain),
//                new TurnToCommand(drivetrain, 140),
//                new SlideLowFCommand(slide, arm, clawServos),
//                new InstantCommand(clawServos::clawOpen, clawServos),
//                new WaitCommand(600),
//                new TurnToCommand(drivetrain, 270),
//
//                new SlideResetFCommandT(slide, arm, clawServos),
//                new WaitCommand(200),
//                new InstantCommand(arm::moveReset, arm),
//                new DriveForwardCommand(drivetrain, 50)
                new SlideResetUpAutonCommand(slide, arm, clawServos),
                new StrafeRightCommand(drivetrain, 19)
        );
    }
}