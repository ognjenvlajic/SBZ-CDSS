import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from './services/authentication/authentication.service';
import { JwtHelper } from 'angular2-jwt';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.scss']
})
export class AppComponent {

    uloga: string;

    constructor(
        private router: Router, 
        private authenticateService: AuthenticationService
    ) { }

    ngOnInit() {
    }

    proveriUlogu() {
        // mozda ovde podesiti start up page

        const item = localStorage.getItem('korisnik');

        if(!item) {
            this.router.navigate(['logovanje']);
            this.uloga = '';
            return;
        }

        let jwt: JwtHelper = new JwtHelper();

        this.uloga = jwt.decodeToken(item).role[0].authority;
        console.log(this.uloga);
    }
}
