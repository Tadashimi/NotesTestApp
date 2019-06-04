package kz.nowebsite.repository;

import kz.nowebsite.domain.Note;

import java.util.List;

public interface NotesRepository {

	void save(Note note);
	
	void delete(Note note);
	
	List<Note> getAll();
	
	Note getById(Integer id);
}
