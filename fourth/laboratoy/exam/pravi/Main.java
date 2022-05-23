package fourth.laboratoy.exam.pravi;

import java.io.IOException;
import java.nio.file.Path;

public class Main {

	public static void main(String[] args) throws IOException {
		Path p = Path.of("example.txt");
		System.out.println(TextFileAnalyser.detectLanguage(p));
	}

}
