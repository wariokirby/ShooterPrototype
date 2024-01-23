// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Shooter extends SubsystemBase {
  private CANSparkMax flywheelHighLeft;
  private CANSparkMax flywheelHighRight;
  private CANSparkMax flywheelLowLeft;
  private CANSparkMax flywheelLowRight;
  private PIDController hlc;
  private PIDController hrc;
  private PIDController llc;
  private PIDController lrc;
  /** Creates a new Shooter. */
  public Shooter() {
    flywheelHighLeft = new CANSparkMax(10, MotorType.kBrushless);
    flywheelHighRight = new CANSparkMax(11, MotorType.kBrushless);
    flywheelLowLeft = new CANSparkMax(12, MotorType.kBrushless);
    flywheelLowRight = new CANSparkMax(13, MotorType.kBrushless);

    hlc = new PIDController(1, 0, 0);
    hrc = new PIDController(1, 0, 0);
    llc = new PIDController(1, 0, 0);
    lrc = new PIDController(1, 0, 0);
  }

  @Override
  public void periodic() {
    SmartDashboard.putNumber("HL", flywheelHighLeft.getEncoder().getVelocity());
    SmartDashboard.putNumber("HR", flywheelHighRight.getEncoder().getVelocity());
    SmartDashboard.putNumber("LL", flywheelLowLeft.getEncoder().getVelocity());
    SmartDashboard.putNumber("LR", flywheelLowRight.getEncoder().getVelocity());
    // This method will be called once per scheduler run
  }

  public void runManual(double speed){
    flywheelHighLeft.set(speed);
    //flywheelHighRight.set(-speed);
    flywheelLowLeft.set(-speed);
    //flywheelLowRight.set(speed);
  }

  public void stop(){
    flywheelHighLeft.set(0);
    flywheelHighRight.set(0);
    flywheelLowLeft.set(0);
    flywheelLowRight.set(0);
   
  }


}
