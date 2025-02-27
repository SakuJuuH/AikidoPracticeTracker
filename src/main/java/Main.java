import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		AikidoPracticeTracker tracker = new AikidoPracticeTracker();
		Scanner Scanner = new Scanner(System.in);
		boolean running = true;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");

		do {
			displayMenu();
			switch (Scanner.nextInt()) {
				case 1:
					System.out.print("Enter date (dd-MM-yyyy): ");
					String dateInput = Scanner.next();
					LocalDate date;
					try {
						date = LocalDate.parse(dateInput, formatter);
					} catch (DateTimeParseException e) {
						System.out.println("Invalid date format. Please use dd-MM-yyyy.");
						continue;
					}
					System.out.print("Enter duration (in minutes): ");
					double duration = Scanner.nextDouble();
					tracker.addTrainingSession(new TrainingSession(date, duration));
					break;
				case 2:
					System.out.printf("Total training time: %.0f minutes\n", tracker.getTotalTrainingTime());
					break;
				case 3:
					if (tracker.checkGraduationEligibility()) {
						System.out.println("You are eligible for graduation.");

					} else {
						System.out.println("You are not eligible for graduation.");
					}
					tracker.setEligibilityForGraduation();
					break;
				case 4:
					running = false;
					break;
				default:
					System.out.println("Invalid option. Please try again.");
			}
		} while (running);
	}

	public static void displayMenu() {
		System.out.println("===== Aikido Practice Tracker =====");
		System.out.println("1. Add Training Session");
		System.out.println("2. View Total Training Time");
		System.out.println("3. Check Graduation Eligibility");
		System.out.println("4. Exit");
		System.out.print("Choose an option: ");
	}
}
