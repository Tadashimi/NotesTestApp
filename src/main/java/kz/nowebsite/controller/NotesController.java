package kz.nowebsite.controller;

import kz.nowebsite.domain.Note;
import kz.nowebsite.service.NoteService;
import kz.nowebsite.service.NoteServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.UUID;

@Controller
public class NotesController {
    private final NoteService noteService;

    NotesController() {
        noteService = new NoteServiceImpl();
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, produces = "text/html; charset=UTF-8")
    public String getNotesPage(Model model) {
        List<Note> notes = noteService.getAll();
        model.addAttribute("notesList", notes);
        return "notes";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "substring", produces = "text/html; charset=UTF-8")
    public String getSearchResultPage(@RequestParam(value = "substring") String substring, Model model) {
        List<Note> notes = noteService.getSearchResult(substring);
        model.addAttribute("searchString", substring);
        model.addAttribute("notesList", notes);
        return "notes";
    }

    @RequestMapping(value = "/add-new-note", method = RequestMethod.GET)
    public String addNewNotePage() {
        return "addNewNote";
    }

    @RequestMapping(value = "/add-new-note", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    public String addNewNote(@RequestParam(value = "title") String title, @RequestParam(value = "text") String text) {
        Note note = new Note(title, text);
        noteService.save(note);
        return "redirect:/";
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteItem(@PathVariable UUID id) {
        Note note = noteService.getById(id);
        noteService.delete(note);
        return "redirect:/";
    }

    @RequestMapping(value = "view/{id}", method = RequestMethod.GET)
    public String viewItem(@PathVariable UUID id, Model model) {
        Note note = noteService.getById(id);
        model.addAttribute("note", note);
        return "viewNote";
    }

    @RequestMapping(value = "/edit-note", method = RequestMethod.POST, produces = "text/html; charset=UTF-8")
    public String editNote(@RequestParam(value = "noteId") UUID id, @RequestParam(value = "title") String title, @RequestParam(value = "text") String text) {
        noteService.changeNote(id, title, text);
        return "redirect:/";
    }

}
