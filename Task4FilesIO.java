import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Task4FilesIO {
//    private static final String filename = "notes.txt";
static  String desktopPath;
    public static void main(String[] args) {
        System.out.println("==WELCOME TO NOTES MANAGER==");
        String choice;
        Scanner sc = new Scanner(System.in);
        boolean check = true;
        while(check){
            System.out.println("Select the option");
            System.out.println("1. Write a Note");
            System.out.println("2. Read All Notes");
            System.out.println("3. Exit");
            System.out.println("Choose an option: ");
            choice = sc.nextLine();
            switch (choice){
                case "1":
                    writenotes(sc);
                    break;
                case "2":
                    readNotes(sc);
                    break;
                case "3":
                    check = false;
                    System.out.println("You have exited the Notes Manager, Thank  you...");
                    break;
                default:
                    System.out.println("Invalid choice");
                    continue;


            }
        }
        sc.close();
    }



    private static void writenotes(Scanner sc) {
        desktopPath = System.getProperty("user.home")+"/Desktop/";
        System.out.println("Enter file name for writing notes: ");
        String filename = sc.nextLine();
        System.out.println("Enter your notes here: ");
        String notes = sc.nextLine();
        try(FileWriter writer = new FileWriter(desktopPath+filename, true)){
            writer.write(notes + "\n");
            System.out.println("Notes saved successfully \n");
        } catch (IOException e) {
            System.out.println("Error while writing notes: "+e.getMessage()+"\n");
        }

    }

    private static void readNotes(Scanner sc) {
        int c = 1;
        String line;
        System.out.println("Enter file name for writing notes: ");
        String filename = sc.nextLine();
        try(BufferedReader reader  =new BufferedReader(new FileReader(desktopPath+filename))){

            System.out.println("----YOUR NOTES----\n");
            while((line = reader.readLine()) != null){
                System.out.println(c++ +". " +line);
            }
        } catch (IOException e) {
            System.out.println("File not found...\n");
        } catch (Exception e) {
            System.out.println("Error while reading the file: "+e.getMessage() +"\n");
        }
    }


}
