import { TestBed } from '@angular/core/testing';

import { GenerateOtpService } from './generate-otp.service';

describe('GenerateOtpService', () => {
  let service: GenerateOtpService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(GenerateOtpService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
