import { Component, OnInit } from '@angular/core';
import { Book } from 'src/app/data-objects/Book';
import { LibraryService } from 'src/app/services/library.service';

@Component({
  selector: 'app-borrow-list',
  templateUrl: './borrow-list.component.html',
  styleUrls: ['./borrow-list.component.css']
})
export class BorrowListComponent implements OnInit {
  bookList : Array<Book> = [];
  isListEmpty : boolean = true;
  constructor(public libraryService: LibraryService) { }
  ngOnInit(): void {
    this.bookList = this.libraryService.bookList.filter(book=>{
      return this.libraryService.borrowList.find(borrowed=> borrowed.bookId === book.id);
    });
    if(this.bookList.length >0){
      this.isListEmpty = false;
    }
  }

  returnBook(bookId : number){

      this.libraryService.submitBook( this.libraryService.userName, bookId).subscribe(response => {
        if (response) {
          alert("Book submitted to library sucessfully.");
          this.libraryService.bookList = response.library.bookList;
          this.libraryService.borrowList = response.library.borrowList;
          this.bookList = this.libraryService.bookList.filter(book=>{
            return this.libraryService.borrowList.find(borrowed=> borrowed.bookId === book.id);
          });
          if(this.bookList.length >0){
            this.isListEmpty = false;
          }
        }
      },
        err => {
          alert(err.error.errorTo.errorMessage);
        }
      );
  
  }

}
