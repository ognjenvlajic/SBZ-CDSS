import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RezonerComponent } from './rezoner.component';

describe('RezonerComponent', () => {
  let component: RezonerComponent;
  let fixture: ComponentFixture<RezonerComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RezonerComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RezonerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
