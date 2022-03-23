package com.williamhill.model;

public class DropZone implements Comparable<DropZone> {
    private BonusPlayResult bonusPlayResult;
    private int count;
    private Counter counter;

    public DropZone(Counter counter, BonusPlayResult bonusPlayResult) {
        this.counter = counter;
        this.bonusPlayResult = bonusPlayResult;
        this.count = bonusPlayResult.getPercentage();
    }

    public double getTotalCount() {
        return count * 100.0 / counter.getCounter();
    }

    public void drop() {
        counter.increment();
        count++;
    }

    public BonusPlayResult getBonusPlayResult() {
        return bonusPlayResult;
    }

    @Override
    public int compareTo(DropZone o) {
        if (getTotalCount() <= bonusPlayResult.getPercentage()) {
            return -1;
        }
        return 1;
    }
}
