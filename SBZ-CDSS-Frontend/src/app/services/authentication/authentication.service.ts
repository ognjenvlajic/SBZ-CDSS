import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { JwtHelper } from 'angular2-jwt';

@Injectable()
export class AuthenticationService {

    constructor(
        private http: HttpClient
    ) { }

    logovanje(email: string, lozinka: string) {
        return this.http.post("api/ulogujSe", {"email": email, "lozinka": lozinka}, {responseType: 'json'});
    }

    izlogujSe() {
        return this.http.get("api/izlogujSe", {responseType: 'text'});
    }

    autentifikovan(): boolean {
        const token = localStorage.getItem('korisnik');
        // Check whether the token is expired and return
        // true or false

        let jwt:JwtHelper = new JwtHelper();

        if (!token) {
            return false;
        }

        return !jwt.isTokenExpired(token);
    }

    ulogovan() : boolean {
        const token = localStorage.getItem('korisnik');

        if (!token) {
            return false;
        }
        return true;
    }

}
