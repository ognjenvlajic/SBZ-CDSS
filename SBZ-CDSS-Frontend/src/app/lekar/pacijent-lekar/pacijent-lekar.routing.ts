import { Routes } from '@angular/router';
import { DodajPacijentaComponent } from '../../admin/pacijenti/dodaj-pacijenta/dodaj-pacijenta.component';
import { PregledPacijenataComponent } from '../../admin/pacijenti/pregled-pacijenata/pregled-pacijenata.component';


export const pacijentLekarRouting: Routes = [
    { path: '', component: PregledPacijenataComponent , pathMatch: 'full'},
    { path: 'odabir', component: PregledPacijenataComponent},
    { path: 'dodavanje', component: DodajPacijentaComponent}
];