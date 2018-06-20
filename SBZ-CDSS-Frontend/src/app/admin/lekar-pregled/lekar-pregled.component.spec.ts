import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LekarPregledComponent } from './lekar-pregled.component';

describe('LekarPregledComponent', () => {
  let component: LekarPregledComponent;
  let fixture: ComponentFixture<LekarPregledComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LekarPregledComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LekarPregledComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
