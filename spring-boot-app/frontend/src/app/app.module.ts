import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ItemService } from './shared/item/item.service';
import { HttpClientModule } from '@angular/common/http';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';
import {MatFormFieldModule} from '@angular/material/form-field';
import { CUSTOM_ELEMENTS_SCHEMA } from '@angular/core';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { FormsModule } from '@angular/forms';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { ItemListComponent } from './item-list/item-list.component';
import { ItemAddComponent } from './item-add/item-add.component';
import { ItemDetailsComponent } from './item-details/item-details.component';

const appRoutes: Routes = [
  { path: '', redirectTo: '/item-list', pathMatch: 'full' },
  {
    path: 'item-list',
    component: ItemListComponent
  },
  {
    path: 'item-add',
    component: ItemAddComponent
  },
  {
 	 path: 'items/:id/details',
    component: ItemDetailsComponent
      }
];



@NgModule({
  declarations: [
    AppComponent,
    ItemListComponent,
    ItemAddComponent,
    ItemDetailsComponent
      ],
  imports: [
  FormsModule,
    RouterModule.forRoot(appRoutes),
    BrowserModule,
    HttpClientModule,
    BrowserModule,
    HttpClientModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatCardModule,
    MatInputModule,
    MatListModule,
    MatToolbarModule,
    MatFormFieldModule
  ],
  providers: [ItemService],
  bootstrap: [AppComponent],
     schemas: [CUSTOM_ELEMENTS_SCHEMA]

})
export class AppModule { }
