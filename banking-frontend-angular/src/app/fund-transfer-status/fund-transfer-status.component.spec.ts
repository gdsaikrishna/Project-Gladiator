import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { FundTransferStatusComponent } from './fund-transfer-status.component';

describe('FundTransferStatusComponent', () => {
  let component: FundTransferStatusComponent;
  let fixture: ComponentFixture<FundTransferStatusComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ FundTransferStatusComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(FundTransferStatusComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
