import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
    selector: 'app-lekar-pregled',
    templateUrl: './lekar-pregled.component.html',
    styleUrls: ['./lekar-pregled.component.scss']
})
export class LekarPregledComponent implements OnInit {
    id: number;
    lekar: any;

    constructor(
        private route: ActivatedRoute,
        //private administratorService: AdministratorService
    ) { }

    ngOnInit() {
        this.route.params.subscribe(
            params => {
                this.id = +params['id']; 
                this.getLekar();
            }
        )
    }

    getLekar() {
        //this.administratorService.getZgrada(this.id).subscribe(
        //    data => this.zgrada = data
        //)
    }

}
