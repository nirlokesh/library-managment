import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {MatCardModule} from '@angular/material/card';
import { HttpClientModule } from '@angular/common/http';

import { AppComponent } from './app.component';
import { BookdetailsComponent } from './book-details/bookdetails/bookdetails.component';
import { BorrowListComponent } from './borrowlist/borrow-list/borrow-list.component';
import { LoginComponent } from './login/login/login.component';
import { FormsModule } from '@angular/forms';
 

@NgModule({
  declarations: [
    AppComponent,
    BookdetailsComponent,
    BorrowListComponent,
    LoginComponent,
  ],
  imports: [
    BrowserModule,MatCardModule,HttpClientModule,FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
