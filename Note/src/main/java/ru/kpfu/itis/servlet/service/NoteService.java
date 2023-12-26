package ru.kpfu.itis.servlet.service;

import ru.kpfu.itis.servlet.models.Note;
import ru.kpfu.itis.servlet.repository.NoteRepository;
import ru.kpfu.itis.servlet.repository.NoteRepositoryImpl;

import java.util.List;

public class NoteService {

    private final NoteRepository noteRepository;

    public NoteService() {
        noteRepository = new NoteRepositoryImpl();
    }

    public void createNote(Note note) {
        noteRepository.saveNote(note);
    }

    public void updateNote(Note note) {
        noteRepository.updateNote(note);
    }

    public void deleteNoteById(long id) {
        noteRepository.deleteNoteById(id);
    }

    public Note getNoteById(long id) {
        return noteRepository.getNoteById(id);
    }

    public List<Note> getAllNotes() {
        return noteRepository.getAllNotes();
    }
}
