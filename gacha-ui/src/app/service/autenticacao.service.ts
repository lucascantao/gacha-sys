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
        
        return this.http.post<any>(this.api+this.loginUrl, usuario, {headers: { 'login' : 'I HAVE TO FIX THIS, CMON!!'}});
    }

    isAuthenticated() {
        // return this.http.get<boolean>(this.api+'/user/getUserToken').subscribe({
        //     next: r => true,
        //     error: e => false
        // })

        return false;
    }

}