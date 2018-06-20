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
        LekarPregledComponent
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
    providers: [],
    bootstrap: [AppComponent]
})
export class AppModule { }
