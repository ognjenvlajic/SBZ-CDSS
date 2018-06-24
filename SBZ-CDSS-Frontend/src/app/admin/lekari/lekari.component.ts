import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';

@Component({
    selector: 'app-lekari',
    templateUrl: './lekari.component.html',
    styleUrls: ['./lekari.component.scss']
})
export class LekariComponent implements OnInit {
    
    funkcionalnost: string;

    constructor(
        private router: Router
    ) { }

    ngOnInit() {
        let url = this.router.url;
        let splitovanUrl = String(url).split("/");
        if (splitovanUrl[splitovanUrl.length - 1] === "lekari") {
            this.funkcionalnost = "dodavanje";
        } else {
            this.funkcionalnost = splitovanUrl[splitovanUrl.length - 1];
        }
    }

    clickedFun(funkcionalnost: string){
        this.funkcionalnost = funkcionalnost;
        this.router.navigate(["/lekari/" + funkcionalnost]);
    }

}
