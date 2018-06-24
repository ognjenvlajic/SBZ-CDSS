import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AdministratorService } from '../../../services/administrator/administrator.service';
import { Simptom } from '../../../model/Simptom';

@Component({
    selector: 'app-dodaj-bolest',
    templateUrl: './dodaj-bolest.component.html',
    styleUrls: ['./dodaj-bolest.component.scss']
})
export class DodajBolestComponent implements OnInit {

    form: FormGroup;
    simptomi: Simptom[];

    constructor(
        fb: FormBuilder,
        private toastrService: ToastrService,
        private administratorService: AdministratorService
    ) { 
        this.form = fb.group({
            'naziv' : [null, Validators.required],
            'opstiSimptomi': [[]],
            'specificniSimptomi' : [[]],
            'opstiDodavanje': [null],
            'specificniDodavanje': [null]
        })
    }

    ngOnInit() {
        this.ucitajSimptome();
    }

    ucitajSimptome() {
        this.administratorService.simptomi(0, 1000, null).subscribe(
            res => {
                this.simptomi = res.body as Simptom[];
            }
        )
    }

    dodajOpsti() {
        let simptom: Simptom;
        let index;
        for (let s of this.simptomi) {
            if (s.id === Number(this.form.value.opstiDodavanje)) {
                simptom = s;
                break;
            }
        }
        this.form.value.opstiSimptomi.push(simptom);
        index = this.simptomi.indexOf(simptom);
        this.simptomi.splice(index,1);
        this.form.reset({
            naziv: this.form.value.naziv, 
            opstiSimptomi: this.form.value.opstiSimptomi, 
            specificniSimptomi: this.form.value.specificniSimptomi, 
            specificniDodavanje: this.form.value.specificniDodavanje
        });
    }

    dodajSpecificni() {
        let simptom: Simptom;
        let index;
        for (let s of this.simptomi) {
            if (s.id === Number(this.form.value.specificniDodavanje)) {
                simptom = s;
                break;
            }
        }
        this.form.value.specificniSimptomi.push(simptom);
        index = this.simptomi.indexOf(simptom);
        this.simptomi.splice(index,1);
        this.form.reset({
            naziv: this.form.value.naziv, 
            opstiSimptomi: this.form.value.opstiSimptomi, 
            specificniSimptomi: this.form.value.specificniSimptomi, 
            opstiDodavanje: this.form.value.opstiDodavanje
        });
    }

    obrisiOpsti(index: number) {
        let simptom: Simptom = this.form.value.opstiSimptomi[index];
        this.form.value.opstiSimptomi.splice(index, 1);
        this.simptomi.push(simptom);
    }

    obrisiSpecificni(index: number) {
        let simptom: Simptom = this.form.value.specificniSimptomi[index];
        this.form.value.specificniSimptomi.splice(index, 1);
        this.simptomi.push(simptom);
    }

    dodajBolest() {
        let bolest = {
            naziv: this.form.value.naziv, 
            opstiSimptomi: this.form.value.opstiSimptomi,
            specificniSimptomi: this.form.value.specificniSimptomi
        }
        this.administratorService.dodajBolest(bolest).subscribe(
            data => {
                if (data.id !== null) {
                    this.toastrService.success("Uspesno ste dodali bolest!");
                    this.reset();
                    this.ucitajSimptome();
                }
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }

    reset() {
        this.form.reset({opstiSimptomi: [], specificniSimptomi: []});
    }

}
