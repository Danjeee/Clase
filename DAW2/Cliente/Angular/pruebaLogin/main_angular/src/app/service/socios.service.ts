import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SociosService {
  private apiURL = 'http://localhost/pruebaLogin/php/prueba.php'
  constructor(private http: HttpClient) { }

  login(user: any, pass: any): Observable<any> {
    var fd = new FormData();
    fd.append("opcion", "SR")
    fd.append("email", user)
    fd.append("password", pass)
    return this.http.post(`${this.apiURL}`, fd)
  }

  register(fd: FormData): Observable<any> {
    return this.http.post(`${this.apiURL}`, fd)
  }
}
