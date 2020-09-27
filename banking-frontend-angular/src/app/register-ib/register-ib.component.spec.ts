import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterIbComponent } from './register-ib.component';

describe('RegisterIbComponent', () => {
  let component: RegisterIbComponent;
  let fixture: ComponentFixture<RegisterIbComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RegisterIbComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RegisterIbComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
