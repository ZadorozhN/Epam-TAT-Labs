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

        secondOptionalTask();
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

        System.out.println("\nEnter the sequence of number and enter 0 when you want to stop");
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

        System.out.println("The biggest number is " + max + " and its length is " + Integer.toString(max).length());
        System.out.println("The smallest number is " + min + " and its length is " + Integer.toString(min).length());

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

        System.out.println("Number which has the minimal number of digits is " + numb);

        //Fifth task

        int counter = 0;
        int counterOfEvenAndOdd = 0;
        for(int i = 0; i < listOfNumbers.size(); i++){
            int counterOfOdd = 0;
            char[] digits = listOfNumbers.get(i).toString().toCharArray();
            for(int j = 0; j < digits.length; j++){
                if((digits[j] - '0') % 2 == 0){
                    if(j == digits.length - 1 && counterOfOdd == 0){
                        counter++;
                    }
                }
                else counterOfOdd++;
            }
            if(digits.length % 2 != 1 && counterOfOdd == digits.length / 2)
                counterOfEvenAndOdd++;

        }

        System.out.println("Number of numbers which contain only even digits is " + counter);
        System.out.println("Number of numbers which contain equal number of odd and even " + counterOfEvenAndOdd);

        //Sixth task

        int orderedNumber = -1;
        for(int i = 0; i < listOfNumbers.size(); i++){
            char[] digits = listOfNumbers.get(i).toString().toCharArray();
            for(int j = 0; j < digits.length - 1; j++) {
                if(digits[j] - '0' <= digits[j+1] - '0'){
                    if(j == digits.length - 2) {
                        orderedNumber = listOfNumbers.get(i);
                    }
                }
                else break;
            }
            if(orderedNumber != -1){
                break;
            }
        }

        System.out.println("Number which has ordered digits is " + orderedNumber);

        //Seventh task

        int numbWithDifDigits = 0;
        for(int i = 0; i < listOfNumbers.size(); i++){
            if(listOfNumbers.get(i).toString().chars().count() == listOfNumbers.get(i).toString().chars().distinct().count()){
                numbWithDifDigits = listOfNumbers.get(i);
                break;
            }
        }

        System.out.println("The number with all different digits is " + numbWithDifDigits);

    }

    public static void secondOptionalTask(){
        Scanner scan = new Scanner(System.in);
        int n;
        System.out.println("Enter the array dimension");

        while(!scan.hasNext()){
            System.out.println("This is not a number try again");
            scan.next();
        }

        n = scan.nextInt();
        int[][] arr = new int[n][n];
        Random rand = new Random();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                arr[i][j] = rand.nextInt() % 100;
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //First task;

        System.out.println("Enter the index of row");

        int indexOfRow;

        while(!scan.hasNext()){
            System.out.println("This is not a number try again");
            scan.next();
        }

        indexOfRow = scan.nextInt();

        QuickSort.quickSort(arr[indexOfRow],0, arr[indexOfRow].length - 1,new BoolComparator<Integer>(){

            @Override
            public boolean compare(Integer o1, Integer o2) {
                if(o1 > o2)
                    return true;
                return false;
            }
        });

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("Enter the index of column");

        int indexOfCol;

        while(!scan.hasNext()){
            System.out.println("This is not a number try again");
            scan.next();
        }

        indexOfCol = scan.nextInt();

        QuickSort.quickSortColumn(arr, indexOfCol,0, arr.length - 1,new BoolComparator<Integer>(){

            @Override
            public boolean compare(Integer o1, Integer o2) {
                if(o1 > o2)
                    return true;
                return false;
            }
        });

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

        //Second task
        int indexMin=0;
        int indexMax=0;
        int row = 0;
        for(int i = 0; i < arr.length; i++){
            int localStartInd = 0;
            int localEndInd = 0;
            for(int j = 0; j < arr.length - 1; j++){
                if(arr[i][j] <= arr[i][j+1]){
                    localEndInd++;
                    if(localEndInd - localStartInd > indexMax - indexMin){
                        indexMax = localEndInd;
                        indexMin = localStartInd;
                        row = i;
                    }
                }
                else{
                    localStartInd = j+1;
                    localEndInd = j+1;
                }
            }
        }

        System.out.println("The longest sequence of numbers is ");

        for(int i = indexMin; i <= indexMax; i++){
            System.out.print(arr[row][i] + " ");
        }

        System.out.println();

        //Third task

        for(int i = 0; i < arr.length; i++){
            int buf = 0;
            boolean isFit = false;
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] > 0){
                    isFit = !isFit;
                    if(!isFit) break;
                }
                if(isFit)
                    buf += arr[i][j];
            }
            System.out.println(i + " row has the sum of elements which are located between first and second positive elements of array is " + buf);
        }

        //Fourth task

        int indexOfColumnMaxEl = 0;
        int indexOfRowMaxEl = 0;

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr.length; j++){
                if(arr[i][j] > arr[indexOfRowMaxEl][indexOfColumnMaxEl]){
                    indexOfRowMaxEl = i;
                    indexOfColumnMaxEl = j;
                }
            }
        }

        int[][] reducedArr = new int[n-1][n-1];

        for(int i = 0, i2 = 0; i < arr.length; i++, i2++){
            if(i == indexOfRowMaxEl) i ++;
            for(int j = 0, j2 = 0; j < arr.length; j++, j2++){
                if(j == indexOfColumnMaxEl) j++;
                reducedArr[i2][j2] = arr[i][j];
            }
        }

        for(int i = 0; i < reducedArr.length; i++){
            for(int j = 0; j < reducedArr.length; j++){
                System.out.print(reducedArr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public interface BoolComparator<T>{

        boolean compare(T o1, T o2);

    }
}
