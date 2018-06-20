import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-pregled-lekara',
    templateUrl: './pregled-lekara.component.html',
    styleUrls: ['./pregled-lekara.component.scss']
})
export class PregledLekaraComponent implements OnInit {
    stanari: any[];
    pager: any;
    pretraga: string;
    pretragaPolje: string;
    pretragaIzvrsena: boolean;

    constructor(
        private route: ActivatedRoute,
        //private administratorService: AdministratorService,
        //private utilService: UtilService
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
        /*this.administratorService.getStanari(this.pager.trenutnaStrana-1, this.pager.velicinaStrane, this.filter).subscribe(
            res => {
                this.stanari = res.body as Korisnik[];
                this.pager.ukupnoStrana = Number(res.headers.get('Ukupno-Strana'));
                this.pager = this.utilService.getPager(this.pager);
                this.pretragaIzvresna = true;
            }
        )*/
    }

    promeniVelicinu() {
        this.pager.trenutnaStrana = 1;
        this.izlistajLekare();
    }

    filtriraj() {
        this.pretraga = this.pretragaPolje;
        this.pager.trenutnaStrana = 1;
        this.izlistajLekare();
    }

}
