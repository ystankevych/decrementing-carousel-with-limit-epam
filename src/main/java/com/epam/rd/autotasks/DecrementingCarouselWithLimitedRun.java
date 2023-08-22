package com.epam.rd.autotasks;

public class DecrementingCarouselWithLimitedRun extends DecrementingCarousel {
    private int actionLimit;

    public DecrementingCarouselWithLimitedRun(final int capacity, final int actionLimit) {
        super(capacity);
        if (actionLimit < 0) {
            throw new IllegalArgumentException("Limit is negative");
        }
        this.actionLimit = actionLimit;
    }

    public int getActionLimit() {
        return actionLimit;
    }

    protected void decrementLimit() {
        if (actionLimit > 0) {
            actionLimit--;
        }
    }
}
