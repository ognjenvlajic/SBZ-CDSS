import { Injectable } from '@angular/core';
import { HttpClient, HttpParams } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Lekar } from '../../model/Lekar';
import { Pacijent } from '../../model/Pacijent';
import { Simptom } from '../../model/Simptom';
import { Bolest } from '../../model/Bolest';
import { Lek } from '../../model/Lek';

@Injectable()
export class AdministratorService {

    constructor(
        private http: HttpClient
    ) { }

    dodajLekara(lekar: Object): Observable<Lekar> {
        return this.http.post<Lekar>("/api/lekar/dodaj", lekar);
    }

    lekar(lekarId: number): Observable<Lekar> {
        return this.http.get<Lekar>("api/lekar/" + lekarId);
    }

    lekari(page, size, filter) {
        if (!filter) {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size);
            return this.http.get("/api/lekari", {params, observe: "response"});
        } else {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size).append("filter", filter);
            return this.http.get("/api/lekari", {params, observe: "response"});
        }
    }

    dodajPacijenta(pacijent: Object): Observable<Pacijent> {
        return this.http.post<Pacijent>("/api/pacijent/dodaj", pacijent);
    }

    pacijent(pacijentId: number): Observable<Pacijent> {
        return this.http.get<Pacijent>("api/pacijent/" + pacijentId);
    }

    pacijenti(page, size, filter) {
        if (!filter) {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size);
            return this.http.get("/api/pacijenti", {params, observe: "response"});
        } else {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size).append("filter", filter);
            return this.http.get("/api/pacijenti", {params, observe: "response"});
        }
    }

    dodajSimptom(simptom: Object): Observable<Simptom> {
        return this.http.post<Simptom>("/api/simptom/dodaj", simptom);
    }

    simptomi(page, size, filter) {
        if (!filter) {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size);
            return this.http.get("/api/simptomi", {params, observe: "response"});
        } else {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size).append("filter", filter);
            return this.http.get("/api/simptomi", {params, observe: "response"});
        }
    }

    dodajBolest(bolest: Object): Observable<Bolest> {
        return this.http.post<Bolest>("/api/bolest/dodaj", bolest);
    }

    bolest(bolestId: number): Observable<Bolest> {
        return this.http.get<Bolest>("api/bolest/" + bolestId);
    }

    bolesti(page, size, filter) {
        if (!filter) {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size);
            return this.http.get("/api/bolesti", {params, observe: "response"});
        } else {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size).append("filter", filter);
            return this.http.get("/api/bolesti", {params, observe: "response"});
        }
    }

    dodajLek(lek: Object): Observable<Lek> {
        return this.http.post<Lek>("/api/lek/dodaj", lek);
    }

    lek(lekId: number): Observable<Lek> {
        return this.http.get<Lek>("api/lek/" + lekId);
    }

    lekovi(page, size, filter) {
        if (!filter) {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size);
            return this.http.get("/api/lekovi", {params, observe: "response"});
        } else {
            const params:HttpParams = new HttpParams().set("page", page).append("size", size).append("filter", filter);
            return this.http.get("/api/lekovi", {params, observe: "response"});
        }
    }

}
