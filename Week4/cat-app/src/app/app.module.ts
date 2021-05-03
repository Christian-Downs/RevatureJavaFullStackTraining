import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CatsComponent } from './cats/cats.component';
import { DogsComponent } from './dogs/dogs.component';
import { FormsModule } from '@angular/forms';
import { CatDetailComponent } from './cat-detail/cat-detail.component';
import { MessagesComponent } from './messages/messages.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { HttpClientModule } from '@angular/common/http';
import { InMemoryDataService } from './services/in-memory-data.service';
import { HttpClientInMemoryWebApiModule } from 'angular-in-memory-web-api';
import { CatSearchComponent } from './cat-search/cat-search.component';
@NgModule({
  declarations: [
    AppComponent,
    CatsComponent,
    DogsComponent,
    CatDetailComponent,
    MessagesComponent,
    DashboardComponent,
    CatSearchComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    HttpClientInMemoryWebApiModule.forRoot(
      InMemoryDataService, { dataEncapsulation: false}
    )
    // InMemoryDataService
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
