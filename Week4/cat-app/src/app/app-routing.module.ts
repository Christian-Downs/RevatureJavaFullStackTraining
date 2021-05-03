import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CatDetailComponent } from './cat-detail/cat-detail.component';
import { CatsComponent } from './cats/cats.component';
import { DashboardComponent } from './dashboard/dashboard.component';

const routes: Routes = [
  { path: 'everySingleCat',component: CatsComponent}, //localhost:4200/cats --> display my CatsComponent
  // {path: '', component:CatsComponent},
  {path:'dashboard', component:DashboardComponent},
  // {path:'**', component:CatsComponent}
  { path: 'detail/:id', component: CatDetailComponent },
  { path: '', redirectTo: '/dashboard', pathMatch: 'full' },


  // this is a wildcard path that allows us to catch garbage endpoint
  { path: '**', redirectTo: '/dashboard' }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule] // the exports keyword makes this RouterModule public and accessible throughout the app
})
export class AppRoutingModule { }
