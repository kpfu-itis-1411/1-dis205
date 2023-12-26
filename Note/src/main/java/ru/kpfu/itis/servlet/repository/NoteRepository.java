package ru.kpfu.itis.servlet.repository;

import ru.kpfu.itis.servlet.models.Note;

import java.util.List;

public interface NoteRepository {
    List<Note> getAllNotes();
    Note getNoteById(long id);

    void saveNote(Note note);
    void updateNote(Note note);

    void deleteNoteById(long id);

    long getIdOfLastNoteByUser(long userId);
}
