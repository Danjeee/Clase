import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminSellsComponent } from './admin-sells.component';

describe('AdminSellsComponent', () => {
  let component: AdminSellsComponent;
  let fixture: ComponentFixture<AdminSellsComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminSellsComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminSellsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
