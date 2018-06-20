import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PregledLekaraComponent } from './pregled-lekara.component';

describe('PregledLekaraComponent', () => {
  let component: PregledLekaraComponent;
  let fixture: ComponentFixture<PregledLekaraComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PregledLekaraComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PregledLekaraComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
