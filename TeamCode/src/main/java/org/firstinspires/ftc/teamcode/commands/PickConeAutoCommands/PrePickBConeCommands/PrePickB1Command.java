package org.firstinspires.ftc.teamcode.commands.PickConeAutoCommands.PrePickBConeCommands;

import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.subsystems.Arm;
import org.firstinspires.ftc.teamcode.subsystems.ClawServos;
import org.firstinspires.ftc.teamcode.subsystems.Slide;

public class PrePickB1Command extends SequentialCommandGroup   {
    public PrePickB1Command(Slide slide, ClawServos clawServos, Arm arm){
        addCommands(
                new ParallelCommandGroup(
                        new InstantCommand(clawServos::clawClose),
//                        new InstantCommand(clawServos::clawAutoClose),
                        new InstantCommand(arm::moveIntakeBAuto),
                        new InstantCommand(slide::slideCone1)
                ),
                new WaitCommand(150),
                new InstantCommand(clawServos::setBClawPos),
                new WaitCommand(150),
                new InstantCommand(clawServos::clawOpen)
        );
    }
}