import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { environment } from "../../../enviroment";

@Injectable({
    providedIn:'root'
})
export class BannerService {

    private api = environment.serverApi

    constructor(private http: HttpClient){}
    
    listBanners() {
        return this.http.get<any>(this.api+'/banner');
    }

    pullCharacter(banner_id:number) {
        return this.http.post<any>(this.api+'/pull/character?bannerId='+banner_id, {});
    }

    pullT3() {
        return this.http.post<any>(this.api+'/pull/t3', {});
    }

}