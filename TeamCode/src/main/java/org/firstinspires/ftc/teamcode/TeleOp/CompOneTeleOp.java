package org.firstinspires.ftc.teamcode.TeleOp;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.Libs.AR.MecanumDrive;

@TeleOp(name = "CompOne TeleOp", group = "TeleOp")
public class CompOneTeleOp extends LinearOpMode
{
    private MecanumDrive mecanumDrive;

    //@Override
    public void runOpMode()
    {
        // Initialize the drivetrain
        mecanumDrive = new MecanumDrive(this);

        waitForStart();
        if (isStopRequested()) return;

        while (opModeIsActive())
        {
            // This call is made every loop and will read the current control pad values (for driving)
            // and update the drivetrain with those values.
            mecanumDrive.drive();

            //**************************************************************************************
            // ---------------------Gamepad 1 Controls ---------------------------------------------

            if (gamepad1.left_trigger != 0) {
                mecanumDrive.setBoost(1);
            }
            else {
                mecanumDrive.setBoost(0.5);
            }

            //**************************************************************************************
            // ---------------------Gamepad 2 Controls ---------------------------------------------
            if (gamepad2.y) {

            } else if (gamepad2.b){
            }

            if (gamepad2.right_stick_y < -0.1) {
            } else if (gamepad2.right_stick_y > -0.1) {
            }

            // Hotkeys (to change gripper position)
            if (gamepad2.left_trigger != 0) {
            } else if (gamepad2.right_trigger != 0) {
            }

            // Todo: Remove when not needed anymore.
            //double forward = -gamepad1.left_stick_y;
            //double strafe = gamepad1.left_stick_x;
            //double rotation = gamepad1.right_stick_x;
            //mecanumDrive.move(strafe, forward, rotation);

            //**************************************************************************************
            //--------------------- TELEMETRY Code -------------------------------------------------

            // Useful telemetry data in case needed for testing and to find heading of robot
            mecanumDrive.getTelemetryData();

            telemetry.update();
        }
    }
}

