import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../../enviroment";

@Injectable({
    providedIn: 'root'
})
export class UuarioService {

    private api = environment.serverApi;

    constructor(private http:HttpClient) {}

    getUserByToken() {
        return this.http.get<any>(this.api+'/user/getUserToken');
    }

}