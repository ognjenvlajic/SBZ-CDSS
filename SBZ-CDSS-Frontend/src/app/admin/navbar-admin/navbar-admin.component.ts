import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { AuthenticationService } from '../../services/authentication/authentication.service';
import { UtilService } from '../../services/util/util.service';


@Component({
    selector: 'app-navbar-admin',
    templateUrl: './navbar-admin.component.html',
    styleUrls: ['./navbar-admin.component.scss']
})
export class NavbarAdminComponent implements OnInit {

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
