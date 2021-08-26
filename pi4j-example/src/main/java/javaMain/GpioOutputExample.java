package javaMain;

/*
 * #%L
 * **********************************************************************
 * ORGANIZATION  :  Pi4J
 * PROJECT       :  Pi4J :: Java Examples
 * FILENAME      :  GpioOutputExample.java
 *
 * This file is part of the Pi4J project. More information about
 * this project can be found here:  https://pi4j.com/
 * **********************************************************************
 * %%
 * Copyright (C) 2012 - 2021 Pi4J
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.platform.PlatformAlreadyAssignedException;
import com.pi4j.util.CommandArgumentParser;
import com.pi4j.util.Console;
import com.pi4j.util.ConsoleColor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Future;

/**
 * This example code demonstrates how to perform simple state
 * control of a GPIO pin on the RaspberryPi.
 *
 * @author Robert Savage
 */
public class GpioOutputExample {

    /**
     * [ARGUMENT/OPTION "--pin (#)" | "-p (#)" ]
     * This example program accepts an optional argument for specifying the GPIO pin (by number)
     * to use with this GPIO listener example. If no argument is provided, then GPIO #1 will be used.
     * -- EXAMPLE: "--pin 4" or "-p 0".
     *
     * @param args
     * @throws InterruptedException
     * @throws PlatformAlreadyAssignedException
     */
    public static void main(String[] args) throws InterruptedException, PlatformAlreadyAssignedException {

        // create Pi4J console wrapper/helper
        // (This is a utility class to abstract some of the boilerplate code)
        final Console console = new Console();

        // print program title/header
        console.title("<-- The Pi4J Project -->", "GPIO Output Example");

        // allow for user to exit program using CTRL-C
        console.promptForExit();

        // create gpio controller
        final GpioController gpio = GpioFactory.getInstance();

        // by default we will use gpio pin #01; however, if an argument
        // has been provided, then lookup the pin by address
        Pin pin1 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_07,  // default pin if no pin argument found
                args);             // argument array to search in

        Pin pin2 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_00,  // default pin if no pin argument found
                args);

        Pin pin3 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_02,  // default pin if no pin argument found
                args);

        Pin pin4 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_03,  // default pin if no pin argument found
                args);

        Pin pin5 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_21,  // default pin if no pin argument found
                args);
        Pin pin6 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_22,  // default pin if no pin argument found
                args);
        Pin pin7 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_23,  // default pin if no pin argument found
                args);
        Pin pin8 = CommandArgumentParser.getPin(
                RaspiPin.class,    // pin provider class to obtain pin instance from
                RaspiPin.GPIO_24,  // default pin if no pin argument found
                args);

        // provision gpio pin as an output pin and turn on
        final GpioPinDigitalOutput output1 = gpio.provisionDigitalOutputPin(pin1, "My Output 1", PinState.HIGH);
        final GpioPinDigitalOutput output2 = gpio.provisionDigitalOutputPin(pin2, "My Output 2", PinState.HIGH);
        final GpioPinDigitalOutput output3 = gpio.provisionDigitalOutputPin(pin3, "My Output 3", PinState.HIGH);
        final GpioPinDigitalOutput output4 = gpio.provisionDigitalOutputPin(pin4, "My Output 4", PinState.HIGH);
        final GpioPinDigitalOutput output5 = gpio.provisionDigitalOutputPin(pin5, "My Output 5", PinState.HIGH);
        final GpioPinDigitalOutput output6 = gpio.provisionDigitalOutputPin(pin6, "My Output 6", PinState.HIGH);
        final GpioPinDigitalOutput output7 = gpio.provisionDigitalOutputPin(pin7, "My Output 7", PinState.HIGH);
        final GpioPinDigitalOutput output8 = gpio.provisionDigitalOutputPin(pin8, "My Output 8", PinState.HIGH);


        ArrayList<GpioPinDigitalOutput> Outputs = new ArrayList<>();
        Outputs.add(output1);
        Outputs.add(output2);
        Outputs.add(output3);
        Outputs.add(output4);
        Outputs.add(output5);
        Outputs.add(output6);
        Outputs.add(output7);
        Outputs.add(output8);


        for (GpioPinDigitalOutput out :
                Outputs) {
            out.setShutdownOptions(false, PinState.HIGH);
        }
        // set shutdown state for this pin: keep as output pin, set to low state
        //output1.setShutdownOptions(false, PinState.HIGH);

        for (int i = 0; i > -10; i++) {
            for (GpioPinDigitalOutput out :
                    Outputs) {
//
                Thread.sleep(500);
                out.toggle();
//                if (out.getName().equals("My Output 1")) {

//                    output3.toggle();                                     //переключение
//                    output1.pulse(3000,PinState.LOW);                     //установка низкого уровня на пине с длительностью

//                } else {
//                    out.toggle();
                }
            }
//        }


        // create a pin listener to print out changes to the output gpio pin state
//        output1.addListener(new GpioPinListenerDigital() {
//            @Override
//            public void handleGpioPinDigitalStateChangeEvent(GpioPinDigitalStateChangeEvent event) {
//                // display pin state on console
//                console.println(" --> GPIO PIN STATE CHANGE: " + event.getPin() + " = " +
//                        ConsoleColor.conditional(
//                                event.getState().isHigh(), // conditional expression
//                                ConsoleColor.GREEN,        // positive conditional color
//                                ConsoleColor.RED,          // negative conditional color
//                                event.getState()));        // text to display
//            }
//        });
//
//
//        // prompt user that we are ready
//        console.println(" ... Successfully provisioned output pin: " + output1.toString());
//        console.emptyLine();
//        console.box("The GPIO output pin states will cycle HIGH and LOW states now.");
//        console.emptyLine();
//
//        // notify user of current pin state
//        console.println("--> [" + output1.toString() + "] state was provisioned with state = " +
//                ConsoleColor.conditional(
//                        output1.getState().isHigh(), // conditional expression
//                        ConsoleColor.GREEN,         // positive conditional color
//                        ConsoleColor.RED,           // negative conditional color
//                        output1.getState()));        // text to display
//
//        // wait
//        Thread.sleep(500);
//
//        // --------------------------------------------------------------------------
//
//        // set gpio pin state to LOW
//        console.emptyLine();
//        console.println("Setting output pin state is set to LOW.");
//        output1.low(); // or ... output.setState(PinState.LOW);
//
//        // wait
//        Thread.sleep(500);
//
//        // --------------------------------------------------------------------------
//
//        // set gpio pin state to HIGH
//        console.emptyLine();
//        console.println("Setting output pin state from LOW to HIGH.");
//        output1.setState(PinState.HIGH); // or ... output.high();
//
//        // wait
//        Thread.sleep(500);
//
//        // --------------------------------------------------------------------------
//
//        // toggle the current state of gpio pin (from HIGH to LOW)
//        console.emptyLine();
//        console.println("Toggling output pin state from HIGH to LOW.");
//        output1.toggle();
//
//        // wait
//        Thread.sleep(500);
//
//        // --------------------------------------------------------------------------
//
//        // pulse gpio pin state for 1 second HIGH and then return to LOW
//        console.emptyLine();
//        console.println("Pulsing output pin state HIGH for 1 second.");
//        output1.pulseSync(1000);
//        Thread.sleep(50);

        // --------------------------------------------------------------------------

//        // blink gpio pin state for 1 second between HIGH and LOW states
//        console.emptyLine();
//        console.println("Blinking output pin state between HIGH and LOW for 3 seconds with a blink rate of 250ms.");
//        Future<?> future = output1.blink(250, 3000);
//
//        // --------------------------------------------------------------------------
//
//        // wait for blinking to finish; we are notified in a future object
//        while(!future.isDone()){
//            Thread.sleep(50);
//        }

        // stop all GPIO activity/threads by shutting down the GPIO controller
        // (this method will forcefully shutdown all GPIO monitoring threads and scheduled tasks)

        console.waitForExit();
        gpio.shutdown();
    }
}
