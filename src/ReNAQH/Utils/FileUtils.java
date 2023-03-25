package ReNAQH.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;

public class FileUtils {
	public static String LoadFile(String path) {
		String result = new String();
		File file = new File(path);
		Scanner reader = null;

		try {
			reader = new Scanner(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		while (reader.hasNextLine()) {
			result += reader.nextLine()+"\n";
		}

		reader.close();
		return result;
	}
	
	public static void WriteFile(String path, String content) {
		FileWriter writer = null;
		
		try {
			writer = new FileWriter(path);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			writer.write(content);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			writer.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}