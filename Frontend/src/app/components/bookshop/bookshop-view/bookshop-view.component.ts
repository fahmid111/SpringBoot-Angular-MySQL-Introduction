import { Component, Input } from '@angular/core';
import { Bookshop } from '../../../models/bookshop';
import { BookService } from '../../../services/bookservices/book.service';
import { BookshopService } from '../../../services/bookshopservices/bookshop.service';

@Component({
  selector: 'app-bookshop-view',
  templateUrl: './bookshop-view.component.html',
  styleUrls: ['./bookshop-view.component.css'],
})
export class BookshopViewComponent {
  @Input() bookshop!: Bookshop;
  constructor(
    private bookService: BookService,
    private bookshopService: BookshopService
  ) {}

  deleteBook(id: number): void {
    this.bookService.deleteBook(id).subscribe(
      () => {
        console.log('Book deleted successfully');
        this.bookshopService
          .viewBookshop(id)
          .subscribe((response: Bookshop) => {
            this.bookshop = response;
            console.log('Bookshop viewed successfully');
          });
      },
      (error) => {
        console.error('Error deleting book:', error);
      }
    );
  }
}
