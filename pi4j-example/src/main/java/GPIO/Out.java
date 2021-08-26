package GPIO;

import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

public class Out {
    int number;
    GpioPinDigitalOutput out;
    String nameActivityRange;
    String namePassivityRange;

    boolean status;
    boolean messageTG;

    public Out() {

    }

    public Out(int number,
               GpioPinDigitalOutput out,
               String nameActivityRange,
               String namePassivityRange,
               boolean status,
               boolean messageTG) {
        this.number=number;
        this.out = out;
        this.nameActivityRange = nameActivityRange;
        this.namePassivityRange = namePassivityRange;
        this.status = status;
        this.messageTG = messageTG;
    }

    public String getStatus() {
        return out.getState().toString();
    }

    public void on(){
        out.setState(PinState.LOW);

    }

    public void on(int time) {
        out.pulse(time,PinState.LOW);
        System.out.println("out "+ out.getName()+" status: " + nameActivityRange);//ne pashet
    }

    public void off() {
        out.setState(PinState.HIGH);
    }

}
