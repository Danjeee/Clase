import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { AlertService } from '../../services/alerts.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-sells',
  imports: [CommonModule],
  templateUrl: './admin-sells.component.html',
  styleUrl: './admin-sells.component.css'
})
export class AdminSellsComponent {

  constructor(private adminService: AdminService, private alert: AlertService) { }
  ventas: any[] = []
  ventas_aux: any
  filtrado = false
  ngOnInit(): void {
    this.adminService.getAllSells().subscribe({
      next: (data) => {
        this.ventas = data
        this.ventas_aux = data
      }
    })
  }
  filter(key: string, value?: any) {
    switch (key) {
      case 'F':
        this.filtrarporfecha(value)
        break;
      case 'V':
        this.filtrarporvendedor(value)
        break;
      case 'C':
        this.filtrarporcomprador(value)
        break;
      case 'R':
        this.ventas = this.ventas_aux
        this.filtrado = false
        break;
    }
  }
  filtrarporcomprador(value: any) {
    this.filtrado = true
    const aux: any[] = []
    this.ventas.forEach((e: any) => {
      if (e.comprador == value) {
        aux.push(e)
      }
    });
    this.ventas = aux;
  }
  filtrarporvendedor(value: any) {
    this.filtrado = true
    const aux: any[] = []
    this.ventas.forEach((e: any) => {
      if (e.socio == value) {
        aux.push(e)
      }
    });
    this.ventas = aux;
  }
  filtrarporfecha(value: any) {
    this.filtrado = true
    const aux: any[] = []
    this.ventas.forEach((e: any) => {
      if (e.fecha == value) {
        aux.push(e)
      }
    });
    this.ventas = aux;
  }
}
