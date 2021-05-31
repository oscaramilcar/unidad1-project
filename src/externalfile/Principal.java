package externalfile;

import java.util.Map;



public class Principal {
	

	public static void main(String[] args) {
		TxtFile file = new TxtFile("data.txt");
		file.txtStudentsWriter();
		Map<String, Student> students = file.studentsFromTxtReader();
		StringBuilder stringBuilder = new StringBuilder();
		Statistical statistical = new Statistical();
		Statistical mostRepeatedNote = statistical.noteMustRepeated(students);
		Statistical lessRepeatedNote = statistical.noteLessRepeated(students);
		
		stringBuilder.append("AVG: ")
					.append(statistical.avg(students))
					.append("\n")
					.append("minor note: ")
					.append(statistical.minNote(students))
					.append("\n")
					.append("major note: ")
					.append(statistical.maxNote(students))
					.append("\n")
					.append("most repeated note: ")
					.append(mostRepeatedNote.getNote())
					.append(" and repeats ")
					.append(mostRepeatedNote.getNumberRepeatedNotes())
					.append(" times")
					.append("\n")
					.append("Less repeated note: ")
					.append(lessRepeatedNote.getNote())
					.append(" and repeats ")
					.append(lessRepeatedNote.getNumberRepeatedNotes())
					.append(" times ");
		
		System.out.println(stringBuilder.toString());
	}
	
}
