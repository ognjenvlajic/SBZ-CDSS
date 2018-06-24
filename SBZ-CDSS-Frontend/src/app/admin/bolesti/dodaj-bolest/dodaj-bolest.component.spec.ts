import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { DodajBolestComponent } from './dodaj-bolest.component';

describe('DodajBolestComponent', () => {
  let component: DodajBolestComponent;
  let fixture: ComponentFixture<DodajBolestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ DodajBolestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(DodajBolestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
