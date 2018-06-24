import { Routes } from '@angular/router';
import { RezonerComponent } from './rezoner/rezoner.component';
import { UpitBolestComponent } from './upit-bolest/upit-bolest.component';
import { UpitSimptomiComponent } from './upit-simptomi/upit-simptomi.component';
import { LicnaDijagnozaComponent } from './licna-dijagnoza/licna-dijagnoza.component';


export const dijagnozaRouting: Routes = [
    { path: '', component: RezonerComponent , pathMatch: 'full'},
    { path: 'rezoner', component: RezonerComponent},
    { path: 'upitBolest', component: UpitBolestComponent},
    { path: 'upitSimptomi', component: UpitSimptomiComponent},
    { path: 'licnaDijagnoza', component: LicnaDijagnozaComponent }
];