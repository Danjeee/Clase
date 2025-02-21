import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { catchError, Observable } from 'rxjs';
import { environment } from '../../environments/environment';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
  
  apiUrl = environment.apiUrl

  constructor(private http: HttpClient) { }

  getAllSocios(): Observable<any>{
    return this.http.get(`${this.apiUrl}?opcion=TS`).pipe(
      catchError(err=>{throw err})
    )
  }
  getAllSells(): Observable<any>{
    return this.http.get(`${this.apiUrl}?opcion=TVC`).pipe(
      catchError(err=>{throw err})
    )
  }
  getAllCats(): Observable<any>{
    return this.http.get(`${this.apiUrl}?opcion=TC`).pipe(
      catchError(err=>{throw err})
    )
  }
  deleteCat(idCat: any): Observable<any>{
    const fd: FormData = new FormData()
    fd.append("opcion", "BC")
    fd.append("idcategoria", idCat)
    return this.http.post(`${this.apiUrl}`, fd).pipe(
      catchError(err=>{throw err})
    )
  }
  newCat(data: FormData): Observable<any>{
    data.append("opcion", "RC")
    return this.http.post(`${this.apiUrl}`, data).pipe(
      catchError(err=>{throw err})
    )
  }
  editCat(data: FormData): Observable<any>{
    data.append("opcion", "MC")
    return this.http.post(`${this.apiUrl}`, data).pipe(
      catchError(err=>{throw err})
    )
  }
  deleteUser(idUser: any): Observable<any>{
    const fd: FormData = new FormData()
    fd.append("opcion", "DS")
    fd.append("idsocio", idUser)
    return this.http.post(`${this.apiUrl}`, fd).pipe(
      catchError(err=>{throw err})
    )
  }
  enableUser(idUser: any): Observable<any>{
    const fd: FormData = new FormData()
    fd.append("opcion", "ES")
    fd.append("idsocio", idUser)
    return this.http.post(`${this.apiUrl}`, fd).pipe(
      catchError(err=>{throw err})
    )
  }
  getAllArts(): Observable<any>{
    return this.http.get(`${this.apiUrl}?opcion=TA`).pipe(
      catchError(err=>{throw err})
    )
  }

  deleteArt(idArt: any): Observable<any>{
    const fd: FormData = new FormData()
    fd.append("opcion", "DA")
    fd.append("idarticulo", idArt)
    return this.http.post(`${this.apiUrl}`, fd).pipe(
      catchError(err=>{throw err})
    )
  }
  enableArt(idArt: any): Observable<any>{
    const fd: FormData = new FormData()
    fd.append("opcion", "EA")
    fd.append("idarticulo", idArt)
    return this.http.post(`${this.apiUrl}`, fd).pipe(
      catchError(err=>{throw err})
    )
  }
}
