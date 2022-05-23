package fourth.laboratoy.exam.pravi;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.util.Scanner;

class TextFileAnalyser {

	public static Language detectLanguage(Path file) throws IOException {
//		hrvatski - ako datoteka ima samo hrvatska slova: šđčćžŠĐČĆŽ
//		njemački - ako datoteka ima samo njemačka slova: äöüÄÖÜß
//		engleski - ako datoteka ima samo engleska slova (ASCII)
//		nepoznato - ako ima slova iz više jezika
//		Npr. ako ima slova iz HR i DE onda je rezultat nepoznato, 
//		a ako ima slova iz EN i HR onda je rezultat HR.
		Scanner sc = new Scanner(file.toFile(), StandardCharsets.UTF_8);
		boolean DE = false;
		boolean HR = false;
		boolean EN = false;
		String hr = "šđčćžŠĐČĆŽ";
		String de = "äöüÄÖÜß";
		String eng = "AaBbcdefghijklmnopqrstuvwxyz";
		while (sc.hasNext()) {
			//System.out.println("USO");
			String word = sc.next();
			for (int i = 0; i < word.length(); i++) {
				char slovo = word.charAt(i);
				
				for (int x = 0; x < hr.length(); x++) {
					//System.out.println("USO");
					if (slovo == hr.charAt(x)) {
						//System.out.println("USO");
						HR = true;
					}
				}
				for (int y = 0; y < de.length(); y++) {
					if (slovo == de.charAt(y))
						DE = true;
				}
				for (int z = 0; z < eng.length(); z++) {
					if (slovo == eng.charAt(z))
						EN = true;
				}
			}

		}
		if (DE == true && HR == true) {
			return Language.UNKNOWN;
		}
		if (DE == true && EN == true) {
			return Language.UNKNOWN;
		}
		
		else if (DE == true) {
			return Language.DE;
		}
		else if (HR == true) {
			return Language.HR;
		} else if(EN == true) {
			return Language.EN;
		} else {
			return Language.UNKNOWN;
		}
	}
}
