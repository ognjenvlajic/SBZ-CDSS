import { TestBed, inject } from '@angular/core/testing';

import { LekarService } from './lekar.service';

describe('LekarService', () => {
  beforeEach(() => {
    TestBed.configureTestingModule({
      providers: [LekarService]
    });
  });

  it('should be created', inject([LekarService], (service: LekarService) => {
    expect(service).toBeTruthy();
  }));
});
