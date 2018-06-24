import { Routes } from '@angular/router';
import { DodajBolestComponent } from './dodaj-bolest/dodaj-bolest.component';
import { PregledBolestiComponent } from './pregled-bolesti/pregled-bolesti.component';


export const bolestiRouting: Routes = [
    { path: '', component: DodajBolestComponent , pathMatch: 'full'},
    { path: 'dodavanje', component: DodajBolestComponent},
    { path: 'pregled', component: PregledBolestiComponent}
];