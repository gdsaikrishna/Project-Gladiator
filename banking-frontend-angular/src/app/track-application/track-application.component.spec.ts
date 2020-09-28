import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { TrackApplicationComponent } from './track-application.component';

describe('TrackApplicationComponent', () => {
  let component: TrackApplicationComponent;
  let fixture: ComponentFixture<TrackApplicationComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ TrackApplicationComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(TrackApplicationComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
