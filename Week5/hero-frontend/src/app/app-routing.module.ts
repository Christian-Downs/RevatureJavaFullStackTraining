import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { AllComponent } from './componencts/all/all.component';
import { FindComponent } from './componencts/find/find.component';
import { MainComponent } from './componencts/main/main.component';
import { RegisterComponent } from './componencts/register/register.component';

const routes: Routes = [
  {path:'',redirectTo:'main', pathMatch: 'full'},
  {path:'main', component: MainComponent},
  {path:'all', component: AllComponent},
  {path:'find', component: FindComponent},
  {path:'register', component:RegisterComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
