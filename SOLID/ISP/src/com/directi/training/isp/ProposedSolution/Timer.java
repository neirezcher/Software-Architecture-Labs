package com.directi.training.isp.ProposedSolution;

import java.util.TimerTask;

public class Timer {
    public void register(long timeOut, final ITimedDoor timed_door)
    {
        java.util.Timer timerUtility = new java.util.Timer();
        timerUtility.schedule(new TimerTask()
        {
            @Override
            public void run()
            {
                timed_door.timeOutCallback();
            }
        }, timeOut);
    }
}
