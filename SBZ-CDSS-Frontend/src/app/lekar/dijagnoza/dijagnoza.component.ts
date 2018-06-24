import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Pacijent } from '../../model/Pacijent';
import { UtilService } from '../../services/util/util.service';
import { AdministratorService } from '../../services/administrator/administrator.service';

@Component({
    selector: 'app-dijagnoza',
    templateUrl: './dijagnoza.component.html',
    styleUrls: ['./dijagnoza.component.scss']
})
export class DijagnozaComponent implements OnInit {

    funkcionalnost: string;
    pacijent: Pacijent; 

    constructor(
        private router: Router,
        private utilService: UtilService,
        private administratorService: AdministratorService
    ) { }

    ngOnInit() {
        let url = this.router.url;
        let splitovanUrl = String(url).split("/");
        if (splitovanUrl[splitovanUrl.length - 1] === "dijagnoza") {
            this.funkcionalnost = "rezoner";
        } else {
            this.funkcionalnost = splitovanUrl[splitovanUrl.length - 1];
        }

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
                console.log(res);
                this.pacijent = res;
            }
        )
    }

    clickedFun(funkcionalnost: string){
        this.funkcionalnost = funkcionalnost;
        this.router.navigate(["/dijagnoza/" + funkcionalnost]);
    }

    postaviPacijenta() {
        this.router.navigate(["/pacijentLekar/odabir"]);
    }

}
