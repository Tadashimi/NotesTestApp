package kz.nowebsite.repository;

import kz.nowebsite.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class NotesRepositoryImpl implements NotesRepository {

    private List<Note> notes = new ArrayList<Note>();

    public NotesRepositoryImpl() {
        Note note = new Note();
        note.setId(0);
        note.setText("Текст1");
        note.setTitle("Заголовок");
        notes.add(note);
    }

    public void save(Note note) {
        notes.add(note);
    }

    public void delete(Note note) {
        notes.remove(note);
    }

    public List<Note> getAll() {
        return notes;
    }

    public Note getById(Integer id) {
        return notes.get(id);
    }
}
