import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-bolesti',
    templateUrl: './bolesti.component.html',
    styleUrls: ['./bolesti.component.scss']
})
export class BolestiComponent implements OnInit {

    funkcionalnost: string;

    constructor(
        private router: Router
    ) { }

    ngOnInit() {
        let url = this.router.url;
        let splitovanUrl = String(url).split("/");
        if (splitovanUrl[splitovanUrl.length - 1] === "bolesti") {
            this.funkcionalnost = "dodavanje";
        } else {
            this.funkcionalnost = splitovanUrl[splitovanUrl.length - 1];
        }
    }

    clickedFun(funkcionalnost: string){
        this.funkcionalnost = funkcionalnost;
        this.router.navigate(["/bolesti/" + funkcionalnost]);
    }

}
