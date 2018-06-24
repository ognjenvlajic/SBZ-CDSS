import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { BolestiComponent } from './bolesti.component';

describe('BolestiComponent', () => {
  let component: BolestiComponent;
  let fixture: ComponentFixture<BolestiComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ BolestiComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(BolestiComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
