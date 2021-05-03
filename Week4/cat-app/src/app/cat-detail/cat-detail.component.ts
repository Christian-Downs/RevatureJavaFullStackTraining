import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Cat } from '../cat';
import { CatService } from '../services/cat.service';
import { MessageService } from '../services/message.service';
import { Location } from '@angular/common';

@Component({
  selector: 'app-cat-detail',
  templateUrl: './cat-detail.component.html',
  styleUrls: ['./cat-detail.component.css']
})
export class CatDetailComponent implements OnInit {
  cat?:Cat;
  allCats: Cat[] = [];

  constructor(
    private catService:CatService,
    private route:ActivatedRoute,
    private location: Location,
    private messageService:MessageService
  ) { }

  ngOnInit(): void{
    this.getCat();
  }

  getCat():  void {
    const id = Number(this.route.snapshot.paramMap.get('id'));
    this.catService.getCat(id).subscribe(cat=>this.cat =cat);
  }

  save() {
    this.catService.updateCat(this.cat).subscribe(()=> this.goBack());
  }

  goBack() {
    // we'll use the location
    this.location.back();
  }
}
