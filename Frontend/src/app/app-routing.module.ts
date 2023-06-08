import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { BookAddComponent } from './components/book/book-add/book-add.component';
import { BookComponent } from './components/book/book.component';
import { BookshopComponent } from './components/bookshop/bookshop.component';

// routes are here
const routes: Routes = [
  { path: '', redirectTo: '/bookshop', pathMatch: 'full' },
  { path: 'book', component: BookComponent },
  { path: 'bookshop', component: BookshopComponent },
  { path: 'add-book', component: BookAddComponent },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule],
})
export class AppRoutingModule {}
