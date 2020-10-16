import entities.Airplane;
import entities.Car;

import java.util.Random;
import java.util.concurrent.*;

public class App {
    public static void main(String[] args){
        optionalTask();
//        Semaphore places = new Semaphore(5);
//        Random rand = new Random();
//        System.out.println("--PARKING--");
//        for(int i = 1; i < 11; i++){
//            new Car(i, places, Math.abs(rand.nextInt() % 10), Math.abs(rand.nextInt() % 10)).start();
//        }
    }

    public static void optionalTask(){
        Semaphore runways = new Semaphore(5);
        Random rand = new Random();
        System.out.println("--AIRPORT--");
        for(int i = 1; i < 11; i++){
            new Airplane(i, runways).start();
        }
    }
}
