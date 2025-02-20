import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AdminArtGestComponent } from './admin-art-gest.component';

describe('AdminArtGestComponent', () => {
  let component: AdminArtGestComponent;
  let fixture: ComponentFixture<AdminArtGestComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [AdminArtGestComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(AdminArtGestComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
