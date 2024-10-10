import java.util.ArrayList;
import java.util.Scanner;

class Activity {
    private String name;
    private int duration; // Duration in minutes

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
        activities.add(new Activity(name, duration));
        System.out.println("Activity logged: " + name + " (" + duration + " minutes)");
    }

    public static void viewActivities() {
        if (activities.isEmpty()) {
            System.out.println("No activities logged yet.");
        } else {
            System.out.println("Logged activities:");
            for (Activity activity : activities) {
                System.out.println(activity.getName() + " - " + activity.getDuration() + " minutes");
            }
        }
    }

    public static void totalTime() {
        int total = 0;
        for (Activity activity : activities) {
            total += activity.getDuration();
        }
        System.out.println("Total time spent on sports: " + total + " minutes");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Log Activity\n2. View Activities\n3. Total Time\n4. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            if (choice == 1) {
                System.out.println("Enter activity name:");
                String name = scanner.nextLine();
                System.out.println("Enter activity duration (minutes):");
                int duration = scanner.nextInt();
                logActivity(name, duration);
            } else if (choice == 2) {
                viewActivities();
            } else if (choice == 3) {
                totalTime();
            } else if (choice == 4) {
                break;
            } else {
                System.out.println("Invalid choice. Try again.");
            }
        }
        scanner.close();
    }
}
