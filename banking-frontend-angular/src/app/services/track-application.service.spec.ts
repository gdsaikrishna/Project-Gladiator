import { TestBed } from '@angular/core/testing';

import { TrackApplicationService } from './track-application.service';

describe('TrackApplicationService', () => {
  let service: TrackApplicationService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(TrackApplicationService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
