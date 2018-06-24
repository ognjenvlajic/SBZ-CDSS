import { Routes } from '@angular/router';
import { DodajLekComponent } from './dodaj-lek/dodaj-lek.component';
import { PregledLekovaComponent } from './pregled-lekova/pregled-lekova.component';


export const lekoviRouting: Routes = [
    { path: '', component: DodajLekComponent , pathMatch: 'full'},
    { path: 'dodavanje', component: DodajLekComponent},
    { path: 'pregled', component: PregledLekovaComponent}
];