import { Component, OnInit } from '@angular/core';
import { from, Observable, Subject } from 'rxjs';
import { Cat } from '../cat';
import { CatService } from './../services/cat.service'
import { debounceTime, distinctUntilChanged, switchMap } from 'rxjs/operators';
@Component({
  selector: 'app-cat-search',
  templateUrl: './cat-search.component.html',
  styleUrls: ['./cat-search.component.css']
})
export class CatSearchComponent implements OnInit {

 constructor(private catService:CatService) { }

  ngOnInit(): void {

    //1. set our cats$ obserable - to our search terms
    this.cats$ = this.searchTerms.pipe(
      debounceTime(300),
      distinctUntilChanged(),
      switchMap((term:string) => this.catService.searchTerm(term)),
    );
  }
  
  cats$: Observable<Cat[]>;
  private searchTerms = new Subject<string>();

  /**Search Terms */
  search(term:string){
    this.searchTerms.next(term);
  }
}
