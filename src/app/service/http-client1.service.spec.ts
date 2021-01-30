import { TestBed } from '@angular/core/testing';

import { HttpClient1Service } from './http-client1.service';

describe('HttpClient1Service', () => {
  let service: HttpClient1Service;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(HttpClient1Service);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
