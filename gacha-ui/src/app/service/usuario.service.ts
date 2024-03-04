import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../../enviroment";
import { Usuario } from "../models/usuario";
import { Observable } from "rxjs";

@Injectable({
    providedIn: 'root'
})
export class UsuarioService {

    private api = environment.serverApi;

    constructor(private http:HttpClient) {}

    getUserByToken(): Observable<Usuario> {
        return this.http.get<Usuario>(this.api+'/user/getUserToken');
    }

}