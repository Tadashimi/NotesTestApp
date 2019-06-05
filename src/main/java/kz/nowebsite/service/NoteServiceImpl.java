package kz.nowebsite.service;

import kz.nowebsite.domain.Note;
import kz.nowebsite.repository.NotesRepository;
import kz.nowebsite.repository.NotesRepositoryImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NoteServiceImpl implements NoteService {

    private final NotesRepository notesRepository = new NotesRepositoryImpl();

    @Override
    public void save(Note note) {
        notesRepository.save(note);
    }

    @Override
    public void delete(Note note) {
        if (note != null) {
            notesRepository.delete(note);
        }
    }

    @Override
    public List<Note> getAll() {
        return notesRepository.getAll();
    }

    @Override
    public List<Note> getSearchResult(String substring) {
        String substringInLowerCase = substring.toLowerCase();
        List<Note> result = new ArrayList<>();
        for(Note currentNote :notesRepository.getAll()) {
            if (currentNote.getTitle().toLowerCase().contains(substringInLowerCase) || currentNote.getText().toLowerCase().contains(substring))
                result.add(currentNote);
        }
        return result;
    }

    @Override
    public Note getById(UUID id) {
        return notesRepository.getById(id);
    }

    @Override
    public void changeNote(UUID id, String title, String text) {
        Note note = notesRepository.getById(id);
        note.setTitle(title);
        note.setText(text);
    }
}
