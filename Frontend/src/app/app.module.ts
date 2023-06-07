import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppComponent } from './app.component';
import { BookComponent } from './components/book/book.component';
import { ListComponent } from './components/book/list/list.component';
import { BookService } from './services/bookservices/book.service';

@NgModule({
  declarations: [AppComponent, BookComponent, ListComponent],
  imports: [BrowserModule, HttpClientModule],
  providers: [BookService],
  bootstrap: [AppComponent],
})
export class AppModule {}
