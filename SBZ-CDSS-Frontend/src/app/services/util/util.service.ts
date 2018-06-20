import { Injectable } from '@angular/core';
import { Pager } from '../../model/Pager';

@Injectable()
export class UtilService {

    constructor() { }

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
