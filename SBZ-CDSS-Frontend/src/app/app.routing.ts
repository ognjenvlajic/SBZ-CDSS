import { Routes } from '@angular/router';
import { LogovanjeComponent } from './logovanje/logovanje.component';
import { PocetnaComponent } from './pocetna/pocetna.component';
import { LekariComponent } from './admin/lekari/lekari.component';
import { lekariRouting } from './admin/lekari/lekari.routing';
import { LekarPregledComponent } from './admin/lekar-pregled/lekar-pregled.component';
import { PacijentiComponent } from './admin/pacijenti/pacijenti.component';
import { pacijentiRouting } from './admin/pacijenti/pacijenti.routing';
import { SimptomiComponent } from './admin/simptomi/simptomi.component';
import { LoginGuardService } from './services/login-guard/login-guard.service';
import { RoleGuardService } from './services/role-guard/role-guard.service';
import { NotFoundPageComponent } from './not-found-page/not-found-page.component';
import { PacijentComponent } from './admin/pacijent/pacijent.component';
import { BolestiComponent } from './admin/bolesti/bolesti.component';
import { bolestiRouting } from './admin/bolesti/bolesti.routing';
import { BolestComponent } from './admin/bolest/bolest.component';
import { LekoviComponent } from './admin/lekovi/lekovi.component';
import { lekoviRouting } from './admin/lekovi/lekovi.routing';
import { LekComponent } from './admin/lek/lek.component';
import { pacijentLekarRouting } from './lekar/pacijent-lekar/pacijent-lekar.routing';
import { dijagnozaRouting } from './lekar/dijagnoza/dijagnoza.routing';
import { PacijentLekarComponent } from './lekar/pacijent-lekar/pacijent-lekar.component';
import { DijagnozaComponent } from './lekar/dijagnoza/dijagnoza.component';

export const appRouting: Routes = [
    { path: '',
        redirectTo: '/logovanje',
        pathMatch: 'full'
    },
    { path: 'logovanje',
        component: LogovanjeComponent,
        canActivate: [LoginGuardService]
    },
    { path: 'pocetna',
        component: PocetnaComponent
    },
    { path: 'lekari',
        component: LekariComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'},
        children: lekariRouting
    },
    { path: 'lekar/:id',
        component: LekarPregledComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'}
    }, 
    { path: 'pacijenti',
        component: PacijentiComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'},
        children: pacijentiRouting
    },
    { path: 'pacijent/:id',
        component: PacijentComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN|LEKAR'}
    }, 
    { path: 'simptomi',
        component: SimptomiComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'}
    },
    { path: 'bolesti',
        component: BolestiComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'},
        children: bolestiRouting
    },
    { path: 'bolest/:id',
        component: BolestComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'}
    },
    { path: 'lekovi',
        component: LekoviComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'},
        children: lekoviRouting
    },
    { path: 'lek/:id',
        component: LekComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'ADMIN'}
    },
    { path: 'pacijentLekar',
        component: PacijentLekarComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'LEKAR'},
        children: pacijentLekarRouting
    },
    { path: 'dijagnoza',
        component: DijagnozaComponent,
        canActivate: [RoleGuardService],
        data: {ocekivaneUloge : 'LEKAR'},
        children: dijagnozaRouting
    },
    { path: '**', 
        component: NotFoundPageComponent  
    }
];