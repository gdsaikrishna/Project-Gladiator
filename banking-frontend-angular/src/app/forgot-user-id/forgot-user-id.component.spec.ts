import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ForgotUserIdComponent } from './forgot-user-id.component';

describe('ForgotUserIdComponent', () => {
  let component: ForgotUserIdComponent;
  let fixture: ComponentFixture<ForgotUserIdComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ForgotUserIdComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ForgotUserIdComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
