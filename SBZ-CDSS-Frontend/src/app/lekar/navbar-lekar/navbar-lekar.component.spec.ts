import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { NavbarLekarComponent } from './navbar-lekar.component';

describe('NavbarLekarComponent', () => {
  let component: NavbarLekarComponent;
  let fixture: ComponentFixture<NavbarLekarComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ NavbarLekarComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(NavbarLekarComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
