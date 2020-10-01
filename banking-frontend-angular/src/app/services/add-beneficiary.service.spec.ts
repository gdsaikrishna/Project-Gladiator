import { TestBed } from '@angular/core/testing';

import { AddBeneficiaryService } from './add-beneficiary.service';

describe('AddBeneficiaryService', () => {
  let service: AddBeneficiaryService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AddBeneficiaryService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
