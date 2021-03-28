import { Component, OnInit } from '@angular/core';
import { LibraryService } from 'src/app/services/library.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
  userName: string;
  password: string;
  invalidLogin: boolean;
  constructor(private service: LibraryService) { }

  ngOnInit(): void {

  }

  login() {
    if (this.userName === 'hexad' && this.password === 'hexad') {
      this.service.userName = this.userName;
      this.invalidLogin = false;
    } else {
      this.invalidLogin = true;
    }

  }

}
