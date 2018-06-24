import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledBolestiComponent } from './pregled-bolesti.component';

describe('PregledBolestiComponent', () => {
  let component: PregledBolestiComponent;
  let fixture: ComponentFixture<PregledBolestiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PregledBolestiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PregledBolestiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
