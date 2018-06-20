import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Lekar } from '../../model/Lekar';

@Injectable()
export class AdministratorService {

    constructor(
        private http: HttpClient
    ) { }

    dodajLekara(lekar: Object): Observable<Lekar> {
        return this.http.post<Lekar>("/api/lekar/dodaj", lekar);
    }

    lekar(lekarId: number): Observable<Lekar> {
        return this.http.get<Lekar>("api/lekar/{lekarId}");
    }

}
