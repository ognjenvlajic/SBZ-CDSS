import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-pacijenti',
    templateUrl: './pacijenti.component.html',
    styleUrls: ['./pacijenti.component.scss']
})
export class PacijentiComponent implements OnInit {

    funkcionalnost: string;

    constructor(
        private router: Router
    ) { }

    ngOnInit() {
        let url = this.router.url;
        let splitovanUrl = String(url).split("/");
        if (splitovanUrl[splitovanUrl.length - 1] === "pacijenti") {
            this.funkcionalnost = "dodavanje";
        } else {
            this.funkcionalnost = splitovanUrl[splitovanUrl.length - 1];
        }
    }

    clickedFun(funkcionalnost: string){
        this.funkcionalnost = funkcionalnost;
        this.router.navigate(["/pacijenti/" + funkcionalnost]);
    }

}
