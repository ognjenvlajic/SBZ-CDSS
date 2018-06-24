import { Component, OnInit } from '@angular/core';
import { Bolest } from '../../../model/Bolest';
import { Pager } from '../../../model/Pager';
import { ActivatedRoute } from '@angular/router';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { UtilService } from '../../../services/util/util.service';

@Component({
    selector: 'app-pregled-bolesti',
    templateUrl: './pregled-bolesti.component.html',
    styleUrls: ['./pregled-bolesti.component.scss']
})
export class PregledBolestiComponent implements OnInit {

    bolesti: Bolest[];
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
        this.izlistajBolesti();
        this.pretragaIzvrsena = false;
    }

    izlistajBolesti() {
        this.administratorService.bolesti(this.pager.trenutnaStrana-1, this.pager.velicinaStrane, this.filter).subscribe(
            res => {
                this.bolesti = res.body as Bolest[];
                this.pager.ukupnoStrana = Number(res.headers.get('Ukupno-Strana'));
                this.pager = this.utilService.getPager(this.pager);
            }
        )
    }

    promeniVelicinu() {
        this.pager.trenutnaStrana = 1;
        this.izlistajBolesti();
    }

    pretraga() {
        this.filter = this.pretragaPolje;
        this.pager.trenutnaStrana = 1;
        this.pretragaIzvrsena = true;
        this.izlistajBolesti();
    }

}
