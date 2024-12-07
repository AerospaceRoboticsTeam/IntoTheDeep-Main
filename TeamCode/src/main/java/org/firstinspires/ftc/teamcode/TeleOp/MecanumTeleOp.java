package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.Libs.AR.MecanumDrive;

@TeleOp(name = "Mecanum TeleOp", group = "TeleOp")
public class MecanumTeleOp extends LinearOpMode {
    private MecanumDrive mecanumDrive;

    //@Override
    public void runOpMode() {
        DcMotor frontLeft = hardwareMap.dcMotor.get("frontLeft");
        DcMotor frontRight = hardwareMap.dcMotor.get("frontRight");
        DcMotor backLeft = hardwareMap.dcMotor.get("backLeft");
        DcMotor backRight = hardwareMap.dcMotor.get("backRight");

        frontLeft.setDirection(DcMotor.Direction.REVERSE);
        backLeft.setDirection(DcMotor.Direction.REVERSE);

        waitForStart();
        if (isStopRequested()) return;
        while (opModeIsActive()) {
            //**************************************************************************************
            // ---------------------Gamepad 1 Controls ---------------------------------------------
//            myDriveTrain.drive();

            if (gamepad1.left_trigger != 0) {
            } else if (gamepad1.right_trigger != 0) {
            } else if (gamepad1.left_trigger == 0 || gamepad1.right_trigger == 0) {
            }

            if (gamepad1.dpad_down) {
            } else if (gamepad1.dpad_left) {
            } else if (gamepad1.dpad_up) {
            }

            //**************************************************************************************
            // ---------------------Gamepad 2 Controls ---------------------------------------------
            // Hotkeys (Automation to raise slide up)
            /*
            if (gamepad2.y) {
                myGripper.moveSlideDown();
                myGripper.openGripper();
            }
            else if (gamepad2.b){
                myGripper.moveSlideLow();
            }
             */
            if (gamepad2.right_stick_y < -0.1) {
            } else if (gamepad2.right_stick_y > -0.1) {
            }

            // Hotkeys (to change gripper position)
            if (gamepad2.left_trigger != 0) {
            } else if (gamepad2.right_trigger != 0) {
            }

            mecanumDrive = new MecanumDrive(frontLeft, frontRight, backLeft, backRight);


//        double forward = -gamepad1.left_stick_y;
//        double strafe = gamepad1.left_stick_x;
//        double rotation = gamepad1.right_stick_x;


//        mecanumDrive.move(strafe, forward, rotation);

            //**************************************************************************************
            //--------------------- TELEMETRY Code --------------------------------------------
            // Useful telemetry data in case needed for testing and to find heading of robot

//        telemetry.addData("Forward", forward);
//        telemetry.addData("Strafe", strafe);
//        telemetry.addData("Rotation", rotation);
            telemetry.update();
        }
    }
}

