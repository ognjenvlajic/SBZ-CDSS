import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajLekaraComponent } from './dodaj-lekara.component';

describe('DodajLekaraComponent', () => {
  let component: DodajLekaraComponent;
  let fixture: ComponentFixture<DodajLekaraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajLekaraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajLekaraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
