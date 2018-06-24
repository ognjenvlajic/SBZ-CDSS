import { Component, OnInit } from '@angular/core';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { UtilService } from '../../../services/util/util.service';
import { LekarService } from '../../../services/lekar/lekar.service';
import { Bolest } from '../../../model/Bolest';
import { Simptom } from '../../../model/Simptom';
import { ToastrService } from 'ngx-toastr';

@Component({
    selector: 'app-upit-simptomi',
    templateUrl: './upit-simptomi.component.html',
    styleUrls: ['./upit-simptomi.component.scss']
})
export class UpitSimptomiComponent implements OnInit {

    email: string;
    bolesti: Bolest[];
    bolestId: number;
    bolest: Bolest;

    rezultat: Simptom[];

    constructor(
        private administratorService: AdministratorService,
        private utilService: UtilService,
        private lekarService: LekarService,
        private toastrService: ToastrService
    ) { }

    ngOnInit() {
        this.email = this.utilService.email();
        this.ucitajBolesti();
    }

    ucitajBolesti() {
        this.administratorService.bolesti(0, 1000, null).subscribe(
            res => {
                this.bolesti = res.body as Bolest[];
            }
        )
    }

    upit() {
        for (let b of this.bolesti) {
            if (b.id === Number(this.bolestId)) {
                this.bolest = b;
                break;
            }
        }
        let upit = {
            email: this.email,
            bolest: this.bolest
        }
        this.lekarService.upitSimptomi(upit).subscribe(
            data => {
                this.rezultat = data;
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }

}
