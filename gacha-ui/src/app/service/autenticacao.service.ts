import { Injectable } from "@angular/core";
import { environment } from "../../../enviroment";
import { HttpClient } from "@angular/common/http";

@Injectable({
    providedIn: 'root'
})
export class AutenticacaoService {

    private api = environment.serverApi;
    private loginUrl = '/auth/login';
    private registerUrl = '/auth/register';

    constructor(private http:HttpClient) {}

    authenticate(username: string, password: string) {
        const usuario = {username: username, password: password}
        return this.http.post<any>(this.api+this.loginUrl, usuario, {headers: { 'login' : 'I HAVE TO FIX THIS, CMON!!'}});
    }

    register(username: string, email:string, password: string) {
        const usuario = {
            name: username,
            email: email,
            password: password
          }
        return this.http.post<any>(this.api+this.registerUrl, usuario, {headers: {'login' : 'AAAAAAAAAAAA'}})
    }


}