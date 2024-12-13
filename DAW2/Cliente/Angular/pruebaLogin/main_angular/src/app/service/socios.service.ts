import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class SociosService {
  private apiURL = 'http://localhost/pruebaLogin/php/prueba.php'
  constructor(private http: HttpClient) { }

  login(data: FormData): Observable<any> {
    return this.http.post(`${this.apiURL}`, data)
  }

  register(fd: FormData): Observable<any> {
    return this.http.post(`${this.apiURL}`, fd)
  }
}
