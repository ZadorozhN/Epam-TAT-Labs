package entities;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class Car extends Thread {
    private int carId;
    private int timeToStaying;
    private int timeToWait;
    private Semaphore sem;

    public Car(int carId, Semaphore sem, int timeToStaying, int timeToWait) {
        this.carId = carId;
        this.sem = sem;
        this.timeToStaying = timeToStaying;
        this.timeToWait = timeToWait;
    }

    public int getCarId() {
        return carId;
    }

    @Override
    public void run(){
        try {
            System.out.printf("Car %d is waiting any place\n", carId);
            if(sem.tryAcquire(this.timeToStaying, TimeUnit.SECONDS)) {

                System.out.printf("Car %d has taken its place\n", carId);

                sleep(timeToWait * 1000);

                System.out.printf("Car %d has left from its place\n", carId);

                sem.release();
            }
            else{
                System.out.printf("Car %d has left without taking any place\n", carId);

            }

        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }

    }

}
