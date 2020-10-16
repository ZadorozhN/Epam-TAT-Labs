package entities;

import java.util.concurrent.Semaphore;

public class Airplane extends Thread {
    public int airplaneId;
    public Semaphore runways;

    public Airplane(int airplaneId, Semaphore runways){
        this.airplaneId = airplaneId;
        this.runways = runways;
    }

    @Override
    public void run(){

        try {
            System.out.printf("Airplane %d is waiting for any runway\n", airplaneId);
            runways.acquire();
            sleep(1000);
            System.out.printf("Airplane %d has taken a runway\n", airplaneId);
            sleep(1000);
            System.out.printf("Airplane %d has got the need speed\n", airplaneId);
            sleep(1000);
            System.out.printf("Airplane %d has flown up\n", airplaneId);
            runways.release();
            System.out.printf("Runway is free\n");

        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
