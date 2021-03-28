import { Component, OnInit } from '@angular/core';
import { LibraryService } from 'src/app/services/library.service';

@Component({
  selector: 'app-bookdetails',
  templateUrl: './bookdetails.component.html',
  styleUrls: ['./bookdetails.component.css']
})
export class BookdetailsComponent implements OnInit {

  constructor(public libraryService: LibraryService) { }
  ngOnInit(): void {
    this.libraryService.loadLibrary(this.libraryService.userName).subscribe((response) => {
      this.libraryService.bookList = response.library.bookList;
      this.libraryService.borrowList = response.library.borrowList;
    });
  }

  borrowBook(bookId: number) {
    this.libraryService.borrowBook(this.libraryService.userName, bookId).subscribe(response => {
      if (response) {
        alert("Book added to your borrow list sucessfully.");
        this.libraryService.bookList = response.library.bookList;
        this.libraryService.borrowList = response.library.borrowList;
      }
    },
      err => {
        alert(err.error.errorTo.errorMessage);
      }
    );

  }

}
