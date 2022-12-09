package org.firstinspires.ftc.teamcode.commands.DriveCommands.AutoCommands;

import com.arcrobotics.ftclib.command.CommandBase;

import org.firstinspires.ftc.teamcode.subsystems.Drivetrain;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

public class TrajectorySequenceFollowCommand extends CommandBase {
    private final Drivetrain drive;
    private final TrajectorySequence trajectorySequence;
    public TrajectorySequenceFollowCommand(Drivetrain drive, TrajectorySequence trajectorySequence) {
        this.drive = drive;
        this.trajectorySequence = trajectorySequence;
    }

    @Override
    public void initialize() {
        //TODO: FIx this
//        drive.followTrajectorySequenceAsync(trajectorySequence);
    }

    @Override
    public void execute() {
        drive.update();
    }

    @Override
    public void end(boolean interrupted) {
        if (interrupted) {
            drive.stop();
        }
    }

    @Override
    public boolean isFinished() {
        return !drive.isBusy();
    }
}