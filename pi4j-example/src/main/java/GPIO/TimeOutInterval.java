package GPIO;

public class TimeOutInterval {
    private int[] timeIntervals;

    public TimeOutInterval(int[] timeIntervals) {
        this.timeIntervals = timeIntervals;
    }

    public void setTimeIntervals(int[] timeIntervals) {
        this.timeIntervals = timeIntervals;
    }

    public int[] getTimeIntervals() {
        return timeIntervals;
    }
}
