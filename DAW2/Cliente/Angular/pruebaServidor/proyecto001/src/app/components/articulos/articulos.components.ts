import { Component, OnInit } from "@angular/core";
import { ArticulosService } from "../../service/articulos.service";
import { CommonModule } from "@angular/common";
import { error } from "console";

@Component({
    selector: "app-articulos",
    templateUrl: "./articulos.component.html",
    styleUrls: ["./articulos.component.css"],
    standalone: true,
    imports: [CommonModule]
})
export class ArticulosComponent implements OnInit{
    articulos: any[] = [];

    constructor(private articulosService : ArticulosService) { }

    ngOnInit(): void {
        this.articulosService.getArticulos().subscribe({
            next: (data) => {
                console.log("Respuesta del servidor: ",data);
                this.articulos = data;
            },
            error: (error) => console.error("Error al obtener los articulos: ", error)
        });
    }
}