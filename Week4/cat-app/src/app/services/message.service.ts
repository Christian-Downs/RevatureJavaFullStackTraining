import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class MessageService {

  messages: string[] = [];



  constructor() { }

  // this message adds a msg to our messages property ( which is a string array)
  add(msg: string) {
    this.messages.push(msg);
  }


  // this "clears our fake cache"
  clear() {
    this.messages = [];
  }


}
