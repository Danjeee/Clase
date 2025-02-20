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
constructor (private adminService: AdminService, private alert: AlertService){}
    ventas: any
    ngOnInit(): void {
      this.adminService.getAllSells().subscribe({
        next: (data) => {
          this.ventas = data
        }
      })
    }
}
