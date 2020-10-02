import { TestBed } from '@angular/core/testing';

import { ViewBeneficiaryService } from './view-beneficiary.service';

describe('ViewBeneficiaryService', () => {
  let service: ViewBeneficiaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ViewBeneficiaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
