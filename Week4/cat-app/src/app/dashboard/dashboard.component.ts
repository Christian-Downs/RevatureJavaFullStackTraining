import { Component, OnInit } from '@angular/core';
import { Cat } from '../cat';
import { CatService } from '../services/cat.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {
  topCats: Cat[] = [];


  constructor(private CatService: CatService) { }

  ngOnInit(): void {
    this.getTopCats();
  }


  getTopCats(): void{
   this.CatService.getCats().subscribe(allCats => this.topCats = allCats.slice(0,4)); 
  }
}
