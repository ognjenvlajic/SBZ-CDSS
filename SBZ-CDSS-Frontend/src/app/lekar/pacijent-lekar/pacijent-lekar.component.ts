import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-pacijent-lekar',
    templateUrl: './pacijent-lekar.component.html',
    styleUrls: ['./pacijent-lekar.component.scss']
})
export class PacijentLekarComponent implements OnInit {

    funkcionalnost: string;

    constructor(
        private router: Router
    ) { }

    ngOnInit() {
        let url = this.router.url;
        let splitovanUrl = String(url).split("/");
        if (splitovanUrl[splitovanUrl.length - 1] === "pacijentLekar") {
            this.funkcionalnost = "odabir";
        } else {
            this.funkcionalnost = splitovanUrl[splitovanUrl.length - 1];
        }
    }

    clickedFun(funkcionalnost: string){
        this.funkcionalnost = funkcionalnost;
        this.router.navigate(["/pacijentLekar/" + funkcionalnost]);
    }

}
