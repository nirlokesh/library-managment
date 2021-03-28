import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Book, LibraryResponse } from '../data-objects/Book';


@Injectable({
  providedIn: 'root'
})
export class LibraryService {
  bookList: Array<Book> = [];
  borrowList : any[];
  userName:string;
  constructor(private httpClient: HttpClient) { }

  loadLibrary(userName : string){
    return this.httpClient.get<LibraryResponse>('http://localhost:8080/library' + '/' + userName);
  }

  borrowBook(userName : string, bookID : number){
    return this.httpClient.post<LibraryResponse>('http://localhost:8080/borrow/' + userName + '/' + bookID,null);
  }

  submitBook(userName : string, bookID : number){
    return this.httpClient.post<LibraryResponse>('http://localhost:8080/submit/' + userName + '/' + bookID,null);
  }
  
}
