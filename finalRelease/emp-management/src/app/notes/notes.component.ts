import {Component, Inject, OnInit} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {ApiService} from '../api.service';
import {Quection} from './model/Quection';
import {Answer} from './model/Answer';

@Component({
  selector: 'app-notes',
  templateUrl: './notes.component.html',
  styleUrls: ['./notes.component.css']
})


export class NotesComponent implements OnInit {

  mcqSubjects: Subject[] = [];
  quections: Quection[] = [];
  selectedSubject: Subject;
  mcqSet: Answer[] = [
    {id: 0, answerString: 'I', istrue: true},
    {id: 0, answerString: 'I', istrue: false},
    {id: 0, answerString: 'I', istrue: false},
    {id: 0, answerString: 'I', istrue: false},


  ];

  constructor(private api: ApiService) {
  }

  // initialize
  ngOnInit() {

    this.getAllNoteBooks();
    this.getAllOneNotes();
  }

  public getAllNoteBooks() {

    this.api.getAllSubject()
      .subscribe(data => {
          console.log(data);
          this.mcqSubjects = data;
          //   this.selectedNoteBook = this.noteBooks[0];
        }
        ,
        error => {
          alert(error);
        });
  }

  createSubject() {
    const subject: Subject = {
      id: 0,
      name: 'new Notebook',
      noOfNotes: 4
    };

    this.api.saveSubject(subject).subscribe(data => {
      console.log(data.id);
      subject.id = data.id;
      this.mcqSubjects.push(subject);

    }, error => {
      alert(error);
    });

  }

  updateSubject(subject: Subject) {
    this.api.saveSubject(subject).subscribe(data => {
      console.log(data);

      // this.noteBooks.push(data);

    }, error => {
      alert(error);
    });
  }

  deleteSubject(id: number) {
    if (confirm('Do you want to delete this ?')) {
      this.api.deleteNote(id).subscribe(
        data => {
          console.log(data);
          this.mcqSubjects = this.mcqSubjects.filter(e => e.id !== data.id);
          // this.noteBooks.push(data);

        }, error => {
          alert(error);
        });
    }
  }

  getAllOneNotes() {
    this.api.getOneQuections().subscribe(
      data => {
        console.log(data);
        this.quections = data;
      }, e => alert(e));
  }

  deleteNote(id: number) {
    this.api.deleteQuection(id).subscribe(
      res => {
        alert('delete success');
        this.quections = this.quections.filter(e => e.id !== id);
      }
      , e => {
        alert(e);
      });
  }

  createNote(noteBookId: number) {
    const newNote: Quection = {
      id: 0,
      title: 'newest note',
      text: 'new note is made by ishan',
      subjectId: noteBookId,
      lastModifiedstring: '2030',
      answerList: this.mcqSet
    };

    this.api.saveQuection(newNote).subscribe(
      data => {
        console.log(data)
        ;
        newNote.id = data.id;
        this.quections.push(newNote);
      },
      e => {
        alert('error');
      }
    );
  }

  setSelectedBook(subject: Subject) {
    this.selectedSubject = subject;
    this.api.getQuectionsById(subject.id).subscribe(data => {
      console.log(data);
      this.quections = data;
    }, e => alert(e));
  }

  updateNote(note: Quection) {
// add answer list
//     this.mcqSet.map(mcq => mcq.quection = note);

    note.answerList = this.mcqSet;
    console.log('mcq array ' + this.mcqSet);
    this.api.saveQuection(note).subscribe(
      data => {
        console.log('note Updated ');

      },
      e => {
        console.log(e);
        alert('error');
      }
    );
  }

  getAllNotes() {
    this.selectedSubject = null;
    this.getAllOneNotes();
  }

  confirmAns() {
    console.log(this.mcqSet);
    alert('hadfa');
  }

  changeAnswer(no: number, quection: Quection) {
    this.mcqSet.map(e => e.istrue = false);
    this.mcqSet[no].istrue = true;
    this.updateNote(quection);
  }


}
