import { Component, OnInit } from '@angular/core';
import { Bookshop } from '../../../models/bookshop';
import { BookshopService } from '../../../services/bookshopservices/bookshop.service';

@Component({
  selector: 'app-bookshoplist',
  templateUrl: './bookshop-list.component.html',
  styleUrls: ['./bookshop-list.component.css'],
})
export class BookshopListComponent implements OnInit {
  bookshops: Bookshop[] = [];
  bookshopToView!: Bookshop;
  constructor(private bookshopService: BookshopService) {}

  ngOnInit(): void {
    this.fetchBookshops();
  }

  fetchBookshops(): void {
    this.bookshopService.getBookshops().subscribe(
      (response: Bookshop[]) => {
        this.bookshops = response;
        console.log(this.bookshops);
      },
      (error) => {
        console.error('Error fetching bookshops:', error);
      }
    );
  }

  deleteBookshop(id: number): void {
    this.bookshopService.deleteBookshop(id).subscribe(
      () => {
        console.log('Bookshop deleted successfully');
        // Refresh the bookshop list after deletion
        this.fetchBookshops();
      },
      (error) => {
        console.error('Error deleting bookshop:', error);
      }
    );
  }

  viewBookshop(id: number): void {
    this.bookshopService.viewBookshop(id).subscribe(
      (response: Bookshop) => {
        this.bookshopToView = response;
        console.log('Bookshop viewed successfully');
        console.log(this.bookshopToView);
      },
      (error) => {
        console.error('Error viewing bookshop:', error);
      }
    );
  }
}
