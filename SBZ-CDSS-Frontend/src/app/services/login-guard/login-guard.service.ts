import { Injectable } from '@angular/core';
import { AuthenticationService } from '../authentication/authentication.service';
import { Router } from '@angular/router';

@Injectable()
export class LoginGuardService {

    constructor(
        public auth: AuthenticationService,
        public router: Router
    ) { }

    canActivate(): boolean {
        if (this.auth.ulogovan()) {
            this.router.navigate(['/pocetna']);
            return false;
        }
        return true;
    }
}
