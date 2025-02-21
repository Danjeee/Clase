import { Component } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { AlertService } from '../../services/alerts.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-admin-art-gest',
  imports: [CommonModule],
  templateUrl: './admin-art-gest.component.html',
  styleUrl: './admin-art-gest.component.css'
})
export class AdminArtGestComponent {


  constructor(private adminService: AdminService, private alert: AlertService) { }
  articulos: any[] = []
  articulos_aux: any[] = []
  articulos_all: any[] = []
  categorias: any
  vendedores: any
  filtrado = false
  ngOnInit(): void {
    this.adminService.getAllArts().subscribe({
      next: (data) => {
        this.articulos = data
        this.articulos_all = data
        this.articulos_aux = data
      }
    })
    this.adminService.getAllCats().subscribe({
      next: (data) => {
        this.categorias = data
      }
    })
    this.adminService.getAllSocios().subscribe({
      next: (data) => {
        this.vendedores = data
      }
    })
  }
  toggleFilter(filtro: string) {
    const botones = document.getElementById("botones")?.childNodes as NodeListOf<HTMLElement>
    const button = document.getElementById(filtro) as HTMLElement
    botones.forEach(e => {
      if (e.classList.contains('active')) {
        e.classList.remove('active')
      }
    });
    button.classList.add('active')
    const txt = document.getElementById("txt") as HTMLElement
    this.filtrado = false
    switch (filtro) {
      case 'todos':
        txt.innerHTML = "Todos los articulos"
        this.articulos = this.articulos_all
        break;
      case 'venta':
        txt.innerHTML = "Articulos en venta"
        this.articulos_aux = []
        this.articulos_all.forEach(e => {
          if (e.estado == 'D') {
            this.articulos_aux.push(e)
          }
        });
        this.articulos = this.articulos_aux
        break;
      case 'vendidos':
        txt.innerHTML = "Articulos vendidos"
        this.articulos_aux = []
        this.articulos_all.forEach(e => {
          if (e.estado == 'V') {
            this.articulos_aux.push(e)
          }
        });
        this.articulos = this.articulos_aux
        break;
      case 'bloqueados':
        txt.innerHTML = "Articulos bloqueados"
        this.articulos_aux = []
        this.articulos_all.forEach(e => {
          if (e.estado == 'B') {
            this.articulos_aux.push(e)
          }
        });
        this.articulos = this.articulos_aux
        break;
    }
  }
  getVendedor(idCat: any): string {
    var out = ""
    this.vendedores.forEach((e: any) => {
      if (e.id == idCat) {
        out = e.nombre + " " + e.apellidos;
      }
    });
    return out;
  }
  getCategoria(idCat: any): string {
    var out = ""
    this.categorias.forEach((e: any) => {
      if (e.id == idCat) {
        out = e.nombre;
      }
    });
    return out;
  }
  deleteArt(idArt: any) {
    this.adminService.deleteArt(idArt).subscribe({
      next: (data) => {
        if (data.ok) {
          this.alert.success("Hecho", "Articulo deshabilitado correctamente", true)
        }
      }
    })
  }
  enableArt(idArt: any) {
    this.adminService.enableArt(idArt).subscribe({
      next: (data) => {
        if (data.ok) {
          this.alert.success("Hecho", "Articulo habilitado correctamente", true)
        }
      }
    })
  }
  doubleFilter(key: string, value?: any) {
      var aux: any[] = []

      this.articulos = this.articulos_aux
      this.filtrado = true
      switch(key){
        case 'C':
          this.articulos.forEach(e => {
            if (e.categoria == value) {
              aux.push(e)
            }
          });
          this.articulos = aux
          break;
        case 'V':
          this.articulos.forEach(e => {
            if (e.vendedor == value) {
              aux.push(e)
            }
          });
          this.articulos = aux
          break;
        case 'R':
          this.articulos = this.articulos_aux
          this.filtrado = false
          break;
      }
    }
}
