import container.AudioDisk;
import music.Audio;
import music.Metal;
import music.Rock;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        optionalTask();

        Audio audio = new Audio(200, "Recorded telephone talking");
        Metal masterOfPuppets = new Metal(400, "Master of puppets", "Metallica");
        Metal forWhomTheBellTools = new Metal(300, "For whom the bell tools", "Metallica");
        Metal rainingBlood = new Metal(300, "Raining blood", "Slayer");
        Rock tnt = new Rock(250, "T.N.T", "AC/DC");
        Rock bigGun = new Rock(250, "Big Gun", "AC/DC");

        AudioDisk audioDisk = new AudioDisk() {
            {
                add(audio);
                add(masterOfPuppets);
                add(forWhomTheBellTools);
                add(rainingBlood);
                add(tnt);
                add(bigGun);
            }
        };

        int choice = 0;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("0 - Exit");
            System.out.println("1 - Play");
            System.out.println("2 - Shuffle");
            System.out.println("3 - Total duration");
            System.out.println("4 - Audio by duration");
            System.out.println("5 - Add audio");
            System.out.println("6 - Add metal");
            System.out.println("7 - Add rock");
            System.out.println("8 - Selected genre to start");
            System.out.println("9 - Clear playlist");

            while(!scanner.hasNextInt()){
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 0:
                    System.out.println("Exiting");
                    break;
                case 1:
                    audioDisk.play();
                    break;
                case 2:
                    audioDisk.shuffle();
                    break;
                case 3:
                    System.out.println(audioDisk.totalDuration() / 60 + " m. " + audioDisk.totalDuration() % 60 + " s.3");
                    break;
                case 4:
                    System.out.println("Enter the duration through enter");
                    try {
                        audioDisk.getAudioByDuration(scanner.nextInt(), scanner.nextInt()).play();
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.println("Enter the duration and after the name of audio through enter");
                    try {
                        audioDisk.add(new Audio(scanner.nextInt(), scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 6:
                    System.out.println("Enter the duration and after the name of audio with the name of band through enter");
                    try {
                        audioDisk.add(new Metal(scanner.nextInt(), scanner.next(), scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 7:
                    System.out.println("Enter the duration and after the name of audio with the name of band through enter");
                    try {
                        audioDisk.add(new Rock(scanner.nextInt(), scanner.next(), scanner.next()));
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 8:
                    System.out.println("Enter a genre");
                    switch (scanner.next()) {
                        case "Audio": audioDisk.musicOfGenreToStart(Audio.class); break;
                        case "Metal": audioDisk.musicOfGenreToStart(Metal.class); break;
                        case "Rock": audioDisk.musicOfGenreToStart(Rock.class); break;
                        default:
                            System.out.println("Incorrect genre");
                    }
                    break;
                case 9:
                    audioDisk.clear();
                    break;
                default:
                    System.out.println("Incorrect choice");
                    break;
            }


        } while (choice != 0);
    }

    public static void optionalTask(){
        //Seventh task
        Stack<Character> stack = new Stack<>();
        String str = "(({{[][]()}}{}))";
        for(char c : str.toCharArray()){
            if (c == '(' || c == '[' || c == '{')
                stack.push(c);
            if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) {
                    System.out.println("there are more end brackets than start brackets");
                    return;
                }
                if (stack.peek() == '(' && c != ')' || stack.peek() == '[' && c != ']' || stack.peek() == '{' && c != '}') {
                    System.out.println("There is wrong! Next bracket must be as " + stack.pop() + " but we got this one " + c);
                    return;
                } else stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            System.out.println("there are more start brackets than end brackets");
            return;
        }

        System.out.println();

        //Second task
        Stack<Integer> digits = new Stack<>();
        int number;
        int divider = 10;
        boolean key = false;

        System.out.println("Enter the number, which we will break into digits");
        Scanner scanner = new Scanner(System.in);
        while(!scanner.hasNextInt()){
            scanner.next();
        }
        number = scanner.nextInt();


        while(divider > 0) {
            if(number / divider > 9 && !key)
                divider *= 10;
            else {
                key = true;
                digits.add(number / divider % 10);
                divider /= 10;
            }
        }

        while(!digits.empty()){
            System.out.print(digits.pop());
        }

        System.out.println();

        //Eighth task
        HashSet<String> words = new HashSet();

        try(FileInputStream fis = new FileInputStream("D:/Desktop/EngText.txt")){
            StringBuilder word = new StringBuilder();
            int c;
            while((c = fis.read()) != -1){
                if(c == '\r') continue;
                if(c == ' ' || c == '\t' || c == '\n'){
                    words.add(word.toString());
                    word.delete(0, word.length());
                    continue;
                }
                word.append((char)c);

            }

            for(String w : words){
                System.out.println(w);
            }


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
