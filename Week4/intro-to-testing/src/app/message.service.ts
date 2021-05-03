import { Injectable } from '@angular/core';
import { AngularFireDatabase } from 'angularfire2/database';
import { Observable } from 'rxjs';
@Injectable({
  providedIn: 'root'
})
export class MessageService {

  constructor(private db: AngularFireDatabase) { }

  getContent(): Observable<any> {
    const ref = this.db.object('alerts/testAlert');
    return ref.valueChanges();
  }

}
