package kz.nowebsite.repository;

import kz.nowebsite.domain.Note;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UUID;

public class NotesRepositoryImpl implements NotesRepository {

    private List<Note> notes = Collections.synchronizedList(new ArrayList<>());

    public NotesRepositoryImpl() {
        Note note = new Note("Текст1", "Заголовок");
        notes.add(note);
    }

    @Override
    public void save(Note note) {
        notes.add(note);
    }

    @Override
    public synchronized void delete(Note note) {
        notes.remove(note);
    }

    @Override
    public List<Note> getAll() {
        return notes;
    }

    @Override
    public synchronized Note getById(UUID id) {
       for (Note n:notes) {
           if (n.getId().equals(id)) return n;
       }
       return null;
    }

}
