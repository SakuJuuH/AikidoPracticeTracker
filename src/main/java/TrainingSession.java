public class TrainingSession {

	private String date;
	private double duration;


	public TrainingSession(String date, double duration) {
		this.date = date;
		this.duration = duration;
	}

	public String getDate() {
		return date;
	}

	public double getDuration() {
		return duration;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public void setDuration(double duration) {
		if (duration < 0) {
			throw new IllegalArgumentException("Duration cannot be negative");
		}
		this.duration = duration;
	}
}
