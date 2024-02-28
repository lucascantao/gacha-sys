import { Injectable } from "@angular/core";
import { environment } from "../../../enviroment";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class AutenticacaoService {

    private api = environment.serverApi;
    private loginUrl = '/auth/login';

    constructor(private http:HttpClient) {}

    login(username: string, password: string) {
        const usuario = {username: username, password: password}
        return this.http.post<any>(this.api+this.loginUrl, usuario);
    }

}