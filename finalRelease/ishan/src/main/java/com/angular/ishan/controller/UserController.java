package com.angular.ishan.controller;

import com.angular.ishan.model.*;
import com.angular.ishan.repository.UserRepository;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
  List<NoteBook> noteBooks = new ArrayList();
  static List<Note> list = new ArrayList<>();
  static List<OneNote> oneNotes = new ArrayList<>();

  // standard constructors

  private final UserRepository userRepository;

  static {

    list.add(new Note("ishan", "i1", 12));
    list.add(new Note("a", "i2", 3));
    list.add(new Note("fishan", "i3", 4));
    list.add(new Note("fsishan", "i4", 5));
    list.add(new Note("vishan", "i5", 6));
    list.add(new Note("ifsdshan", "i6", 7));


    oneNotes.add(new OneNote("1", "java", "sdfsfsfdsf asfd", "i1", "2020"));
    oneNotes.add(new OneNote("2", "java", "33333 asfd", "i1", "2020"));
    oneNotes.add(new OneNote("3", "java", "sdfsfsfdsf asfd", "i2", "2020"));
    oneNotes.add(new OneNote("4", "java", "d33333 asfd", "i2", "20230"));
    oneNotes.add(new OneNote("5", "java", "sdfsfsfdsf asfd", "i1", "2020"));

  }

  public UserController(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  @GetMapping("/users")
  public List<User> getUsers() {
    return (List<User>) userRepository.findAll();
  }

  @PostMapping("/users")
  void addUser(@RequestBody User user) {
    userRepository.save(user);
  }

  @PostMapping("/api/feedback")
  Feedback feedback(@RequestBody Feedback feedback) {
    System.out.println(feedback.getEmail());
    return feedback;
  }

  @GetMapping("api/all")
  List<Note> getNotes() {


    return list;
  }

  @PostMapping(value = "api/save")
  public Note save(@RequestBody Note noteBook) {
    System.out.println("created " + noteBook.getName());
    list.forEach(e -> {
      if (
              e.getId().equals(noteBook.getId())) {
        e.setName(noteBook.getName());
      }
    });
    noteBook.setId(Math.floor(System.currentTimeMillis()) + "");
    list.add(noteBook);


    return noteBook;
  }

  @GetMapping("api/delete/{id}")
  public Note delet(@PathVariable String id) {
    Note note = list.stream().filter(e -> e.getId().equals(id)).findFirst().get();
    list.remove(note);

    return note;
  }

  @GetMapping("api/allone")
  public List<OneNote> onenotes() {
    return oneNotes;
  }

  @GetMapping("api/allone/{id}")
  public List<OneNote> onenotes(@PathVariable String id) {
    List<OneNote> collect = oneNotes.stream().filter(note -> note.getNoteBookId().equals(id)).collect(Collectors.toList());
    return collect;
  }

  @PostMapping("api/saveone")
  public OneNote saveNote(@RequestBody OneNote oneNote) {
    System.out.println(oneNote.getText());
    oneNotes.add(oneNote);
    return oneNote;
  }

  @GetMapping("api/deleteone/{id}")
  public void deleteNote(@PathVariable String id) {
    System.out.println(id);
    List<OneNote> collect = oneNotes.stream().filter(e -> !e.getId().equals(id)).collect(Collectors.toList());
    if (collect != null)
      oneNotes = collect;
  }
}