package externalfile;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Statistical {
	private double note;
	private int numberRepeatedNotes;
	
	public Statistical() {}
	
	private Statistical(double note, int numberRepeatedNotes) {
		this.note = note;
		this.numberRepeatedNotes = numberRepeatedNotes;
	}

	public double getNote() {
		return note;
	}

	public int getNumberRepeatedNotes() {
		return numberRepeatedNotes;
	}	
	
	public double avg(Map<String,Student> students){
		double avg;
		avg = 0;
		for(Student s: students.values()) {
			avg += s.getNote();
		}
		avg = avg / students.size();
		
		return avg;
	}
	
	public double minNote(Map<String,Student> students) {
		double note = 0;
		for(var s: students.values()) {
			note = s.getNote();
			for(var st:students.values()) {
				if(note > st.getNote()) {
					note = st.getNote();
				}
			}
		}
		return note;
	}
	
	public double maxNote(Map<String,Student> students) {
		double note = 0;
		for(var s: students.values()) {
			note = s.getNote();
			for(var st:students.values()) {
				if(note < st.getNote()) {
					note = st.getNote();
				}
			}
		}
		return note;
	}
	
	public Statistical noteMustRepeated(Map<String,Student> students) {
		double note = 0;
		int frequency = 1;
		Map<Double, Integer> notesCount = notesMapCounter(students);
		// Iterando a través de elementCountMap para obtener el elemento más frecuente y su
		// frecuencia
		for (Entry<Double, Integer> entry : notesCount.entrySet()) {
			if (entry.getValue() > frequency) {
				note = entry.getKey();
				frequency = entry.getValue();
			}
		}
		return new Statistical(note, frequency);
	}
	
	public Statistical noteLessRepeated(Map<String,Student> students) {
		double note = 0;
		int frequency = 1;
		double noteTemp = 0;
		Map<Double, Integer> notesCount = notesMapCounter(students);

		// Iterando a través de elementCountMap para obtener el elemento menos frecuente y su
		// frecuencia
		for(var s: notesCount.entrySet()) {
			noteTemp = s.getValue();
			for(var st:notesCount.entrySet()) {
				if(noteTemp > st.getValue()) {
					note = st.getKey();
					frequency = st.getValue();
				}
			}
		}
		return new Statistical(note, frequency);
	}
	
	// Contar frecuencia de notas (cantidad de repeticiones)
	private Map<Double, Integer> notesMapCounter(Map<String,Student> students){
		List<Double> notes = new ArrayList<Double>();
		Map<Double, Integer> notesCount = new HashMap<Double, Integer>();

		for(Student s:students.values()) {
			notes.add(s.getNote());
		}
		
		for (double i : notes) {
			if (notesCount.containsKey(i)) {
				notesCount.put(i, notesCount.get(i) + 1);
			} else {
				notesCount.put(i, 1);
			}
		}
		return notesCount;
	}
}
