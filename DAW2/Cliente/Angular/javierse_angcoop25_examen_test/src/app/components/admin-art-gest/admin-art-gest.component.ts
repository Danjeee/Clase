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
  constructor (private adminService: AdminService, private alert: AlertService){}
    articulos: any
    ngOnInit(): void {
      this.adminService.getAllArts().subscribe({
        next: (data) => {
          this.articulos = data
        }
      })
    }
    deleteArt(idArt: any) {
      this.adminService.deleteArt(idArt).subscribe({
        next: (data) => {
          if (data.ok) {
            this.alert.confirm("Hecho", "Articulo deshabilitado correctamente").then(()=>{window.location.reload()})
          }
        }
      })
    }
    enableArt(idArt: any) {
      this.adminService.enableArt(idArt).subscribe({
        next: (data) => {
          if (data.ok) {
            this.alert.confirm("Hecho", "Articulo habilitado correctamente").then(()=>{window.location.reload()})
          }
        }
      })
    }
    substring(string: string): string{
      return string.substring(0,40)
    }
}
