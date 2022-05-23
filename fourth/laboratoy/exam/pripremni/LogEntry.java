package fourth.laboratoy.exam.pripremni;

public class LogEntry {
	private String time;
	private String level;
	private String thread;
	private String text;

	public LogEntry(String time, String level, String thread, String text) {
		this.level = level;
		this.time = time;
		this.thread = thread;
		this.text = text;
	}

	public String getTime() {
		return time;
	}

	public String getLevel() {
		return level;
	}

	public String getThread() {
		return thread;
	}

	public String getText() {
		return text;
	}

}
