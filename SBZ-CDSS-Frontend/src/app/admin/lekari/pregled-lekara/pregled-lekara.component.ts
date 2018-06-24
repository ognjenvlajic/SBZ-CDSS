import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { UtilService } from '../../../services/util/util.service';
import { Lekar } from '../../../model/Lekar';
import { Pager } from '../../../model/Pager';

@Component({
    selector: 'app-pregled-lekara',
    templateUrl: './pregled-lekara.component.html',
    styleUrls: ['./pregled-lekara.component.scss']
})
export class PregledLekaraComponent implements OnInit {
    
    lekari: Lekar[];
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
        this.izlistajLekare();
        this.pretragaIzvrsena = false;
    }

    izlistajLekare() {
        this.administratorService.lekari(this.pager.trenutnaStrana-1, this.pager.velicinaStrane, this.filter).subscribe(
            res => {
                this.lekari = res.body as Lekar[];
                this.pager.ukupnoStrana = Number(res.headers.get('Ukupno-Strana'));
                this.pager = this.utilService.getPager(this.pager);
            }
        )
    }

    promeniVelicinu() {
        this.pager.trenutnaStrana = 1;
        this.izlistajLekare();
    }

    pretraga() {
        this.filter = this.pretragaPolje;
        this.pager.trenutnaStrana = 1;
        this.pretragaIzvrsena = true;
        this.izlistajLekare();
    }

}
