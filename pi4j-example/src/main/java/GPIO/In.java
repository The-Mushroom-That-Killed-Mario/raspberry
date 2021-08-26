package GPIO;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.PinState;

public class In {


    private GpioPinDigitalInput in;
    private int number;
    private boolean activityIn;
    private boolean activityConditionIs0;
    private String nameActivityRange;
    private String namePassivityRange;
    private TimeOutInterval[] timeOutIntervals;
    private Out[] outs;
    private boolean messageTG;

    int[] swithOnTimeOuts;


    public In(){
    }

    public  In(int number, GpioPinDigitalInput in, boolean activityIn,
               String nameActivityRange, String namePassivityRange,Out[] outs,TimeOutInterval timeOutInterval, boolean messageTG){
        this.number= number;
        this.activityIn = activityIn;
        this.in = in;
        this.nameActivityRange = nameActivityRange;
        this.namePassivityRange = namePassivityRange;
        this.outs = outs;
        this.messageTG = messageTG;
        this.timeOutIntervals = timeOutIntervals;
    }

    public String getStatus(){
        return in.getState().toString();
    }

    public String getName(){
        return in.getName();
    }

    public void setName(String name){
        in.setName(name);
    }

}
