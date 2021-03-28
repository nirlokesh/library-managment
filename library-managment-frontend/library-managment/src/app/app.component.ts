import { Component } from '@angular/core';
import { LibraryService } from './services/library.service';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})

export class AppComponent {
  title = 'library-managment';
  showLibrary : boolean = true;
  constructor(public libraryService : LibraryService){  }


}
