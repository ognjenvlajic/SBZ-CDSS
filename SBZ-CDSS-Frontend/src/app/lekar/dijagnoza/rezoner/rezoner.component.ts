import { Component, OnInit } from '@angular/core';
import { Simptom } from '../../../model/Simptom';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { Bolest } from '../../../model/Bolest';
import { UtilService } from '../../../services/util/util.service';
import { LekarService } from '../../../services/lekar/lekar.service';
import { Pacijent } from '../../../model/Pacijent';
import { Lek } from '../../../model/Lek';
import { ToastrService } from 'ngx-toastr';
import { Router } from '@angular/router';

@Component({
    selector: 'app-rezoner',
    templateUrl: './rezoner.component.html',
    styleUrls: ['./rezoner.component.scss']
})
export class RezonerComponent implements OnInit {

    email: string;
    pacijentId: number;

    prviKorak: boolean;
    simptomi: Simptom[];
    simptomNaziv: string;
    imaVrednost: boolean;
    simptomVrednost: number;
    simptomiPacijenta: any[];

    drugiKorak: boolean;
    bolesti: Bolest[];
    bolest: Bolest;

    treciKorak: boolean;
    pacijent: Pacijent;
    lekovi: Lek[];
    lekNaziv: string;
    sastojak: string;

    cetvrtiKorak: boolean;
    pripisaniLekovi: Lek[];
    neuspesnaValidacija: string;
    
    constructor(
        private router: Router,
        private administratorService: AdministratorService,
        private utilService: UtilService,
        private lekarService: LekarService,
        private toastrService: ToastrService
    ) { }

    ngOnInit() {
        this.email = this.utilService.email();
        this.pacijentId = Number(localStorage.getItem('pacijent'));
        this.ucitajSimptome();
        this.dobaviPacijenta();
        this.ucitajLekove();
        this.prviKorak = true;
        this.drugiKorak = false;
        this.treciKorak = false;
        this.cetvrtiKorak = false;
        this.simptomiPacijenta = [];
        this.imaVrednost = false;
        this.pripisaniLekovi = [];
        this.neuspesnaValidacija = "";
    }

    onlyNumber(event) {
        if (event.charCode > 31 && (event.charCode != 46 &&(event.charCode < 48 || event.charCode > 57))){
            return event.preventDefault();
        }
    }

    // prvi korak
    ucitajSimptome() {
        this.administratorService.simptomi(0, 1000, null).subscribe(
            res => {
                this.simptomi = res.body as Simptom[];
            }
        )
    }

    promena() {
        this.imaVrednost = false;
        this.simptomVrednost = -1;
        for (let s of this.simptomi) {
            if (s.naziv === this.simptomNaziv) {
                if (s.minVrednost > -1 || s.maxVrednost > -1) {
                    this.imaVrednost = true;
                    this.simptomVrednost = 0;
                    break;
                }
            }
        }
    }

    dodajSimptom() {
        let s = {
            naziv: this.simptomNaziv,
            vrednost: this.simptomVrednost
        }
        this.simptomiPacijenta.push(s);
    }

    obrisiSimptom(i: number) {
        this.simptomiPacijenta.splice(i, 1);
    }

    rezoner() {
        let rezoner = {
            email: this.email,
            pacijentId: this.pacijentId,
            simptomi: this.simptomiPacijenta
        }
        this.lekarService.rezoner(rezoner).subscribe(
            res => {
                this.bolesti = res as Bolest[];
                console.log(this.bolesti);
            }
        );
        this.prviKorak = false;
        this.drugiKorak = true;
    }

    // drugi korak
    izaberiBolest(index: number) {
        this.bolest = this.bolesti[index];
        this.drugiKorak = false;
        this.treciKorak = true;
    }

    // treci korak
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

    ucitajLekove() {
        this.administratorService.lekovi(0, 1000, null).subscribe(
            res => {
                this.lekovi = res.body as Lek[];
            }
        )
    }

    dodajAlergijuLek() {
        for (let l of this.lekovi) {
            if (l.naziv === this.lekNaziv) {
                this.pacijent.alergijaLekovi.push(l);
            }
        }
    }

    obrisiAlergijuLek(index: number) {
        this.pacijent.alergijaLekovi.splice(index, 1);
    }

    dodajAlergijuSastojak() {
        this.pacijent.alergijaSastojci.push(this.sastojak);
        this.sastojak = "";
    }

    obrisiAlergijuSastojak(index: number) {
        this.pacijent.alergijaSastojci.slice(index, 1);
    }

    potvrdiAlergije() {
        this.lekarService.alergije(this.pacijent).subscribe(
            data => {
                if (data.id !== null) {
                    this.treciKorak = false;
                    this.cetvrtiKorak = true;
                    this.lekNaziv = "";
                }
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }

    // cetvrti korak
    dodajLek() {
        for (let l of this.lekovi) {
            if (l.naziv === this.lekNaziv) {
                this.pripisaniLekovi.push(l);
            }
        }
    }

    obrisiLek(index: number) {
        this.pripisaniLekovi.splice(index, 1);
    }

    dijagnozaIValidacija() {
        let dijagnoza = {
            email: this.email,
            pacijentId: this.pacijentId,
            bolest: this.bolest,
            pripisaniLekovi: this.pripisaniLekovi,
            simptomi: this.simptomiPacijenta
        }
        this.lekarService.dijagnoza(dijagnoza).subscribe(
            data => {
                if (data === "Uspesno ste kreirali dijagnozu za pacijenta!") {
                    this.toastrService.success(data);
                    this.router.navigate(['/pocetna']);
                } else {
                    this.neuspesnaValidacija = data;
                }
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }
}
