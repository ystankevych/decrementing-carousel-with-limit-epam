package com.epam.rd.autotasks;

public class CarouselRun {
    private DecrementingCarousel dc;
    private int currentIndex;

    public CarouselRun(DecrementingCarousel dc) {
        this.dc = dc;
        currentIndex = -1;
    }

    public int next() {
        int next = -1;
        if (!isFinished()) {
            currentIndex = getIndexNextPositive();
            next = dc.getArray()[currentIndex]--;
            if (isLimited()) {
                ((DecrementingCarouselWithLimitedRun) dc).decrementLimit();
            }
        }
        return next;
    }

    public boolean isFinished() {
        if (isLimited() && ((DecrementingCarouselWithLimitedRun) dc).getActionLimit() <= 0) {
            return true;
        }
        for (int i = 0; i <= dc.getIndex(); i++) {
            if (dc.getArray()[i] > 0) {
                return false;
            }
        }
        return true;
    }

    private int getIndexNextPositive() {
        int i = currentIndex;
        while (true) {
            if (i >= dc.getIndex()) {
                i = -1;
            }
            if (dc.getArray()[++i] > 0) {
                return i;
            }
        }
    }

    private boolean isLimited() {
        return dc instanceof DecrementingCarouselWithLimitedRun;
    }
}
