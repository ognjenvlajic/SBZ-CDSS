import { Injectable } from '@angular/core';
import { HttpInterceptor, HttpEvent, HttpHandler, HttpRequest } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable()
export class AuthInterceptor implements HttpInterceptor {

    intercept(req: HttpRequest<any>,
              next: HttpHandler): Observable<HttpEvent<any>> {

        const item = localStorage.getItem("korisnik");
        const decodedItem = JSON.parse(item);

        if (item) {
            const cloned = req.clone({
                headers: req.headers.set("X-Auth-Token", decodedItem.token)
            });

            return next.handle(cloned);
        }
        else {
            return next.handle(req);
        }
    }
}