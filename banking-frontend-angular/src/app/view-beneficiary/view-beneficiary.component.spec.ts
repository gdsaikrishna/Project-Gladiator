import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewBeneficiaryComponent } from './view-beneficiary.component';

describe('ViewBeneficiaryComponent', () => {
  let component: ViewBeneficiaryComponent;
  let fixture: ComponentFixture<ViewBeneficiaryComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ ViewBeneficiaryComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewBeneficiaryComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
