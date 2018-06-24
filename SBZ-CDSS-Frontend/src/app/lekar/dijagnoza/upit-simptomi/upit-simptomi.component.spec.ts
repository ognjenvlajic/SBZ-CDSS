import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpitSimptomiComponent } from './upit-simptomi.component';

describe('UpitSimptomiComponent', () => {
  let component: UpitSimptomiComponent;
  let fixture: ComponentFixture<UpitSimptomiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpitSimptomiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpitSimptomiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
