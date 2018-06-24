import { Injectable } from '@angular/core';
import { JwtHelper } from 'angular2-jwt';
import { Pager } from '../../model/Pager';
import { Pacijent } from '../../model/Pacijent';
import { AdministratorService } from '../administrator/administrator.service';

@Injectable()
export class UtilService {

    constructor(
        private administratorService: AdministratorService
    ) { }

    email() : string {
        const item = localStorage.getItem('korisnik');
        if (!item) {
            return null;
        }
        let jwt: JwtHelper = new JwtHelper();
        const info = jwt.decodeToken(item);
        return info.sub;
    }

    uloga() : string {
        const item = localStorage.getItem('korisnik');
        if (!item) {
            return null;
        }
        let jwt: JwtHelper = new JwtHelper();
        const info = jwt.decodeToken(item);
        return info.role[0].authority;
    }

    pacijent(): Pacijent {
        let id = localStorage.getItem('pacijent');
        let pacijent: Pacijent;
        if (!id) {
            return null;
        }

        this.administratorService.pacijent(Number(id)).subscribe(
            res => {
                pacijent = res;
                return pacijent;
            }
        )
    }

    getPager(pager: Pager) {
        if (pager.ukupnoStrana <= 7) {
            pager.prvaStrana = 1;
            pager.poslednjaStrana = pager.ukupnoStrana;
        } else {
            if (pager.trenutnaStrana <= 4) {
                pager.prvaStrana = 1;
                pager.poslednjaStrana = 7;
            } else if (pager.trenutnaStrana + 3 > pager.ukupnoStrana) {
                pager.prvaStrana = pager.ukupnoStrana - 6;
                pager.poslednjaStrana = pager.ukupnoStrana;
            } else {
                pager.prvaStrana = pager.trenutnaStrana - 3;
                pager.poslednjaStrana = pager.trenutnaStrana + 3;
            }
        }
        pager.strane = Array(pager.poslednjaStrana - pager.prvaStrana + 1).fill(0).map((e,i) => pager.prvaStrana + i);
        return pager;
    }

}
