import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { Hero } from 'src/app/models/hero.model';
import { HeroService } from 'src/app/services/hero.service';

@Component({
  selector: 'app-find',
  templateUrl: './find.component.html',
  styleUrls: ['./find.component.css']
})
export class FindComponent {

  title = "Find Hero";

  public hero: Hero = new Hero(0,'','',false);

  public recievedHero: Hero = new Hero(0,'','',false);

  public clientMessage: ClientMessage = new ClientMessage('');

  constructor(private heroService: HeroService) { }

  public findHero(): void {
    this.heroService.findHero(this.hero).subscribe(data => this.recievedHero= data,error => this.clientMessage.message = 'Something went wrong');
  }


}
