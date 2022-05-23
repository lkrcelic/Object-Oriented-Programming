package fourth.laboratoy.exam.pripremni;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Path;

public class FileEditor {
	
	/**
	   * Reads input file encoded in UTF-8, process content and writes it to output file.
	   * @param inputFile input file
	   * @param outputFile output file
	   * @throws IOException
	   */
	  public static void processFile(Path inputFile, Path outputFile) throws IOException {
		  InputStream input = new BufferedInputStream(new FileInputStream(inputFile.toFile()));
		  OutputStream output = new BufferedOutputStream(new FileOutputStream(outputFile.toFile()));
		  byte[] buffer = new byte[1024];
		  int read;
		  while((read = input.read(buffer)) != -1) {
			  for(int i = 0; i < read; i++) {
				  if(buffer[i] != '\r')
					  output.write(buffer[i]);
			  }
		  }
		  input.close();
		  output.close();
	  }
	  
	  public static void main(String[] args) {
		  Path in = Path.of("exampleWindows.txt");
		  Path out = Path.of("exampleLinux.txt");
		  
		  
	  }
}
