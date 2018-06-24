import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { LicnaDijagnozaComponent } from './licna-dijagnoza.component';

describe('LicnaDijagnozaComponent', () => {
  let component: LicnaDijagnozaComponent;
  let fixture: ComponentFixture<LicnaDijagnozaComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ LicnaDijagnozaComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(LicnaDijagnozaComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
