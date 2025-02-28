import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class AikidoPracticeTracker {

	Set<TrainingSession> trainingSessions;
	private boolean isEligibleForGraduation;

	public AikidoPracticeTracker() {
		trainingSessions = new TreeSet<>();
		isEligibleForGraduation = false;
	}

	public void addTrainingSession(TrainingSession session) {
		if (isDuplicate(session)) {
			System.out.println("Duplicate session detected. Not adding.");
			return;
		}
		this.trainingSessions.add(session);

		System.out.println(
				"Session added successfully. Date: " + session.getDate() + ", Duration: " + session.getDuration());

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
		if (trainingSessions.size() > 100) {
			return true;
		} else if (trainingSessions.size() < 2) {
			return false;
		} else {
			TrainingSession firstSession = Collections.min(trainingSessions);
			TrainingSession lastSession = Collections.max(trainingSessions);
			return lastSession.getDate().isAfter(firstSession.getDate().plusMonths(6)) ||
			       lastSession.getDate().isEqual(firstSession.getDate().plusMonths(6));
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
