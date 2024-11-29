import { Injectable  } from "@angular/core";
import { HttpClient } from "@angular/common/http";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class ArticulosService{
    private apiURL = 'http://localhost/pruebaServidor/php/prueba.php';

    constructor(private http: HttpClient) { }

    getArticulos(): Observable<any> {
        return this.http.get(`${this.apiURL}?opcion=AV`);
    }
}