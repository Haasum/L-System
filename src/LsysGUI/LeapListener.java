package LsysGUI;
import com.leapmotion.leap.Controller;
import com.leapmotion.leap.FingerList;
import com.leapmotion.leap.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.awt.AWTException;
import java.awt.Robot;




/**
 * Created by Lucas on 01-12-2016.
 */
public class LeapListener extends Listener {

    //True for Debugging
    boolean DEBUG = false;

    //0 = Key Tap
    //1 = Finger Tap
    int CLICK_TYPE = 0;


    boolean USE_CALIBRATED_SCREEN = true;

    //Just to control the speed, it can be changed accordingly to needs
    int SLOW = 10;

    //Screen resolution, it should match the current screen resolution for more precise movements
    int SCREEN_X = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().width;
    int SCREEN_Y = java.awt.GraphicsEnvironment.getLocalGraphicsEnvironment().getMaximumWindowBounds().height;


    float cur_x = 0, cur_y = 0;

    int fingers_count = 0;
    int prev_fingers_count = 0;

    boolean Lclicked = false;
    boolean Rclicked = false;
    boolean keystroke = false;
    boolean LHold = false;

    boolean Swype = false;
    boolean Circle = false;

    public void onInit(Controller controller) {
        System.out.println("Initialized");
        System.out.println("Current screen resolution: " + SCREEN_X + "x" + SCREEN_Y);
    }

    public void onConnect(Controller controller) {
        System.out.println("Connected");
    }

    public void onDisconnect(Controller controller) {
        System.out.println("Disconnected");
    }

    public void onExit(Controller controller) {
        System.out.println("Exited");
        System.exit(0);
    }

    public void onFrame(Controller controller) {
        // Get the most recent frame and report some basic information
        Frame frame = controller.frame();

        int numGestures = frame.gestures().count();

        for (int i = 0; i < numGestures; i++) {


            if (frame.gestures().get(i).type() == Gesture.Type.TYPE_SWIPE && !Swype) {

                Swype = true;
                if (DEBUG)
                    System.out.println("swype");

                slow();

            } else {
                Swype = false;
            }


        }

        if (!frame.fingers().isEmpty()) {

            // Get fingers
            FingerList fingers = frame.fingers();
            fingers_count = frame.fingers().count();

            if (DEBUG && fingers_count != prev_fingers_count) {
                System.out.println("Currently " + fingers_count + " fingers visible.\n");
                prev_fingers_count = fingers_count;
            }


            if (!fingers.isEmpty()) {
                // Calculate the hand's average finger tip position
                Vector avgPos = Vector.zero();
                for (Finger finger : fingers) {
                    avgPos = avgPos.plus(finger.tipPosition());
                }
                avgPos = avgPos.divide(fingers.count());


                if (USE_CALIBRATED_SCREEN) {
                    //New Pointing System using first calibrated screen. Thanks to wooster @ freenode IRC
                    ScreenList screens = controller.locatedScreens();

                    if (screens.isEmpty()) return;
                    Screen s = screens.get(0);
                    PointableList pointables = frame.hands().get(0).pointables();

                    if (pointables.isEmpty()) return;
                    Pointable firstPointable = pointables.get(0);
                    Vector intersection = s.intersect(
                            firstPointable,
                            true, // normalize
                            1.0f // clampRatio
                    );
                    // if the user is not pointing at the screen all components of
                    // the returned vector will be Not A Number (NaN)
                    // isValid() returns true only if all components are finite
                    if (!intersection.isValid()) return;

                    float x = s.widthPixels() * intersection.getX();
                    // flip y coordinate to standard top-left origin
                    float y = s.heightPixels() * (1.0f - intersection.getY());
                    moveMouse(x, y);

                } else {
                    moveMouse(avgPos.getX() * 15, SCREEN_Y - avgPos.getY() * 5);
                }


            }
        }
    }


            // Slows down the frame rate
        private void slow() {
            try {
                Thread.sleep(SLOW);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        public void moveMouse(float x, float y) {
            Robot mouseHandler;

            if (cur_x != x || cur_y != y) {

                cur_x = x;
                cur_y = y;

                try {

                    mouseHandler = new Robot();
                    mouseHandler.mouseMove((int) x, (int) y);

                } catch (AWTException e) {
                    e.printStackTrace();
                }
            }
        }



        public void setDebug(boolean d){
            DEBUG = d;
        }

        public void setClickType(int i){
            CLICK_TYPE = i;
        }

        public void setCalibratedScren(boolean d){
            USE_CALIBRATED_SCREEN = d;
        }
    }
