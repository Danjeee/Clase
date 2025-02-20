import { Component, OnInit } from '@angular/core';
import { AdminService } from '../../services/admin.service';
import { CommonModule } from '@angular/common';
import Swal from 'sweetalert2';
import { AlertService } from '../../services/alerts.service';

@Component({
  selector: 'app-admin-usergest',
  imports: [CommonModule],
  templateUrl: './admin-usergest.component.html',
  styleUrl: './admin-usergest.component.css'
})
export class AdminUsergestComponent implements OnInit{


  constructor (private adminService: AdminService, private alert: AlertService){}
  users: any
  ngOnInit(): void {
    this.adminService.getAllSocios().subscribe({
      next: (data) => {
        this.users = data
      }
    })
  }
  deleteUser(idUser: any) {
    this.adminService.deleteUser(idUser).subscribe({
      next: (data) => {
        if (data.ok) {
          this.alert.confirm("Hecho", "Usuario deshabilitado correctamente").then(()=>{window.location.reload()})
        }
      }
    })
  }
  enableUser(idUser: any) {
    this.adminService.enableUser(idUser).subscribe({
      next: (data) => {
        if (data.ok) {
          this.alert.confirm("Hecho", "Usuario habilitado correctamente").then(()=>{window.location.reload()})
        }
      }
    })
  }
}
