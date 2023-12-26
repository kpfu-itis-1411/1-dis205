package ru.kpfu.itis.servlet.servlets;

import ru.kpfu.itis.servlet.models.Note;
import ru.kpfu.itis.servlet.models.User;
import ru.kpfu.itis.servlet.repository.NoteRepository;
import ru.kpfu.itis.servlet.repository.NoteRepositoryImpl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;


@WebServlet("/noteList")
public class NoteListServlet extends HttpServlet {
    private NoteRepository noteRepository;

    @Override
    public void init() throws ServletException {
        super.init();
        noteRepository = new NoteRepositoryImpl();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if(type.equals("create")){
            String noteTitle = req.getParameter("title");
            String noteContent = req.getParameter("content");

            Note newNote = new Note();
            newNote.setTitle(noteTitle);
            newNote.setContent(noteContent);

            newNote.setCreatedAt(LocalDateTime.now());
            newNote.setOwnerId(((User) req.getSession().getAttribute("user")).getUser_id());

            noteRepository.saveNote(newNote);
            long id = noteRepository.getIdOfLastNoteByUser(((User) req.getSession().getAttribute("user")).getUser_id());

            resp.setStatus(200);
            resp.getWriter().write("{\"id\": " + id + "}");
        } else if (type.equals("delete")) {
            String noteId = req.getParameter("id");
            noteRepository.deleteNoteById(Long.parseLong(noteId));

            resp.setStatus(200);
        }else{
            String noteId = req.getParameter("id");
            String noteContent = req.getParameter("content");
            Note note = noteRepository.getNoteById(Long.parseLong(noteId));
            note.setContent(noteContent);
            noteRepository.updateNote(note);

            resp.setStatus(200);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Note> notes = noteRepository.getAllNotes();
        req.setAttribute("notes", notes);
        getServletContext().getRequestDispatcher("/note.ftl").forward(req, resp);
    }
}
