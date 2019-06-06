package kz.nowebsite.repository;

import kz.nowebsite.domain.Note;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {

    private List<Note> notes = new ArrayList<>();

    public NotesRepositoryImpl() {
        Note note = new Note("Текст1", "Заголовок");
        notes.add(new Note(note));
    }

    @Override
    public void save(Note note) {
        notes.add(new Note(note));
    }

    @Override
    public void delete(Note note) {
        notes.remove(note);
    }

    @Override
    public List<Note> getAll() {
        return cloneNotes();
    }

    @Override
    public synchronized Note getById(UUID id) {
        for (Note n : notes) {
            if (n.getId().equals(id)) return new Note(n);
        }
        return null;
    }

    @Override
    public synchronized List<Note> getSearchResult(String subString) {
        String substringInLowerCase = subString.toLowerCase();
        List<Note> result = new ArrayList<>();
        for (Note currentNote : notes) {
            if (currentNote.getTitle().toLowerCase().contains(substringInLowerCase) || currentNote.getText().toLowerCase().contains(subString))
                result.add(new Note(currentNote));
        }
        return result;
    }

    @Override
    public synchronized void changeNote(Note note) {
        for (int i = 0; i < notes.size(); i++) {
            Note currentNote = notes.get(i);
            if (currentNote.getId().equals(note.getId())) {
                notes.set(i, new Note(note));
                break;
            }
        }
    }

    private synchronized List<Note> cloneNotes() {
        List<Note> clone = new ArrayList<>(notes.size());
        for (Note note : notes) clone.add(new Note(note));
        return clone;
    }

}
