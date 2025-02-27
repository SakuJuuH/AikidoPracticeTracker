import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class AikidoPracticeTrackerTest {

	AikidoPracticeTracker tracker = new AikidoPracticeTracker();

	@Test
	void testAddTrainingSession() {
		tracker.addTrainingSession(new TrainingSession(LocalDate.now(), 60));
		assertEquals(60, tracker.getTotalTrainingTime());
	}

	@Test
	void checkGraduationEligibility() {
		tracker.addTrainingSession(new TrainingSession(LocalDate.now(), 60));
		assertFalse(tracker.checkGraduationEligibility());
		tracker.addTrainingSession(new TrainingSession(LocalDate.now().plusMonths(7), 60));
		assertTrue(tracker.checkGraduationEligibility());
	}

	@Test
	void getTotalTrainingTime() {
		tracker.addTrainingSession(new TrainingSession(LocalDate.now(), 60));
		tracker.addTrainingSession(new TrainingSession(LocalDate.now().plusDays(1), 30));
		assertEquals(90, tracker.getTotalTrainingTime());
	}
}