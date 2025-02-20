import { TestBed } from '@angular/core/testing';

import { SocioService } from './socios.service';

describe('SocioService', () => {
  let service: SocioService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SocioService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
