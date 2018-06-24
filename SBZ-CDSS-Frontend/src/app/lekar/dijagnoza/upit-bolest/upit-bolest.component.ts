import { Component, OnInit } from '@angular/core';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { UtilService } from '../../../services/util/util.service';
import { LekarService } from '../../../services/lekar/lekar.service';
import { Simptom } from '../../../model/Simptom';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-upit-bolest',
    templateUrl: './upit-bolest.component.html',
    styleUrls: ['./upit-bolest.component.scss']
})
export class UpitBolestComponent implements OnInit {

    email: string;
    simptomi: Simptom[];
    simptomiUpit: any[];
    simptomId;

    rezultat: any[];

    constructor(
        private administratorService: AdministratorService,
        private utilService: UtilService,
        private lekarService: LekarService,
        private toastrService: ToastrService
    ) { }

    ngOnInit() {
        this.email = this.utilService.email();
        this.ucitajSimptome();
        this.simptomiUpit = [];
    }

    ucitajSimptome() {
        this.administratorService.simptomi(0, 1000, null).subscribe(
            res => {
                this.simptomi = res.body as Simptom[];
            }
        )
    }

    dodajSimptom() {
        for (let s of this.simptomi) {
            if (s.id === Number(this.simptomId)) {
                this.simptomiUpit.push(s);
                break;
            }
        }
    }

    obrisiSimptom(i: number) {
        this.simptomiUpit.splice(i, 1);
    }

    upit(){
        let upit = {
            email: this.email,
            simptomi: this.simptomiUpit
        }
        this.lekarService.upitBolest(upit).subscribe(
            data => {
                this.rezultat = data;
                console.log(data);
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }
}
