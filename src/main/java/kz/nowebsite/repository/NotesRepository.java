package kz.nowebsite.repository;

import kz.nowebsite.domain.Note;

import java.util.List;
import java.util.UUID;

public interface NotesRepository {

    void save(Note note);

    void delete(Note note);

    List<Note> getAll();

    Note getById(UUID id);

    List<Note> getSearchResult(String subString);

    void changeNote(Note note);

}
