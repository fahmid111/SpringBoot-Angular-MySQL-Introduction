import { HttpClient, HttpParams } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Bookshop } from '../../models/bookshop';

@Injectable({
  providedIn: 'root',
})
export class BookshopService {
  private bookshopApiUrl: string;

  constructor(private http: HttpClient) {
    this.bookshopApiUrl = 'http://localhost:8080/api/bookshops';
  }

  public getBookshops(): Observable<Bookshop[]> {
    return this.http.get<Bookshop[]>(this.bookshopApiUrl);
  }

  public deleteBookshop(id: number): Observable<void> {
    const url = `${this.bookshopApiUrl}/${id}`;
    return this.http.delete<void>(url);
  }

  public viewBookshop(id: number): Observable<Bookshop> {
    const url = `${this.bookshopApiUrl}/${id}`;
    return this.http.get<Bookshop>(url);
  }

  public addBookToBookshop(
    bookshop_id: number,
    book_id: number
  ): Observable<any> {
    const url = `${this.bookshopApiUrl}/addBook`;

    let queryParams = new HttpParams();
    queryParams = queryParams.append('bookshop_id', String(bookshop_id));
    queryParams = queryParams.append('book_id', String(book_id));

    return this.http.put(url, null, { params: queryParams });
  }
}
