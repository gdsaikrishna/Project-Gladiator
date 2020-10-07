import { TestBed } from '@angular/core/testing';

import { ForgotUserIdService } from './forgot-user-id.service';

describe('ForgotUserIdService', () => {
  let service: ForgotUserIdService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ForgotUserIdService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
