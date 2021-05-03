import { Injectable } from '@angular/core';
import { Cat } from '../cat';
import { CATS } from './../mock-cats';
import { Observable, of } from 'rxjs';
import { LoggerService } from './logger.service';
import { MessageService } from './message.service';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError,map,tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class CatService {
  private catsUrl = 'api/cats';
  constructor(private logger: LoggerService,
     private messageService: MessageService,
     private http: HttpClient) { }

  private log(message: string){
    this.messageService.add(`CatService: ${message}`);
  }

  getCats(): Observable<Cat[]>{
    return this.http.get<Cat[]>(this.catsUrl)
    .pipe(
      //tap allows us to do somehting with the vaules we receive without changing them
      tap(_=>this.log(`fetch cats!`)),
      catchError(this.handleError<Cat[]>('getCats method',[]))
    );

    //old way
    // const cats = of(CATS);

    // cats.subscribe(catArray => {
    // this.logger.log(`We returned ${catArray.length} cats inside the CatService`);
    // });

  // this.messageService.add("in CatService: cats have been fetched for sure.....");
  //   return cats;
  }

  getCat(id:number): Observable<Cat | undefined> {
      this.messageService.add(`CatService: fetched cat with id ${id}`);

      const specificUrl = `${this.catsUrl}/${id}`;
      return this.http.get<Cat>(specificUrl)
        .pipe(
          tap(_=>this.log(`fetchedcat with id = ${id}`)),
          catchError(this.handleError<Cat>(`getCat id =${id}`))
        )
      // return of(CATS.find(cat => cat.id===id));
  }

  private handleError<T>(operation = 'operation',result?:T){
    return (error:any):Observable<T> => {
      // send the error to a remote logging infrasturce
      console.error(error);
      this.log(`${operation} failed: ${error.message}`);


      // we want to ensure that the app keeps running by returning an empyt result

      return of(result as T);
    }
  }

  updateCat(cat?:Cat): Observable<any>{
    
    return this.http.put(this.catsUrl,cat)
      .pipe(
        tap(_=>this.log(`updated cat id = ${cat?.id}`)),
        catchError(this.handleError<any>('updateCat'))
        );

  }
  
  addCat(cat:Cat):Observable<any>{

    return this.http.post(this.catsUrl,cat)
      .pipe(
        tap(_=>this.log(`added cat id = ${cat?.id}`)),
        catchError(this.handleError<any>('addCat'))
      );
  }

  deleteCat(cat:Cat|number):Observable<Cat>{
    // here we arre checking did we pass in a number (id)? or a Cat?
    const id = typeof cat ==='number'?cat:cat.id;
    const url = `${this.catsUrl}/${id}`;

    return this.http.delete<Cat>(url)
    .pipe(tap(_=>this.log(`deleted cat by id - ${id}`)),
      catchError(this.handleError<any>('deleteCat')));
  }

  searchTerm(term:string): Observable<Cat[]>{
    if(!term.trim()){return of([])};
    return this.http.get<Cat[]>(`${this.catsUrl}/?name=${term}`)
  }
}