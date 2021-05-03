import { Component, OnInit } from '@angular/core';
import { from } from 'rxjs';
import { Dog } from '../dog';

@Component({
  selector: 'app-dogs',
  templateUrl: './dogs.component.html',
  styleUrls: ['./dogs.component.css']
})
export class DogsComponent implements OnInit {

  dog: Dog = {
    id:1,
    name: 'Winston'
  };

  constructor() { }

  ngOnInit(): void {
  }

}
