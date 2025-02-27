import java.util.ArrayList;
import java.util.List;

public class AikidoPracticeTracker {

	List<TrainingSession> trainingSessions;
	private boolean isEligibleForGraduation;

	public AikidoPracticeTracker() {
		trainingSessions = new ArrayList<>();
		isEligibleForGraduation = false;
	}

	public void addTrainingSession(TrainingSession session) {
		if (isDuplicate(session)) {
			System.out.println("Duplicate session detected. Not adding.");
			return;
		}
		this.trainingSessions.add(session);
		
		System.out.println("Training session added: " + session.getDate() + ", Duration: " + session.getDuration());

	}

	public boolean isDuplicate(TrainingSession session) {
		for (TrainingSession s : trainingSessions) {
			if (s.getDate().equals(session.getDate())) {
				return true;
			}
		}
		return false;
	}

	public void checkGraduationEligibility() {
		if (trainingSessions.size() >= 100) {
			isEligibleForGraduation = true;
			System.out.println("You are eligible for graduation!");
		} else {
			System.out.println("You need more training sessions to be eligible for graduation.");
		}
	}
	
	public double getTotalTrainingTime() {
		double totalTime = 0;
		for (TrainingSession session : trainingSessions) {
			totalTime += session.getDuration();
		}
		return totalTime;
	}
}
