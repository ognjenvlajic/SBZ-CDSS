import { Component, OnInit } from '@angular/core';
import { Lek } from '../../../model/Lek';
import { Pager } from '../../../model/Pager';
import { ActivatedRoute } from '@angular/router';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { UtilService } from '../../../services/util/util.service';

@Component({
    selector: 'app-pregled-lekova',
    templateUrl: './pregled-lekova.component.html',
    styleUrls: ['./pregled-lekova.component.scss']
})
export class PregledLekovaComponent implements OnInit {

    lekovi: Lek[];
    pager: Pager;
    filter: string;
    pretragaPolje: string;
    pretragaIzvrsena: boolean;

    constructor(
        private route: ActivatedRoute,
        private administratorService: AdministratorService,
        private utilService: UtilService
    ) { }

    ngOnInit() {
        this.pager = {
            trenutnaStrana: 1,
            velicinaStrane: 25,
            ukupnoStrana: undefined,
            prvaStrana: undefined,
            poslednjaStrana: undefined,
            strane: []
        }
        this.izlistajLekove();
        this.pretragaIzvrsena = false;
    }

    izlistajLekove() {
        this.administratorService.lekovi(this.pager.trenutnaStrana-1, this.pager.velicinaStrane, this.filter).subscribe(
            res => {
                this.lekovi = res.body as Lek[];
                this.pager.ukupnoStrana = Number(res.headers.get('Ukupno-Strana'));
                this.pager = this.utilService.getPager(this.pager);
            }
        )
    }

    promeniVelicinu() {
        this.pager.trenutnaStrana = 1;
        this.izlistajLekove();
    }

    pretraga() {
        this.filter = this.pretragaPolje;
        this.pager.trenutnaStrana = 1;
        this.pretragaIzvrsena = true;
        this.izlistajLekove();
    }

}
