package fourth.laboratoy.exam.pripremni;

import java.io.IOException;
import java.nio.file.Path;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LogProcessor {
	private Path path;
	private List<LogEntry> list;

	private static final int timeLen = 23;

	/**
	 * Creates object and set file.
	 * 
	 * @param file file name
	 */
	public LogProcessor(Path file) {
		this.path = file;
		this.list = new LinkedList<LogEntry>();
	}

	/**
	 * Load file and populate list of loaded objects (LogEntry).
	 * 
	 * @throws IOException if can not load file
	 */
	public void load() throws IOException {
		try (Scanner sc = new Scanner(this.path)) {
			while (sc.hasNextLine()) {
				this.list.add(parseLog(sc.nextLine()));
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	   * Returns list of log entries.
	   * @return list of log entries
	   */
	  public List<LogEntry> getLogs() {
		  return list;
	  }

	/**
	 * Extracts elements of line and creates LogEntry.
	 * 
	 * @param line one line og log file
	 * @return created log entry object
	 */
	public static LogEntry parseLog(String line) {
//			2020-05-12 05:43:10.370  INFO [AuthenticationAuthorizationManager,,,] 
//		  1 --- [           main] s.c.a.AnnotationConfigApplicationContext : Some text ...
		String time = line.substring(0, timeLen);
		String level = line.substring(timeLen, line.indexOf("[")).trim();
		int threadStartIndex = line.indexOf("--- [ ") + ("--- [ ").length();
		String thread = line.substring(threadStartIndex , line.indexOf("]", threadStartIndex)).trim();
		String text = line.substring(line.indexOf(":", timeLen) + 2);
//	String thread = line.substring(threadStartIndex, line.indexOf("]", threadStartIndex)).trim();
//	String text = line.substring(line.indexOf(":", timeLen) + 2);

		return new LogEntry(time, level, thread, text);
	}
}
