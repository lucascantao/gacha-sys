import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../../enviroment";

@Injectable({
    providedIn:'root'
})
export class CharacterService {

    private api = environment.serverApi

    constructor(private http:HttpClient) {}

    listCharacters() {
        return this.http.get<any>(this.api+'/character');
    }

}