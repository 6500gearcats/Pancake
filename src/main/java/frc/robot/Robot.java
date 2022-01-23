// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.SpeedController;
//import edu.wpi.first.wpilibj.PWMSparkMax;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

//import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.smartdashboard.SendableRegistry;

import frc.robot.simulation.SparkMaxWrapper;

/**
 * This is a demo program showing the use of the DifferentialDrive class. Runs the motors with
 * arcade steering.
 */
public class Robot extends TimedRobot {
  //private final PWMSparkMax m_leftMotor = new PWMSparkMax(0);
  //private final PWMSparkMax m_rightMotor = new PWMSparkMax(1);
  //private final CANSparkMax m_leftMotor= new CANSparkMax(1, MotorType.kBrushed);
  //private final CANSparkMax m_rightMotor= new CANSparkMax(2, MotorType.kBrushed);

 // This is Rob's version 

  SpeedController m_frontLeft = new SparkMaxWrapper(1, MotorType.kBrushed);
  SpeedController m_rearLeft = new SparkMaxWrapper(2, MotorType.kBrushed);
  SpeedControllerGroup m_left = new SpeedControllerGroup(m_frontLeft, m_rearLeft);

  SpeedController m_frontRight = new SparkMaxWrapper(3, MotorType.kBrushed);
  SpeedController m_rearRight = new SparkMaxWrapper(4, MotorType.kBrushed);
  SpeedControllerGroup m_right = new SpeedControllerGroup(m_frontRight, m_rearRight);
  
  private final DifferentialDrive m_robotDrive = new DifferentialDrive(m_left, m_right);
  private final Joystick m_stick = new Joystick(0);


  /**
   * This method is run when the robot is first started up and should be
   * used for any initialization code.
   */
  @Override
  public void robotInit() {
    //These methods give names to our shuffleboard livewindow outputs
    SendableRegistry.add(m_robotDrive, "drive");
    SendableRegistry.add(m_left, "left");
    SendableRegistry.add(m_right, "right");
   }



  @Override
  public void teleopPeriodic() {
    // Drive with arcade drive.
    // That means that the Y axis drives forward
    // and backward, and the X turns left and right.
    m_robotDrive.arcadeDrive(m_stick.getY(), m_stick.getX());
  }
}
