/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class Drive extends Command {
  public Double moveAmt;
  public Double steerAmt;
  public Drive() {
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
    requires(RobotMap.DriveTrain);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    RobotMap.vision.updateValues();
    if (Robot.oi.driver.getRawButton(9) && RobotMap.vision.tx != 0) {
      moveAmt = RobotMap.vision.turnTowardsTarget();
      //steerAmt = RobotMap.vision.moveTowardsTarget();
      RobotMap.DriveTrain.drive(moveAmt + steerAmt, moveAmt - steerAmt);
    } else {
      moveAmt = Robot.oi.driver.getRawAxis(0);
      steerAmt = Robot.oi.driver.getRawAxis(1);
      //System.out.println("drive");
      RobotMap.DriveTrain.drive(moveAmt + steerAmt, moveAmt - steerAmt);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
