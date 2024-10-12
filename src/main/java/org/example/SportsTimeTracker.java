package org.example;

import java.util.ArrayList;
import java.util.Scanner;

class Activity {
    private String name;
    private int duration; // Kesto minuuteissa

    public Activity(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }
}

public class SportsTimeTracker {

    private static ArrayList<Activity> activities = new ArrayList<>();

    public static void logActivity(String name, int duration) {
        if (duration <= 0) {
            System.out.println("Keston on oltava suurempi kuin nolla.");
            return;
        }
        activities.add(new Activity(name, duration));
        System.out.println("Toiminta kirjattu: " + name + " (" + duration + " minuuttia)");
    }

    public static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("Ei vielä kirjattuja toimintoja.");
        } else {
            System.out.println("Kirjatut toiminnot:");
            for (Activity activity : activities) {
                System.out.println(activity.getName() + " - " + activity.getDuration() + " minuuttia");
            }
        }
    }

    public static void totalTime() {
        int total = 0;
        for (Activity activity : activities) {
            total += activity.getDuration();
        }
        System.out.println("Yhteensä aikaa urheiluun: " + total + " minuuttia");
    }

    public static void handleUserInput(Scanner scanner) {
        while (true) {
            System.out.println("\n1. Kirjaa toiminta\n2. Näytä toiminnot\n3. Yhteensä aikaa\n4. Poistu");
            int choice = scanner.nextInt();
            scanner.nextLine(); // kuluta uusi rivi

            if (choice == 1) {
                System.out.println("Syötä toiminnan nimi:");
                String name = scanner.nextLine();
                System.out.println("Syötä toiminnan kesto (minuutteina):");
                int duration = scanner.nextInt();
                logActivity(name, duration);
            } else if (choice == 2) {
                viewActivities();
            } else if (choice == 3) {
                totalTime();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Virheellinen valinta. Yritä uudelleen.");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        handleUserInput(scanner);
        scanner.close();
    }
}
