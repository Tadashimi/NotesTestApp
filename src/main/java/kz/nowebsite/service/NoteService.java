package kz.nowebsite.service;

import kz.nowebsite.domain.Note;

import java.util.List;
import java.util.UUID;

public interface NoteService {
	
	void save(Note note);

	void delete(Note note);

	List<Note> getAll();

	List<Note> getSearchResult(String substring);

	Note getById(UUID id);
}
