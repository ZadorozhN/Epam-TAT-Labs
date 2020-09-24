package org.example;

import java.awt.desktop.QuitEvent;
import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Predicate;
import java.util.stream.Collector;
import java.util.stream.Collectors;


public class App 
{
    public static void main( String[] args ) {
        firstOptionalTask();

        //First task

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your name");
        System.out.printf("Hi %s\n", scanner.nextLine());

        //Second task

        for(int i = args.length - 1; i >= 0; i--){
            System.out.print(args[i] + " ");
        }

        //Third task

        System.out.println("\nEnter the number of random numbers");
        Random random = new Random();

        while(!scanner.hasNextInt()){
            System.out.println("that isn't a number");
            scanner.next();
        }

        int numbOfNumber = scanner.nextInt();

        for(int i = 0; i < numbOfNumber; i++) {
            System.out.print(random.nextInt(100) + " ");
        }

        System.out.println();

        for(int i = 0; i < numbOfNumber; i++) {
            System.out.println(random.nextInt(100));
        }

        //Fourth task

        System.out.println("\nEnter the number sequence and enter the 0 when you want to stop");
        int buf = 0;
        int sum = 0;
        int composition = 1;

        while(true) {

            while(!scanner.hasNextInt()){
                System.out.println("That isn't a number");
                scanner.next();
            }

            buf = scanner.nextInt();

            if(buf == 0)
                break;
            sum += buf;
            composition *= buf;
        }

        System.out.printf("Sum is %d and their composition is %d\n", sum, composition);

        //Fifth task

        System.out.println("Enter the number from 1 to 12");
        int month = 1;

        while(!scanner.hasNextInt()){
            System.out.println("That isn't a number");
            scanner.next();
        }

        month = scanner.nextInt();

        switch (month){
            case 1: System.out.println("January");
                break;
            case 2: System.out.println("February");
                break;
            case 3: System.out.println("March");
                break;
            case 4: System.out.println("April");
                break;
            case 5: System.out.println("May");
                break;
            case 6: System.out.println("June");
                break;
            case 7: System.out.println("July");
                break;
            case 8: System.out.println("August");
                break;
            case 9: System.out.println("September");
                break;
            case 10: System.out.println("October");
                break;
            case 11: System.out.println("November");
                break;
            case 12: System.out.println("December");
                break;
            default: System.out.println("A month with this index doesn't exist");
                break;
        }
    }

    public static void firstOptionalTask(){

        //First task

        System.out.println("Enter the sequence of numbers");
        Scanner scanner = new Scanner(System.in);

        List<Integer> listOfNumbers = new ArrayList<>();

        int buf;

        while(scanner.hasNextInt()){
            buf = scanner.nextInt();
            listOfNumbers.add(buf);
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int size = listOfNumbers.size();

        for(int i = 0; i < size; i++){
            if(listOfNumbers.get(i) > max){
                max = listOfNumbers.get(i);
            }
            if(listOfNumbers.get(i) < min){
                min = listOfNumbers.get(i);
            }
        }

        System.out.println("The most biggest number is " + max + " and its length is " + Integer.toString(max).length());
        System.out.println("The most smallest number is " + min + " and its length is " + Integer.toString(min).length());

        //Second task

        int[] arr = listOfNumbers.stream().mapToInt(x -> x).toArray();

        QuickSort.quickSort(arr,0,listOfNumbers.size()-1,new BoolComparator<Integer>(){
            @Override
            public boolean compare(Integer o1, Integer o2) {
                if(Integer.toString(o1).length() > Integer.toString(o2).length())
                    return true;
                return false;
            }
        });

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        System.out.println();

        //Third task

        int averageLength = 0;

        for(int i : listOfNumbers){
            averageLength += Integer.toString(i).length();
        }

        for(int i : listOfNumbers){
            if(Integer.toString(i).length() > averageLength){
                System.out.print(i + " ");
            }
        }

        System.out.println();

        //Fourth task

        Iterator<Integer> iterator = listOfNumbers.iterator();

        min = Integer.MAX_VALUE;
        int numb = 0;

        while(iterator.hasNext()){
            buf = iterator.next();
            int bufLength = (int)Integer.toString(buf).chars().distinct().count();
            if(bufLength < min){
                min = bufLength;
                numb = buf;
            }
        }

    }

    public interface BoolComparator<T>{

        boolean compare(T o1, T o2);

    }
}
