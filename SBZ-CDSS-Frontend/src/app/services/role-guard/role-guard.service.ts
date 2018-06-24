import { Injectable } from '@angular/core';
import { AuthenticationService } from '../authentication/authentication.service';
import { Router, ActivatedRouteSnapshot } from '@angular/router';
import { JwtHelper } from 'angular2-jwt';

@Injectable()
export class RoleGuardService {

    constructor(
        public auth: AuthenticationService,
        public router: Router
    ) { }

    canActivate(route: ActivatedRouteSnapshot): boolean {
        // this will be passed from the route config
        // on the data property
        let ocekivaneUloge: string = route.data.ocekivaneUloge;
        
        const item = localStorage.getItem('korisnik');    

        let jwt: JwtHelper = new JwtHelper();

        if (!item) {
            this.router.navigate(['/logovanje']);
            return false;
        }

        // decode the token to get its payload
        const info = jwt.decodeToken(item);

        //ako su role pred skup i stanar
        let uloge: string[] = ocekivaneUloge.split("|", 5);
        //console.log(uloge);

        if (!this.auth.ulogovan() || uloge.indexOf(info.role[0].authority) === -1) {
            this.router.navigate(['/pocetna']);
            return false;
        }
        return true;
    }

}
