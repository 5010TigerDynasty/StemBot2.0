/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class Vision extends Subsystem {
  // Put methods for controlling this subsystem
  // here. Call these from Commands.

  public NetworkTable table;
  public double tx;
  public double ty;
  public double ta;
  public boolean tv;

  public double steerKp = 0.02;
  public double steerMin = 0.1;
  public double moveKp = 0.2;
  public double moveMin = 0.1;

  @Override
  public void initDefaultCommand() {
    // Set the default command for a subsystem here.
    // setDefaultCommand(new MySpecialCommand());
  }

  public void updateValues() {
    table = NetworkTableInstance.getDefault().getTable("limelight");
    tx = table.getEntry("tx").getDouble(0.0);
    ty = table.getEntry("ty").getDouble(0);
    ta = table.getEntry("ta").getDouble(0);
    tv = table.getEntry("tv").getDouble(0) == 1 ? true : false;
  }

  public double turnTowardsTarget() {
    updateValues();
    double steerAmt = steerKp * tx;
    System.out.println(steerAmt);
    steerAmt = Math.max(steerMin, Math.abs(steerAmt)) * Math.signum(steerAmt);
    return steerAmt;
  }

  public double moveTowardsTarget() {
    updateValues();
    double moveAmt = moveKp * (2- ta);
    moveAmt = Math.max(moveMin, Math.abs(moveAmt)) * Math.signum(moveAmt);
    return moveAmt;
  }
}
