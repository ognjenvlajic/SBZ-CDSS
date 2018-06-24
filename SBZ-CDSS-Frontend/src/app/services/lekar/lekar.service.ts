import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import { Pacijent } from '../../model/Pacijent';
import { Simptom } from '../../model/Simptom';

@Injectable()
export class LekarService {

    constructor(
        private http: HttpClient
    ) { }

    rezoner(rezoner): Observable<any> {
        return this.http.post<any>('api/rezoner', rezoner);
    }

    dijagnoza(dijagnoza) {
        return this.http.post('api/validacijaIDijagnoza', dijagnoza, {responseType: 'text'});
    }

    alergije(pacijent: Pacijent): Observable<Pacijent> {
        return this.http.post<Pacijent>('/api/pacijent/alergije', pacijent);
    }

    upitBolest(upit): Observable<any[]> {
        return this.http.post<any[]>('api/upitBolest', upit);
    }

    upitSimptomi(upit): Observable<Simptom[]> {
        return this.http.post<Simptom[]>('api/upitSimptomi', upit);
    }

}
