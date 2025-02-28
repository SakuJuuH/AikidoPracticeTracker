import java.time.LocalDate;

public class TrainingSession implements Comparable<TrainingSession> {

	private LocalDate date;
	private double duration;


	public TrainingSession(LocalDate date, double duration) {
		this.date = date;
		this.duration = duration;
	}

	public LocalDate getDate() {
		return date;
	}

	public double getDuration() {
		return duration;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public void setDuration(double duration) {
		if (duration < 0) {
			throw new IllegalArgumentException("Duration cannot be negative");
		}
		this.duration = duration;
	}

	@Override
	public int compareTo(TrainingSession o) {
		return this.date.compareTo(o.date);
	}
}
