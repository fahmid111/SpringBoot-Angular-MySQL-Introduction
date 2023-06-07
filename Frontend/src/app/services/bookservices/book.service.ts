import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Book } from '../../models/book';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  private bookApiUrl;

  constructor(private http: HttpClient) {
    this.bookApiUrl = 'http://localhost:8080/api/books';
  }

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookApiUrl);
  }

  public deleteBook(id: number): Observable<void> {
    const url = `${this.bookApiUrl}/${id}`;
    return this.http.delete<void>(url);
  }
}
