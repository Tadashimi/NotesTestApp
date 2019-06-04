package kz.nowebsite.service;

import kz.nowebsite.domain.Note;
import kz.nowebsite.repository.NotesRepository;
import kz.nowebsite.repository.NotesRepositoryImpl;

import java.util.ArrayList;
import java.util.List;

public class NoteServiceImpl implements NoteService {

    private NotesRepository notesRepository = new NotesRepositoryImpl();

    public void save(Note note) {
        if (note != null) {
            List<Note> notes = notesRepository.getAll();
            int elementId = 0;
            if (!notes.isEmpty()) {
                Note lastNote = notes.get(notes.size() - 1);
                elementId = lastNote.getId() + 1;
            }
            note.setId(elementId);
            notesRepository.save(note);
        }
    }

    public void delete(Note note) {
        if (note != null) {
            notesRepository.delete(note);
        }
    }

    public List<Note> getAll() {
        return notesRepository.getAll();
    }

    public List<Note> getSearchResult(String substring) {
        String substringInLowerCase = substring.toLowerCase();
        List<Note> result = new ArrayList<>();
        for(Note currentNote :notesRepository.getAll()) {
            if (currentNote.getTitle().toLowerCase().contains(substringInLowerCase) || currentNote.getText().toLowerCase().contains(substring))
                result.add(currentNote);
        }
        return result;
    }

    public Note getById(Integer id) {
        if (id != null) {
            return notesRepository.getById(id);
        }
        return null;
    }

}
