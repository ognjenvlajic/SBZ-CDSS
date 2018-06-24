import { Component, OnInit } from '@angular/core';
import { UtilService } from '../services/util/util.service';

@Component({
    selector: 'app-pocetna',
    templateUrl: './pocetna.component.html',
    styleUrls: ['./pocetna.component.scss']
})
export class PocetnaComponent implements OnInit {

    uloga: string;

    constructor(
        private utilService: UtilService
    ) { }

    ngOnInit() {
        this.uloga = this.utilService.uloga();
    }

}
