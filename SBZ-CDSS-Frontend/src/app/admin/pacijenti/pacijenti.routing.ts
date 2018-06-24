import { Routes } from '@angular/router';
import { DodajPacijentaComponent } from './dodaj-pacijenta/dodaj-pacijenta.component';
import { PregledPacijenataComponent } from './pregled-pacijenata/pregled-pacijenata.component';


export const pacijentiRouting: Routes = [
    { path: '', component: DodajPacijentaComponent , pathMatch: 'full'},
    { path: 'dodavanje', component: DodajPacijentaComponent},
    { path: 'pregled', component: PregledPacijenataComponent}
];