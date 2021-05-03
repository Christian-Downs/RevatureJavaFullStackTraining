import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { Hero } from 'src/app/models/hero.model';
import { HeroService } from 'src/app/services/hero.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent{

  title = 'Register Hero';

  constructor(private heroService: HeroService) { }

  public hero: Hero = new Hero(0, '', '', false);

  public message:ClientMessage = new ClientMessage("");


  public registerHero(): void {
    this.heroService.registerHero(this.hero).subscribe(data => this.message = data ,error => this.message.message = 'SOMETHING WENT WRONG!');
  }

}
