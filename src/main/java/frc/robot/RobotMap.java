/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.subsystems.DriveTrainMain;
import frc.robot.subsystems.Vision;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
  
  
  public static WPI_TalonSRX rightMotor1;
  public static WPI_TalonSRX rightMotor2;
  public static WPI_TalonSRX leftMotor1;
  public static WPI_TalonSRX leftMotor2;

  public static DriveTrainMain DriveTrain;
  public static Vision vision;


  public static void init(){
    rightMotor1 = new WPI_TalonSRX(0);
    rightMotor2 = new WPI_TalonSRX(1);

    leftMotor1 = new WPI_TalonSRX(3);
    leftMotor2 = new WPI_TalonSRX(6);

    DriveTrain = new DriveTrainMain();
    vision = new Vision();

    rightMotor2.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower, 0);
    leftMotor2.set(com.ctre.phoenix.motorcontrol.ControlMode.Follower, 3);

  }
 
  // For example to map the left and right motors, you could define the
  // following variables to use with your drivetrain subsystem.
  // public static int leftMotor = 1;
  // public static int rightMotor = 2;

  // If you are using multiple modules, make sure to define both the port
  // number and the module. For example you with a rangefinder:
  // public static int rangefinderPort = 1;
  // public static int rangefinderModule = 1;
}
