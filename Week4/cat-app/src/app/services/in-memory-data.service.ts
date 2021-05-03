import { Injectable } from '@angular/core';
import { InMemoryDbService } from 'angular-in-memory-web-api';
import { Cat } from '../cat';
@Injectable({
  providedIn: 'root'
})
export class InMemoryDataService implements InMemoryDbService{


  constructor() { }

  createDb(){
    const cats = [
      { id: 11, name: 'ron' },
      { id: 12, name: 'fluffy' },
      { id: 13, name: 'tom' },
      { id: 14, name: 'rob' },
      { id: 15, name: 'tim' },
      { id: 16, name: 'finn' },
      { id: 17, name: 'ceasar' },
      { id: 18, name: 'Rodregous' },
      { id: 19, name: 'Puss in Boots' },
      { id: 20, name: 'Clancy' }
    ]

    return {cats};
  }

  getId(cats:Cat[]):number{
    return cats.length>0? Math.max(...cats.map(cat=>cat.id))  + 1   :  11;
  }
}
