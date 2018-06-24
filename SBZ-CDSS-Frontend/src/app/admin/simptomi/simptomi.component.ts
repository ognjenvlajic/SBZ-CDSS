import { Component, OnInit } from '@angular/core';
import { Simptom } from '../../model/Simptom';
import { Pager } from '../../model/Pager';
import { ActivatedRoute } from '@angular/router';
import { AdministratorService } from '../../services/administrator/administrator.service';
import { UtilService } from '../../services/util/util.service';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';

@Component({
  selector: 'app-simptomi',
  templateUrl: './simptomi.component.html',
  styleUrls: ['./simptomi.component.scss']
})
export class SimptomiComponent implements OnInit {

    // dodavanje
    form: FormGroup;

    // pregled
    simptomi: Simptom[];
    pager: Pager;
    filter: string;
    pretragaPolje: string;
    pretragaIzvrsena: boolean;

    constructor(
        private route: ActivatedRoute,
        fb: FormBuilder,
        private toastrService: ToastrService,
        private administratorService: AdministratorService,
        private utilService: UtilService
    ) { 
        this.form = fb.group({
            'naziv' : [null, Validators.required],
            'minVrednost': [null],
            'maxVrednost' : [null]
        })
    }

    ngOnInit() {
        this.pager = {
            trenutnaStrana: 1,
            velicinaStrane: 25,
            ukupnoStrana: undefined,
            prvaStrana: undefined,
            poslednjaStrana: undefined,
            strane: []
        }
        this.izlistajSimptome();
        this.pretragaIzvrsena = false;
    }

    onlyNumber(event) {
        if (event.charCode > 31 && (event.charCode != 46 &&(event.charCode < 48 || event.charCode > 57))){
            return event.preventDefault();
        }
    }

    dodajSimptom() {
        if (this.form.value.minVrednost === null) {
            this.form.value.minVrednost = -1;
        }
        if (this.form.value.maxVrednost === null) {
            this.form.value.maxVrednost = -1;
        }
        

        this.administratorService.dodajSimptom(this.form.value).subscribe(
            data => {
                if (data.id !== null) {
                    this.toastrService.success("Uspesno ste dodali simptom!");
                    this.form.reset();
                    this.pager.trenutnaStrana = 1;
                    this.izlistajSimptome();
                }
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }

    reset() {
        this.form.reset();
    }

    izlistajSimptome() {
        this.administratorService.simptomi(this.pager.trenutnaStrana-1, this.pager.velicinaStrane, this.filter).subscribe(
            res => {
                this.simptomi = res.body as Simptom[];
                this.pager.ukupnoStrana = Number(res.headers.get('Ukupno-Strana'));
                this.pager = this.utilService.getPager(this.pager);
            }
        )
    }

    promeniVelicinu() {
        this.pager.trenutnaStrana = 1;
        this.izlistajSimptome();
    }

    pretraga() {
        this.filter = this.pretragaPolje;
        this.pager.trenutnaStrana = 1;
        this.pretragaIzvrsena = true;
        this.izlistajSimptome();
    }

    obrisi(id: number) {
        console.log(id);
    }

}
