import { Component, OnInit } from '@angular/core';
import { Pacijent } from '../../../model/Pacijent';
import { Pager } from '../../../model/Pager';
import { ActivatedRoute } from '@angular/router';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { UtilService } from '../../../services/util/util.service';
import { PacijentiComponent } from '../pacijenti.component';

@Component({
    selector: 'app-pregled-pacijenata',
    templateUrl: './pregled-pacijenata.component.html',
    styleUrls: ['./pregled-pacijenata.component.scss']
})
export class PregledPacijenataComponent implements OnInit {

    pacijenti: Pacijent[];
    pager: Pager;
    filter: string;
    pretragaPolje: string;
    pretragaIzvrsena: boolean;

    pacijent: Pacijent;
    uloga: string;

    constructor(
        private route: ActivatedRoute,
        private administratorService: AdministratorService,
        private utilService: UtilService
    ) { }

    ngOnInit() {
        this.uloga = this.utilService.uloga();
        this.pacijent = this.utilService.pacijent();
        this.pager = {
            trenutnaStrana: 1,
            velicinaStrane: 25,
            ukupnoStrana: undefined,
            prvaStrana: undefined,
            poslednjaStrana: undefined,
            strane: []
        }
        this.izlistajPacijente();
        this.pretragaIzvrsena = false;
        this.dobaviPacijenta();
    }

    
    dobaviPacijenta() {
        let id = localStorage.getItem('pacijent');
        if (!id) {
            this.pacijent = null;
            return;
        }

        this.administratorService.pacijent(Number(id)).subscribe(
            res => {
                this.pacijent = res;
            }
        )
    }


    izlistajPacijente() {
        this.administratorService.pacijenti(this.pager.trenutnaStrana-1, this.pager.velicinaStrane, this.filter).subscribe(
            res => {
                this.pacijenti = res.body as Pacijent[];
                this.pager.ukupnoStrana = Number(res.headers.get('Ukupno-Strana'));
                this.pager = this.utilService.getPager(this.pager);
            }
        )
    }

    promeniVelicinu() {
        this.pager.trenutnaStrana = 1;
        this.izlistajPacijente();
    }

    pretraga() {
        this.filter = this.pretragaPolje;
        this.pager.trenutnaStrana = 1;
        this.pretragaIzvrsena = true;
        this.izlistajPacijente();
    }

    izaberi(pacijent: Pacijent) {
        this.pacijent = pacijent;
        localStorage.setItem("pacijent", String(this.pacijent.id));
    }

    ukloni() {
        this.pacijent = null;
        localStorage.removeItem('pacijent');
    }

}
