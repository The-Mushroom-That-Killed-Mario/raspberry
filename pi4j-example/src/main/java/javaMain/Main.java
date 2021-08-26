package javaMain;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
import com.pi4j.util.ConsoleColor;

import java.util.ArrayList;
import java.util.List;


public class Main {

    /**
     * [ARGUMENT/OPTION "--pin (#)" | "-p (#)" ]
     * This example program accepts an optional argument for specifying the GPIO pin (by number)
     * to use with this GPIO listener example. If no argument is provided, then GPIO #1 will be used.
     * -- EXAMPLE: "--pin 4" or "-p 0".
     *
     * [ARGUMENT/OPTION "--pull (up|down|off)" | "-l (up|down|off)" | "--up" | "--down" ]
     * This example program accepts an optional argument for specifying pin pull resistance.
     * Supported values: "up|down" (or simply "1|0").   If no value is specified in the command
     * argument, then the pin pull resistance will be set to PULL_UP by default.
     * -- EXAMPLES: "--pull up", "-pull down", "--pull off", "--up", "--down", "-pull 0", "--pull 1", "-l up", "-l down".
     *
     * @param args
     * @throws InterruptedException
     * @throws PlatformAlreadyAssignedException
     */
    public static void main(String args[]) throws InterruptedException, PlatformAlreadyAssignedException {

        final Console console = new Console();


        console.title("<-- The Pi4J Project -->", "GPIO Listen Example"); // print program title/header


        console.promptForExit();    // allow for user to exit program using CTRL-C


        final GpioController gpio = GpioFactory.getInstance(); // create gpio controller


        Pin in1 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_01,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in2 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_04,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in3 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_05,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in4 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_06,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in5 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_26,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in6 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_27,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in7 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_28,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin in8 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_29,  // default pin if no pin argument found
                args);             // argument array to search in


        // by default we will use gpio pin PULL-UP; however, if an argument
        // has been provided, then use the specified pull resistance

//        PinPullResistance pull = CommandArgumentParser.getPinPullResistance(
//                PinPullResistance.PULL_UP,  // default pin pull resistance if no pull argument found
//                args);                      // argument array to search in

        // provision gpio pin #02 as an input pin with its internal pull resistor set to UP or DOWN
        final GpioPinDigitalInput myButton1 = gpio.provisionDigitalInputPin(in1);
        final GpioPinDigitalInput myButton2 = gpio.provisionDigitalInputPin(in2);
        final GpioPinDigitalInput myButton3 = gpio.provisionDigitalInputPin(in3);
        final GpioPinDigitalInput myButton4 = gpio.provisionDigitalInputPin(in4);
        final GpioPinDigitalInput myButton5 = gpio.provisionDigitalInputPin(in5);
        final GpioPinDigitalInput myButton6 = gpio.provisionDigitalInputPin(in6);
        final GpioPinDigitalInput myButton7 = gpio.provisionDigitalInputPin(in7);
        final GpioPinDigitalInput myButton8 = gpio.provisionDigitalInputPin(in8);
        // unexport the GPIO pin when program exits


        myButton1.setShutdownOptions(true);
        myButton2.setShutdownOptions(true);
        myButton3.setShutdownOptions(true);
        myButton4.setShutdownOptions(true);
        myButton5.setShutdownOptions(true);
        myButton6.setShutdownOptions(true);
        myButton7.setShutdownOptions(true);
        myButton8.setShutdownOptions(true);

        List<GpioPinDigitalInput> provisionedPins = new ArrayList<>();
        provisionedPins.add(myButton1);
        provisionedPins.add(myButton2);
        provisionedPins.add(myButton3);
        provisionedPins.add(myButton4);
        provisionedPins.add(myButton5);
        provisionedPins.add(myButton6);
        provisionedPins.add(myButton7);
        provisionedPins.add(myButton8);


        Pin[] pins;



        // prompt user that we are ready
        console.println(" ... Successfully provisioned [" + in1 + "] with PULL resistance = [ + pull + ]");
        console.emptyLine();
        console.box("Please complete the [" + in1 + "] circuit and see",
                "the listener feedback here in the console.");
        console.emptyLine();

        // create and register gpio pin listener
        for (GpioPinDigitalInput myButton:
             provisionedPins) {

        }

        myButton1.addListener(new GpioPinListenerDigital() {
            @Override
            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
                // display pin state on console
                console.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " +
                        ConsoleColor.conditional(
                                event.getState().isHigh(), // conditional expression
                                ConsoleColor.GREEN,        // positive conditional color
                                ConsoleColor.RED,          // negative conditional color
                                event.getState()));        // text to display
            }

        });


        // wait (block) for user to exit program using CTRL-C
        console.waitForExit();

        // forcefully shutdown all GPIO monitoring threads and scheduled tasks
        gpio.shutdown();
    }
}
