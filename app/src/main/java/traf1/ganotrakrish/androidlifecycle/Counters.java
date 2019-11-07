package traf1.ganotrakrish.androidlifecycle;

import android.widget.TextView;

public class Counters {
    private int startCount;
    int createCount;
    int resumeCount;
    int pauseCount;
    int stopCount;
    int restartCount;
    int destroyCount;

    public Counters(){
        startCount = 0;
        createCount = 0;
        resumeCount = 0;
        pauseCount = 0;
        stopCount = 0;
        restartCount = 0;
        destroyCount = 0;
    }

    public void setCreateCount(int createCount) {
        this.createCount = createCount;
    }

    public void setDestroyCount(int destroyCount) {
        this.destroyCount = destroyCount;
    }

    public void setPauseCount(int pauseCount) {
        this.pauseCount = pauseCount;
    }

    public void setRestartCount(int restartCount) {
        this.restartCount = restartCount;
    }

    public void setResumeCount(int resumeCount) {
        this.resumeCount = resumeCount;
    }

    public void setStartCount(int startCount) {
        this.startCount = startCount;
    }

    public void setStopCount(int stopCount) {
        this.stopCount = stopCount;
    }

    public int getCreateCount() {
        return createCount;
    }

    public int getDestroyCount() {
        return destroyCount;
    }

    public int getPauseCount() {
        return pauseCount;
    }

    public int getRestartCount() {
        return restartCount;
    }

    public int getResumeCount() {
        return resumeCount;
    }

    public int getStartCount() {
        return startCount;
    }

    public int getStopCount() {
        return stopCount;
    }
}
