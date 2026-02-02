package mod6;

public class Box {
    private String boxName;
    private int clickCount;

    public Box(String boxName) {
        this.boxName = boxName;
        this.clickCount = 0;
    }

    public void incrementClicks() {
        this.clickCount++;
    }

    public int getClickCount() {
        return clickCount;
    }

    @Override
    public String toString() {
        return boxName + " clicked " + clickCount + " times.";
    }
}