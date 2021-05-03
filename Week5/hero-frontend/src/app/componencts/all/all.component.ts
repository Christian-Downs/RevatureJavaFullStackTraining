import { Component, OnInit } from '@angular/core';
import { ClientMessage } from 'src/app/models/client-message.model';
import { Hero } from 'src/app/models/hero.model';
import { HeroService } from 'src/app/services/hero.service';

@Component({
  selector: 'app-all',
  templateUrl: './all.component.html',
  styleUrls: ['./all.component.css']
})
export class AllComponent implements OnInit {

  title = "All Heroes";
  public heroes: Hero[] = [];
  public clientMessage: ClientMessage = new ClientMessage('sorry, no heroes to display');

  constructor(private heroService: HeroService) { }

  ngOnInit(): void {
    this.findAllHeroes();
  }


  public findAllHeroes(): void {
    this.heroService.allHeroes().subscribe(data => this.heroes = data);
  }

}
