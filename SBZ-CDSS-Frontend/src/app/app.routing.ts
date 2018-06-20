import { Routes } from '@angular/router';
import { LogovanjeComponent } from './logovanje/logovanje.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { LekariComponent } from './admin/lekari/lekari.component';
import { lekariRouting } from './admin/lekari/lekari.routing';
import { LekarPregledComponent } from './admin/lekar-pregled/lekar-pregled.component';

export const appRouting: Routes = [
    { path: '',
        redirectTo: '/logovanje',
        pathMatch: 'full'
    },
    { path: 'logovanje',
        component: LogovanjeComponent
        //canActivate: [LoginGuardService]
    },
    { path: 'pocetna',
        component: PocetnaComponent
    },
    { path: 'lekari',
        component: LekariComponent,
        //canActivate: [RoleGuardService],
        //data: {ocekivaneUloge : 'ADMIN'},
        children: lekariRouting
    },
    { path: 'lekar/:id',
        component: LekarPregledComponent,
        //canActivate: [RoleGuardService],
        //data: {ocekivaneUloge : 'ADMIN'}
    }
];