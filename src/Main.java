import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        writeOrRead();
        System.out.println("");
        reRunProgramm();
    }
    public static void reRunProgramm(){
        Scanner scr = new Scanner(System.in);
        System.out.println("Do you want to rerun the programm (yes/no) ?");
        String answer = scr.nextLine();
        if (answer.equals("yes")){
            writeOrRead();
        }else if (answer.equals("no")){
            System.out.println("Terminating programm");
        }
    }
    public static void writeOrRead() {
        System.out.println("Do you want to write or read a file ?");
        Scanner writeOrRead = new Scanner(System.in);
        String answer = writeOrRead.nextLine();
        questionAnswer(answer);

        Scanner scr = new Scanner(System.in);
        String fileName = scr.nextLine();
        File file = new File(fileName);
        if (answer.equals("write")) {
            try {
                System.out.println("Enter text: ");
                String userText = scr.nextLine();
                FileWriter writer = new FileWriter(file + ".txt");
                writer.write(userText);
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (answer.equals("read")) {

            try {
                if (file.equals(file + ".txt")) {
                    FileReader reader = new FileReader(file);
                    int data = reader.read();
                    while (data != -1) {
                        System.out.println((char) data);
                        data = reader.read();
                    }
                } else {
                    FileReader reader = new FileReader(file + ".txt");
                    int data = reader.read();
                    while (data != -1) {
                        System.out.print((char) data);
                        data = reader.read();
                    }
                    reader.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void questionAnswer(@NotNull String answer) {
        if (answer.equals("read")) {
            System.out.println("Enter file name:");
        } else if (answer.equals("write")) {
            System.out.println("Enter new file name:");
        }
    }
}
