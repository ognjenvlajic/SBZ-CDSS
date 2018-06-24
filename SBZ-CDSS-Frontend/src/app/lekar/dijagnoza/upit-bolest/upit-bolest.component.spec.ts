import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { UpitBolestComponent } from './upit-bolest.component';

describe('UpitBolestComponent', () => {
  let component: UpitBolestComponent;
  let fixture: ComponentFixture<UpitBolestComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ UpitBolestComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(UpitBolestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
