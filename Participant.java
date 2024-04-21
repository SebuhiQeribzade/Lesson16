package Lesson16;
import java.io.*;
import java.util.Scanner;

class Participant {
    String name;
    int age;
    String email;

    public Participant(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
}

public class ConferenceRegistration {

    public static void displayParticipants() {
        try (BufferedReader reader = new BufferedReader(new FileReader("participants.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.println("Error reading participants.txt");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter participant details (name, age, email):");
        String name = scanner.next();
        int age = scanner.nextInt();
        String email = scanner.next();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("participants.txt", true))) {
            writer.write(name + ", " + age + ", " + email);
            writer.newLine();
            System.out.println("Participant registered successfully.");
        } catch (IOException e) {
            System.err.println("Error writing to participants.txt");
        }

        System.out.println("List of Participants:");
        displayParticipants();
    }
}
