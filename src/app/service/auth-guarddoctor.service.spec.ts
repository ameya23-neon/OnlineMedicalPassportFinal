import { TestBed } from '@angular/core/testing';

import { AuthGuarddoctorService } from './auth-guarddoctor.service';

describe('AuthGuarddoctorService', () => {
  let service: AuthGuarddoctorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(AuthGuarddoctorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
