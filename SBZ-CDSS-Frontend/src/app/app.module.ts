import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FormsModule, ReactiveFormsModule} from '@angular/forms';
import { CommonModule } from '@angular/common';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { ToastrModule } from 'ngx-toastr';
import { appRouting } from './app.routing';


import { AppComponent } from './app.component';
import { LogovanjeComponent } from './logovanje/logovanje.component';
import { NavbarAdminComponent } from './admin/navbar-admin/navbar-admin.component';
import { NavbarLekarComponent } from './lekar/navbar-lekar/navbar-lekar.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { LekariComponent } from './admin/lekari/lekari.component';
import { DodajLekaraComponent } from './admin/lekari/dodaj-lekara/dodaj-lekara.component';
import { PregledLekaraComponent } from './admin/lekari/pregled-lekara/pregled-lekara.component';
import { LekarPregledComponent } from './admin/lekar-pregled/lekar-pregled.component';
import { PagerComponent } from './pager/pager.component';
import { PacijentiComponent } from './admin/pacijenti/pacijenti.component';
import { DodajPacijentaComponent } from './admin/pacijenti/dodaj-pacijenta/dodaj-pacijenta.component';
import { PregledPacijenataComponent } from './admin/pacijenti/pregled-pacijenata/pregled-pacijenata.component';
import { PacijentComponent } from './admin/pacijent/pacijent.component';
import { SimptomiComponent } from './admin/simptomi/simptomi.component';
import { AdministratorService } from './services/administrator/administrator.service';
import { UtilService } from './services/util/util.service';
import { RoleGuardService } from './services/role-guard/role-guard.service';
import { LoginGuardService } from './services/login-guard/login-guard.service';
import { AuthenticationService } from './services/authentication/authentication.service';
import { AuthInterceptor } from './interceptors/auth.interceptor';
import { NotFoundPageComponent } from './not-found-page/not-found-page.component';
import { BolestiComponent } from './admin/bolesti/bolesti.component';
import { DodajBolestComponent } from './admin/bolesti/dodaj-bolest/dodaj-bolest.component';
import { PregledBolestiComponent } from './admin/bolesti/pregled-bolesti/pregled-bolesti.component';
import { BolestComponent } from './admin/bolest/bolest.component';
import { LekoviComponent } from './admin/lekovi/lekovi.component';
import { DodajLekComponent } from './admin/lekovi/dodaj-lek/dodaj-lek.component';
import { PregledLekovaComponent } from './admin/lekovi/pregled-lekova/pregled-lekova.component';
import { LekComponent } from './admin/lek/lek.component';
import { PacijentLekarComponent } from './lekar/pacijent-lekar/pacijent-lekar.component';
import { DijagnozaComponent } from './lekar/dijagnoza/dijagnoza.component';
import { RezonerComponent } from './lekar/dijagnoza/rezoner/rezoner.component';
import { LekarService } from './services/lekar/lekar.service';
import { LicnaDijagnozaComponent } from './lekar/dijagnoza/licna-dijagnoza/licna-dijagnoza.component';
import { UpitSimptomiComponent } from './lekar/dijagnoza/upit-simptomi/upit-simptomi.component';
import { UpitBolestComponent } from './lekar/dijagnoza/upit-bolest/upit-bolest.component';


@NgModule({
    declarations: [
        AppComponent,
        LogovanjeComponent,
        NavbarAdminComponent,
        NavbarLekarComponent,
        PocetnaComponent,
        LekariComponent,
        DodajLekaraComponent,
        PregledLekaraComponent,
        LekarPregledComponent,
        PagerComponent,
        PacijentiComponent,
        DodajPacijentaComponent,
        PregledPacijenataComponent,
        PacijentComponent,
        SimptomiComponent,
        NotFoundPageComponent,
        BolestiComponent,
        DodajBolestComponent,
        PregledBolestiComponent,
        BolestComponent,
        LekoviComponent,
        DodajLekComponent,
        PregledLekovaComponent,
        LekComponent,
        PacijentLekarComponent,
        DijagnozaComponent,
        RezonerComponent,
        LicnaDijagnozaComponent,
        UpitSimptomiComponent,
        UpitBolestComponent 
    ],
    imports: [
        BrowserModule,
        FormsModule,
        ReactiveFormsModule,
        CommonModule,
        BrowserAnimationsModule, // required animations module
        ToastrModule.forRoot({
            timeOut: 5000,
            positionClass: 'toast-top-right',
            preventDuplicates: true,
        }),
        HttpClientModule,
        RouterModule.forRoot(
            appRouting,
            { enableTracing: true } // <-- debugging purposes only
        )
    ],
    providers: [AdministratorService, UtilService, LekarService, RoleGuardService, LoginGuardService, AuthenticationService,
        {provide: HTTP_INTERCEPTORS, useClass: AuthInterceptor, multi: true}],
    bootstrap: [AppComponent]
})
export class AppModule { }
