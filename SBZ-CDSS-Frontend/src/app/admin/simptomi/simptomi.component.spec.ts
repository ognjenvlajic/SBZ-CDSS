import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { SimptomiComponent } from './simptomi.component';

describe('SimptomiComponent', () => {
  let component: SimptomiComponent;
  let fixture: ComponentFixture<SimptomiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ SimptomiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(SimptomiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
