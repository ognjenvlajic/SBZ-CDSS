import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
//import { AuthenticationService } from '../services/authentication/authentication.service';

@Component({
    selector: 'app-logovanje',
    templateUrl: './logovanje.component.html',
    styleUrls: ['./logovanje.component.scss']
})
export class LogovanjeComponent implements OnInit {
    email: string;
    lozinka: string;
    greska: string = undefined;

    constructor(
        private router: Router,
        //private authenticateService: AuthenticationService
    ) { }

    ngOnInit() {
    }

    logovanje() {
        /*this.greska = undefined;
        this.authenticateService.logovanje(this.email, this.lozinka)
        .subscribe(
            result => {
               localStorage.setItem('korisnik', JSON.stringify(result));
               
               this.router.navigate(['pocetna']);
            },
            error => {
                // moguce grekse
                // Stanaru nije dodeljen stan!
                // Pogresan email ili lozinka!
                this.greska = error.error;
            }
        )*/
    }

}
