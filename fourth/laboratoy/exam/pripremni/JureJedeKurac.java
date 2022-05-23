package fourth.laboratoy.exam.pripremni;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Map;
import java.util.Set;

public class JureJedeKurac {

	public static void main(String[] args) throws IOException {
		int timeLen = 23;
		String line = "2020-05-12 05:43:10.370  INFO [AuthenticationAuthorizationManager,,,]  1 --- [           main] s.c.a.AnnotationConfigApplicationContext : Some text ...";
		String time = line.substring(0, timeLen);
		String level = line.substring(timeLen, line.indexOf("[")).trim();
		int threadStartIndex = line.indexOf("--- [ ") + ("--- [ ").length();
		String thread = line.substring(threadStartIndex , line.indexOf("]", threadStartIndex)).trim();
		String text = line.substring(line.indexOf(":", timeLen) + 2);
		System.out.println(time);
		System.out.println(level);
		System.out.println(thread);
		System.out.println(text);
		
	}
}
