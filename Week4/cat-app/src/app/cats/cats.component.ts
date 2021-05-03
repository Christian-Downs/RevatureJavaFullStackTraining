import { Component, OnInit } from '@angular/core';
import { Cat } from '../cat';
import { CATS } from '../mock-cats';
import { CatService } from '../services/cat.service';
import { MessageService } from '../services/message.service';


@Component({
    selector: 'cats-root',
    templateUrl: './cats.component.html',
    styleUrls: ['./cats.component.css']
})
export class CatsComponent implements OnInit{
    allCats: Cat[] = [];

    selectedCat?:Cat;

    title = 'The Ultimate Cat App';

    constructor(private CatService: CatService, private messageService: MessageService) { }
    //
    ngOnInit(): void {
        this.getAllCats();
    }

    onSelect(cat:Cat): void {
        this.selectedCat= cat;
        this.messageService.add(`CatsComponent: You selected cat ${cat.name} with the id: ${cat.id}`);
    }

    getAllCats(): void {
        this.CatService.getCats().subscribe(retrievedCats => this.allCats = retrievedCats);
        
        
        //this.cats = this.CatService.getCats();
    }

    add(name:string){

        name = name.trim();
        if(!name){return;}

        this.CatService.addCat({name} as Cat).subscribe(cat=>{
            this.allCats.push(cat);
        });
    }

    delete(cat:Cat):void{
        this.allCats = this.allCats.filter(c=>c!== cat);

        this.CatService.deleteCat(cat).subscribe();
    }
}
