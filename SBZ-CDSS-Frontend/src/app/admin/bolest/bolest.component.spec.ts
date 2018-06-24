import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BolestComponent } from './bolest.component';

describe('BolestComponent', () => {
  let component: BolestComponent;
  let fixture: ComponentFixture<BolestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BolestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BolestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
