import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-lekovi',
    templateUrl: './lekovi.component.html',
    styleUrls: ['./lekovi.component.scss']
})
export class LekoviComponent implements OnInit {

    funkcionalnost: string;

    constructor(
        private router: Router
    ) { }

    ngOnInit() {
        let url = this.router.url;
        let splitovanUrl = String(url).split("/");
        if (splitovanUrl[splitovanUrl.length - 1] === "lekovi") {
            this.funkcionalnost = "dodavanje";
        } else {
            this.funkcionalnost = splitovanUrl[splitovanUrl.length - 1];
        }
    }

    clickedFun(funkcionalnost: string){
        this.funkcionalnost = funkcionalnost;
        this.router.navigate(["/lekovi/" + funkcionalnost]);
    }

}
