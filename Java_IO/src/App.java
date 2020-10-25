import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class App {

    public static void filesTree(File file, int deep, PrintStream out) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (int i = 0; i < files.length; i++) {

                out.println(files[i].getAbsolutePath());
                if (files[i].isDirectory())
                    filesTree(files[i], deep + 1, out);
            }
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 46, 3, 5, 7, 1, 2, 6, 9, 9, 3, 6, 3, 23, 5, 74, 73, 45};

        QuickSort.sort2(arr, 0, arr.length - 1);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

        OptionalTask();
        if (args.length == 0) return;

        File file;
        File output = new File("E:/GitHub/output.txt");
        PrintStream ps;

        if (!output.exists()) {
            try {
                output.createNewFile();
            } catch (IOException e) {
                System.out.println("Creating of file is failed");
                System.out.println("Error: " + e.getMessage());
                return;
            }
        }

        if (args != null) {
            file = new File(args[0]);
        } else {
            System.out.println("file hasn't been pointed");
            return;
        }

        if (file.isDirectory()) {
            try {
                ps = new PrintStream(output);
                filesTree(file, 0, ps);

            } catch (FileNotFoundException e) {
                System.out.println("Creating of print stream is failed");
                System.out.println("Error: " + e.getMessage());
                return;
            }
        }
        if (file.getName().endsWith(".txt")) {

            int numberOfDirectories = 0;
            int numberOfFiles = 0;
            int numberOfSymbols = 0;
            try {

                FileReader is = new FileReader(file.getAbsolutePath());
                File buf;
                StringBuilder sb = new StringBuilder();

                int c = 0;
                while ((c = is.read()) != -1) {
                    if (c == '\r') continue;
                    if (c == '\n') {
                        buf = new File(sb.toString());
                        if (buf.exists()) {
                            if (buf.isDirectory())
                                numberOfDirectories++;
                            if (buf.isFile())
                                numberOfFiles++;
                        }

                        sb.delete(0, sb.length());
                        continue;
                    }
                    sb.append((char) c);
                    numberOfSymbols++;
                }

            } catch (FileNotFoundException e) {
                System.out.println("File hasn't found");
                System.out.println("Error: " + e.getMessage());
            } catch (IOException e) {
                System.out.println("Exception happened in I/O");
                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("Number of files is " + numberOfFiles);
            System.out.println("Number of directories is " + numberOfDirectories);
            System.out.println("Average number of files in directories is " + (float) numberOfFiles / numberOfDirectories);
            System.out.println("Average length of files in directories is " + (float) numberOfSymbols / numberOfFiles);
        }
    }

    public static void OptionalTask() {

        //First task

        File file = new File("E:/GitHub/Output");
        File fileWithRandomNumbers = new File("E:/GitHub/Output/fileWithRandomNumbers.txt");

        if (!file.exists()) {
            file.mkdir();
        }

        if (!fileWithRandomNumbers.exists()) {
            try {
                fileWithRandomNumbers.createNewFile();
            } catch (IOException e) {
                System.out.println("Impossible to create file");
                System.out.println("Error: " + e.getMessage());
            }
        }

        try (PrintStream ps = new PrintStream(fileWithRandomNumbers)) {
            Random random = new Random();
            for (int i = 0; i < 100; i++) {
                ps.println(Math.abs(random.nextInt()) % 100);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Impossible to create output stream");
            System.out.println("Error: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Exception caused in I/O operations");
            System.out.println("Error: " + e.getMessage());
        }

        try (BufferedReader br = new BufferedReader(new FileReader(fileWithRandomNumbers))) {

            int[] arrFromFile = br.lines().mapToInt(Integer::parseInt).toArray();

            QuickSort.sort(arrFromFile, 0, arrFromFile.length - 1);

            PrintStream ps = new PrintStream(fileWithRandomNumbers);

            for (int i = 0; i < arrFromFile.length; i++) {
                ps.println(arrFromFile[i]);
            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Second, third and fourth tasks

        File javaFile = new File("E:/GitHub/Output/javaFile.java");
        File javaFileRedacted = new File("E:/GitHub/Output/javaFileOutput.java");
        File javaFileRedactedThirdTask = new File("E:/GitHub/Output/javaFileOutputThirdTask.java");
        File javaFileWithCaseRedaction = new File("E:/GitHub/Output/javaFileOutputUpperCase.java");

        try {
            if (!javaFile.exists()) {
                javaFile.createNewFile();
            }
            if (!javaFileRedacted.exists()) {
                javaFileRedacted.createNewFile();
            }
            if (!javaFileRedactedThirdTask.exists()) {
                javaFileRedactedThirdTask.createNewFile();
            }
            if (!javaFileWithCaseRedaction.exists()) {
                javaFileWithCaseRedaction.createNewFile();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(javaFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(javaFileRedacted));
             BufferedWriter bw3Task = new BufferedWriter(new FileWriter(javaFileRedactedThirdTask));
             BufferedWriter bw4Task = new BufferedWriter(new FileWriter(javaFileWithCaseRedaction))) {
            String buf;
            String[] words;
            while ((buf = br.readLine()) != null) {
                bw.write(buf.replaceAll("public", "private") + "\n");
                for (int i = buf.length() - 1; i >= 0; i--)
                    bw3Task.append(buf.charAt(i));
                bw3Task.append('\n');
                bw3Task.flush();
                words = buf.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].length() > 2)
                        words[i] = words[i].toUpperCase();
                }
                bw4Task.write(String.join(" ", words) + "\n");

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //Fifth task
        File studentsFile = new File("E:/GitHub/Output/students.txt");
        File studentsFileOutput = new File("E:/GitHub/Output/studentsOutput.txt");
        try {
            if (!studentsFileOutput.exists()) {
                studentsFileOutput.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (BufferedReader br = new BufferedReader(new FileReader(studentsFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(studentsFileOutput))) {

            String buf;
            String pair[] = new String[2];
            final int grade = 7;
            while((buf = br.readLine()) != null) {

                pair = buf.split(" ");
                if (Integer.valueOf(pair[1]) > grade){
                    pair[0] = pair[0].toUpperCase();
                }
                bw.append(String.join(" ", pair));
                bw.append("\n");
                bw.flush();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}