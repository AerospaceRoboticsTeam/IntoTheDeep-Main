package org.firstinspires.ftc.teamcode.Libs.AR;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;


import org.firstinspires.ftc.teamcode.TeleOp.CompOneTeleOp;
import org.firstinspires.ftc.teamcode.TeleOp.CompTwoTeleOp;


//For the 2nd robot
public class Arm {
    private DcMotor MTR_VS;
    private Servo SRV_LG, SRV_RG;
    private static final double MTR_VS_PW = 0.7;  //TODO: Check power values when testing
    private double dGripperOpen = -0.9;
    private double dGripperGuard = 0.1;
    private double dGripperClosed = -0.9;

    private double dWristUp = 0.7;
    private double dWristGrab = 0.2;
    private double dWristDown = 0.1;
    private int gripperCurrPosition;
    private int open = 1;
    private int closed = -1;
    private int guard = 0;
    CompTwoTeleOp bot;


    public Arm(CompTwoTeleOp iBot) {
        bot = iBot;


        MTR_VS = bot.hardwareMap.get(DcMotor.class, "viper_mtr");
        MTR_VS.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);  // Set Motor to 0 ticks.
        MTR_VS.setDirection(DcMotor.Direction.REVERSE);
        SRV_LG = bot.hardwareMap.get(Servo.class, "claw");
        SRV_RG = bot.hardwareMap.get(Servo.class, "wrist");

        guardGripper();
    }
    public void openGripper() {
        SRV_LG.setPosition(dGripperOpen);
        SRV_RG.setPosition(dWristUp);
        gripperCurrPosition = open;
    }


    public void guardGripper() {
        SRV_LG.setPosition(dGripperGuard);
        SRV_RG.setPosition(dWristGrab);
        gripperCurrPosition = guard;
        //TODO: Must test these values and see if they are the right angle
    }


    public void closeGripper() {
        SRV_LG.setPosition(dGripperClosed);
        SRV_RG.setPosition(dWristDown);
        gripperCurrPosition = closed;
    }


    public void moveSlideDown() {
        SRV_LG.setPosition(dWristDown);
        MTR_VS.setTargetPosition(20);
        MTR_VS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        powerArm();
    }
    public void moveSlideLow() {
        MTR_VS.setTargetPosition(500);
        MTR_VS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        powerArm();
    }


    public void moveSlideMiddle() {
        MTR_VS.setTargetPosition(1500);
        MTR_VS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        powerArm();
    }




    public void moveSlideHigh() {
        MTR_VS.setTargetPosition(2700);
        MTR_VS.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        powerArm();
    }


    public void powerArm() {
        MTR_VS.setPower(MTR_VS_PW);
    }

    public void manualMove(double power) {
        MTR_VS.setPower(power);
    }


    public void getTelemetryData() {
        bot.telemetry.addData("Wrist Position: ", SRV_RG.getPosition());
        bot.telemetry.addData("Claw Position: ", SRV_LG.getPosition());
        bot.telemetry.addData("MTR_LVS Position: ", MTR_VS.getCurrentPosition());
    }




}

