package lesson8.task1;

public class ResultContainer {
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;

    public void setMax(int max) {
        this.max = max;
    }

    public void setMin(int min) {
        this.min = min;
    }

    public int getMax() {
        return max;
    }

    public int getMin() {
        return min;
    }
}
