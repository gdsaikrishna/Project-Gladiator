import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { OpenAccComponent } from './open-acc.component';

describe('OpenAccComponent', () => {
  let component: OpenAccComponent;
  let fixture: ComponentFixture<OpenAccComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ OpenAccComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(OpenAccComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
