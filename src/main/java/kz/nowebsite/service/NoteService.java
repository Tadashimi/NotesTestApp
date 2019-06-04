package kz.nowebsite.service;

import kz.nowebsite.domain.Note;

import java.util.List;

public interface NoteService {
	
	void save(Note note);

	void delete(Note note);

	List<Note> getAll();

	List<Note> getSearchResult(String substring);

	Note getById(Integer id);
}
