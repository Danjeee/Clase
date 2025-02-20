import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminUsergestComponent } from './admin-usergest.component';

describe('AdminUsergestComponent', () => {
  let component: AdminUsergestComponent;
  let fixture: ComponentFixture<AdminUsergestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminUsergestComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminUsergestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
