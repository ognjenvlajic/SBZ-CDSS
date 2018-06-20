import { Routes } from '@angular/router';
import { DodajLekaraComponent } from './dodaj-lekara/dodaj-lekara.component';
import { PregledLekaraComponent } from './pregled-lekara/pregled-lekara.component';


export const lekariRouting: Routes = [
    { path: '', component: DodajLekaraComponent , pathMatch: 'full'},
    { path: 'dodavanje', component: DodajLekaraComponent},
    { path: 'pregled', component: PregledLekaraComponent}
];