import { TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { CatsComponent } from './cats.component';

describe('CatsComponent', () => {
    beforeEach(async () => {
        await TestBed.configureTestingModule({
            imports: [
                RouterTestingModule
            ],
            declarations: [
                CatsComponent
            ],
        }).compileComponents();
    });

    it('should create the app', () => {
        const fixture = TestBed.createComponent(CatsComponent);
        const app = fixture.componentInstance;
        expect(app).toBeTruthy();
    });

    it(`should have as title 'cat-app'`, () => {
        const fixture = TestBed.createComponent(CatsComponent);
        const app = fixture.componentInstance;
        expect(app.title).toEqual('cat-app');
    });

    it('should render title', () => {
        const fixture = TestBed.createComponent(CatsComponent);
        fixture.detectChanges();
        const compiled = fixture.nativeElement;
        expect(compiled.querySelector('.content span').textContent).toContain('cat-app app is running!');
    });
});