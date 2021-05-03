import { ComponentFixture, fakeAsync, TestBed, tick } from '@angular/core/testing';
import { DebugElement } from '@angular/core';
import { AlertButtonComponent } from './alert-button.component';

describe('AlertButtonComponent', () => {
  let component: AlertButtonComponent;
  let fixture: ComponentFixture<AlertButtonComponent>;
  let de:DebugElement; // Debug element helps us test elements within HTML tree

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ AlertButtonComponent ] // this is configuring our test bed
    })
    .compileComponents(); // this generates the css and html files associates with the class
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(AlertButtonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
    de = fixture.debugElement;
  });

  // tjos spec checks that it can be instantiated
  it('should create', () => {
    expect(component).toBeTruthy();
  });

  // it should have a message containing the word "warn"
  it("should have a message containing the word 'warn'", () => {
    expect(component.content).toContain('warn');
  });

  //it should have a message that is exactly equal to 'you have been warned'
  it("should have a message that is exactly equal to 'you have been warned'", () =>{
    expect(component.content).toEqual('you have been warned');

  });

  //it should have a security level greater than 100

  it("should have a security level greater than 100",()=>{
    expect(component.severity).toBeGreaterThan(100);
  });

  it("should toggle the message boolean", () => {
    expect(component.hideContent).toBeTruthy();
    component.toggle();
    expect(component.hideContent).toBeFalsy();
  });

  it("should toggle the message boolean but with async", fakeAsync(() =>{
    expect(component.hideContent).toBeTruthy();
    component.toggleAsync();
    tick(500);
    expect(component.hideContent).toBeFalsy();
  }));
});
