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

	public boolean checkGraduationEligibility() {
		if (trainingSessions.size() >= 100) {
			return true;
		} else if (trainingSessions.size() < 2) {
			return false;  // Need at least 2 sessions to compare dates
		} else {
			return trainingSessions.getFirst().getDate()
			                       .plusMonths(6)
			                       .isBefore(trainingSessions.getLast().getDate())
			       || trainingSessions.getFirst().getDate()
			                          .plusMonths(6)
			                          .isEqual(trainingSessions.getLast().getDate());
		}
	}

	public double getTotalTrainingTime() {
		double totalTime = 0;
		for (TrainingSession session : trainingSessions) {
			totalTime += session.getDuration();
		}
		return totalTime;
	}

	public void setEligibilityForGraduation() {
		this.isEligibleForGraduation = checkGraduationEligibility();
	}

}
