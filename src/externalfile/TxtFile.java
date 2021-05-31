package externalfile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TxtFile {
	private String txtFilePath;

	public TxtFile(String txtFilePath) {
		this.txtFilePath = txtFilePath;
	}

	public Map<String, Student> studentsFromTxtReader() {
		Map<String, Student> students = new HashMap<String, Student>();
		try {
			File file = new File(this.txtFilePath);
			Scanner scanner = new Scanner(file);
			
			while (scanner.hasNext()) {
				String data = scanner.nextLine();
				Student student = studentFromTxtLineReader(data);
				students.put(student.getName(), student); 
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found");
			e.printStackTrace();
		}
		return students;
	}

	private Student studentFromTxtLineReader(String txtLine) {
		String[] parts = txtLine.split(",");

		String name = parts[0];
		double note = Double.parseDouble(parts[1]);

		return new Student(name, note);

	}

	public void txtStudentsWriter() {
		try {
			Scanner scanner = new Scanner(System.in);
			String nombre;
			int nota, index;
			index = 1;
			File file = new File("data.txt");
			PrintWriter pw = new PrintWriter(new FileOutputStream(file, true));
			while(index<=20){
				System.out.println(String.format("%d - %s", index, "Enter name and note"));
				nombre = scanner.nextLine();
				nota = Integer.parseInt(scanner.nextLine());
				//pw.append(nombre + "," + nota + "\n");
				pw.append(String.format("%s,%d \n", nombre, nota));
				index++;
			}
			pw.close();
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}
	
}
