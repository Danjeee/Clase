import { ComponentFixture, TestBed } from '@angular/core/testing';

import { GaleriaArticulosComponent } from './galeria-articulos.component';

describe('GaleriaArticulosComponent', () => {
  let component: GaleriaArticulosComponent;
  let fixture: ComponentFixture<GaleriaArticulosComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [GaleriaArticulosComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(GaleriaArticulosComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
