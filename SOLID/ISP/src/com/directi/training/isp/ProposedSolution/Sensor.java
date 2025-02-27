package com.directi.training.isp.ProposedSolution;


import java.util.Random;

public class Sensor {

    public void register(ISensingDoor sensing_door)
    {
        while (true) {
            if (isPersonClose()) {
                sensing_door.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }
}
