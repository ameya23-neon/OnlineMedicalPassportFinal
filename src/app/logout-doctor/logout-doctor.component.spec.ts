import { ComponentFixture, TestBed } from '@angular/core/testing';

import { LogoutDoctorComponent } from './logout-doctor.component';

describe('LogoutDoctorComponent', () => {
  let component: LogoutDoctorComponent;
  let fixture: ComponentFixture<LogoutDoctorComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ LogoutDoctorComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(LogoutDoctorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
