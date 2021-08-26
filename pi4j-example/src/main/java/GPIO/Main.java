package GPIO;

import GPIO.Controller;
import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.util.Console;

public class Main {
    public static void main(String[] args) throws InterruptedException, PlatformAlreadyAssignedException {

        System.out.println("<--Pi4J--> GPIO ... started.");

        //       create GPIO controller
        final GpioController gpio = GpioFactory.getInstance();  // create gpio controller


        final Console console = new Console();


        console.title("<-- The Pi4J Project -->", "GPIO Listen Example"); // print program title/header


        console.promptForExit();    // allow for user to exit program using CTRL-C

        Controller controller = new Controller();

        GpioPinDigitalInput[] inPins = controller.getInPins();

        GpioPinDigitalOutput[] outPins = controller.getOutPins();

        // create GPIO listener
        GpioPinListenerDigital listener = new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                System.out.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " + event.getState()+" state rele= "+outPins[0].getState());

                controller.controlEvent(event);

//                if ((event.getPin().getName().equals("in1"))&&(event.getState().toString().equals("LOW"))){
//                    outPins[0].toggle();
//                }
            }
        };

        // create and register gpio pin listener
        gpio.addListener(listener, inPins);




        System.out.println(" ... complete the GPIO circuit and see the listener feedback here in the console.");
//        while (true) {
//            Thread.sleep(500);
//        }
        //gpio.shutdown();

    }
}
