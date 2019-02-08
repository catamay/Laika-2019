/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.huskyrobotics.frc2019.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.huskyrobotics.frc2019.Robot;
import org.huskyrobotics.frc2019.subsystems.drive.Drivetrain;
import org.huskyrobotics.frc2019.subsystems.drive.VisionController;

/**
 * An example command.  You can replace me with your own command.
 */
public class HeyLookListen extends Command {
  Drivetrain m_Drive = new Drivetrain();
  VisionController m_Limelight = new VisionController(m_Drive);

  public HeyLookListen() {
    requires(m_Drive);
    // Use requires() here to declare subsystem dependencies
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    m_Limelight.updateInputs();

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    m_Limelight.center(0.1, 0.1, 0.1, 1);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    m_Drive.setSpeed(0, 0);
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
