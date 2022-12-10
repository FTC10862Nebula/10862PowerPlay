package org.firstinspires.ftc.teamcode.commands.IntakeAndDropConeCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.DriveForwardCommand;
import org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands.SlowDriveForwardCommand;
import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class DropConeCommand extends SequentialCommandGroup  {

    public DropConeCommand(ClawServos clawServos, Slide slide, Arm arm, Drivetrain drivetrain){
        addRequirements(arm);
        addCommands(
                new InstantCommand(() ->
                        new Thread(() -> {
                            arm.dropArmTeleop();
                            slide.dropSlide();
                            clawServos.clawOpen();
                        }).start()),
                new WaitCommand(300),
                new InstantCommand(arm::moveReset)
        );
    }

}
