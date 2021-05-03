import { Injectable } from '@angular/core';
import { ClientMessage } from './../models/client-message.model';
import { Hero } from './../models/hero.model';
import { Observable, of } from 'rxjs';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError } from 'rxjs/operators';
import { environment, HERO_URL } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class HeroService {

  httpOptions = {
    headers: new HttpHeaders({'Content-Type':'application/json'})
  }

  constructor(private http: HttpClient) { }

  public registerHero(hero:Hero): Observable<ClientMessage> {
    return this.http.post<ClientMessage>(`${HERO_URL}register`,hero).pipe(catchError(this.handleError<any>(`cannot register hero!`)))
  }

  public findHero(hero: Hero): Observable<Hero> {
    return this.http.post<Hero>(`${HERO_URL}findHero`,hero, this.httpOptions)
            .pipe(
              catchError(this.handleError<Hero>('getHeroes',undefined))
            );
  }

  public allHeroes(): Observable<Hero[]> {
    return this.http.get<Hero[]>(`${HERO_URL}findAllHeroes`)
      .pipe(
        catchError(this.handleError<Hero[]>('getHeroes',[]))
      );
  }

  private handleError<T>(operation = 'operation',result?:T){
    return (error:any): Observable<T> => {
      console.error(error);

      return of(result as T);
      
    }
  }

}
