package kz.nowebsite.repository;

import kz.nowebsite.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {

    private List<Note> notes = Collections.synchronizedList(new ArrayList<>());

    public NotesRepositoryImpl() {
        Note note = new Note();
        note.setId(UUID.randomUUID());
        note.setText("Текст1");
        note.setTitle("Заголовок");
        notes.add(note);
    }

    public void save(Note note) {
        note.setId(UUID.randomUUID());
        notes.add(note);
    }

    public synchronized void delete(Note note) {
        notes.remove(note);
    }

    public List<Note> getAll() {
        return notes;
    }

    public synchronized Note getById(UUID id) {
       for (Note n:notes) {
           if (n.getId().equals(id)) return n;
       }
       return null;
    }
}
