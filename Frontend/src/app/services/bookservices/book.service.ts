import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { switchMap } from 'rxjs/operators';
import { Book } from '../../models/book';
import { BookshopService } from '../bookshopservices/bookshop.service';

@Injectable({
  providedIn: 'root',
})
export class BookService {
  private bookApiUrl;

  constructor(
    private http: HttpClient,
    private bookshopService: BookshopService
  ) {
    this.bookApiUrl = 'http://localhost:8080/api/books';
  }

  public getBooks(): Observable<Book[]> {
    return this.http.get<Book[]>(this.bookApiUrl);
  }

  public deleteBook(id: number): Observable<void> {
    const url = `${this.bookApiUrl}/${id}`;
    return this.http.delete<void>(url);
  }

  public addBook(bookData: any): Observable<any> {
    const { bookshop, ...bookDetails } = bookData;
    const bookArr: Book[] = [bookData];
    return this.http.post<any>(this.bookApiUrl, bookArr).pipe(
      switchMap((response) => {
        const bookId = response[0].id;
        return this.bookshopService.addBookToBookshop(bookshop, bookId);
      })
    );
  }
}
