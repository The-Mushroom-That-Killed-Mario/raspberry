package GPIO;

import com.pi4j.io.gpio.*;
import com.pi4j.io.gpio.event.GpioPinDigitalStateChangeEvent;
import com.pi4j.io.gpio.event.GpioPinListenerDigital;
import com.pi4j.util.Console;

public class Controller {
    private GpioPinDigitalInput[] inPins;           //
    private GpioPinDigitalOutput[] outPins;         //
    private String namePin;                          //  имя
    private String statePin;                          //
    private GpioPinDigitalStateChangeEvent event;   //
    private In[] ins;
//    private int[] swithTimeOnOuts1 = {1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000};
//    private int[] swithTimeOnOuts2 = {5000, 1000};
//    private int[] swithTimeOnOuts3 = {0, 0, 1000};
//    private int[] swithTimeOnOuts4 = {0, 0, 0, 1000};
//    private int[] swithTimeOnOuts5;
//    private int[] swithTimeOnOuts6;
//    private int[] swithTimeOnOuts7;
//    private int[] swithTimeOnOuts8;
    private Out[] outs;

    String ip;
    String mask;
    String gateway;
    String TG;


    GpioController gpio = GpioFactory.getInstance();  // create gpio controller


    public Controller() {


        GpioPinDigitalInput[] inPins = {
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_01, "in1"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_04, "in2"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_05, "in3"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_06, "in4"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_26, "in5"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_27, "in6"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_28, "in7"),
                gpio.provisionDigitalInputPin(RaspiPin.GPIO_29, "in8"),
        };
        this.inPins = inPins;

        GpioPinDigitalOutput[] outPins = {
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_07, "My Output 1", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_00, "My Output 2", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "My Output 3", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "My Output 4", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_21, "My Output 5", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_22, "My Output 6", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_23, "My Output 7", PinState.HIGH),
                gpio.provisionDigitalOutputPin(RaspiPin.GPIO_24, "My Output 8", PinState.HIGH),
        };
        this.outPins = outPins;
        int [] a = {1000,2000,3000,4000,5000,6000,7000,8000};  //time intervals in ms
        TimeOutInterval timeOutInterval = new TimeOutInterval(a);

        In in1 = new In(1, inPins[0], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in2 = new In(2, inPins[1], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in3 = new In(3, inPins[2], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in4 = new In(4, inPins[3], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in5 = new In(5, inPins[4], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in6 = new In(6, inPins[5], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in7 = new In(7, inPins[6], true, "unlicked", "locked", outs, timeOutInterval, false);
        In in8 = new In(8, inPins[7], true, "unlicked", "locked", outs, timeOutInterval, false);


        In[] ins = {in1, in2, in3, in3, in4, in5, in6, in7, in8};
        this.ins = ins;


        Out out1 = new Out(1, outPins[0], "On", "Off", true, false);
        Out out2 = new Out(2, outPins[1], "On", "Off", true, false);
        Out out3 = new Out(3, outPins[2], "On", "Off", true, false);
        Out out4 = new Out(4, outPins[3], "On", "Off", true, false);
        Out out5 = new Out(5, outPins[4], "On", "Off", true, false);
        Out out6 = new Out(6, outPins[5], "On", "Off", true, false);
        Out out7 = new Out(7, outPins[6], "On", "Off", true, false);
        Out out8 = new Out(8, outPins[7], "On", "Off", true, false);

        Out[] outs = {out1, out2, out3, out4, out5, out6, out7, out8};
        this.outs = outs;
    }

    public GpioPinDigitalInput[] getInPins() {
        return inPins;
    }

    public GpioPinDigitalOutput[] getOutPins() {
        return outPins;
    }

    public void controlEvent(GpioPinDigitalStateChangeEvent event) {
        //сюда передаём новые состояния входов
        event.getPin().getName();
        for (In in :
                ins) {
            if (in.getName().equals(event.getPin().getName())) {
                for (Out out:
                     outs) {
                    out.on(in.swithOnTimeOuts[out.number-1]);

                }
//                outs[0].on(in.swithOnTimeOuts[0]);
//                outs[1].on(in.swithOnTimeOuts[1]);

            }
        }


    }


}
