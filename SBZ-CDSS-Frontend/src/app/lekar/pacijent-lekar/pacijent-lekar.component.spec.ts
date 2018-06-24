import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { PacijentLekarComponent } from './pacijent-lekar.component';

describe('PacijentLekarComponent', () => {
  let component: PacijentLekarComponent;
  let fixture: ComponentFixture<PacijentLekarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ PacijentLekarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(PacijentLekarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
