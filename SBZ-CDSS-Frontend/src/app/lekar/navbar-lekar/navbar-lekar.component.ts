import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication/authentication.service';
import { UtilService } from '../../services/util/util.service';

@Component({
    selector: 'app-navbar-lekar',
    templateUrl: './navbar-lekar.component.html',
    styleUrls: ['./navbar-lekar.component.scss']
})
export class NavbarLekarComponent implements OnInit {

    email: string;

    constructor(
        private router: Router, 
        private authenticateService: AuthenticationService,
        private utilService: UtilService
    ) { }

    ngOnInit() {
        this.email = this.utilService.email();
    }

    odjavljivanje() {
        this.authenticateService.izlogujSe().subscribe(
            result => {
                if (result) {
                    localStorage.removeItem('korisnik');

                    this.router.navigate(['/logovanje']);
                }
            },
            error => {
                localStorage.removeItem('korisnik');
    
                this.router.navigate(['/logovanje']);
            }
        )
    }

}
