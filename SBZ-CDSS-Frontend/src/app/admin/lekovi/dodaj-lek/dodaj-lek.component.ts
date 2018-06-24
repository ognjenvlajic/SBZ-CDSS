import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AdministratorService } from '../../../services/administrator/administrator.service';

@Component({
    selector: 'app-dodaj-lek',
    templateUrl: './dodaj-lek.component.html',
    styleUrls: ['./dodaj-lek.component.scss']
})
export class DodajLekComponent implements OnInit {

    form: FormGroup;
    sastojakDodavanje: string;
    sastojciLista: string[];

    constructor(
        fb: FormBuilder,
        private toastrService: ToastrService,
        private administratorService: AdministratorService
    ) { 
        this.form = fb.group({
            'naziv' : [null, Validators.required],
            'grupa': ['ANELGETIK', Validators.required],
            'sastojci' : [[]],
            'sastojakDodavanje': ['']
        })
    }

    ngOnInit() {
    }

    dodajSastojak() {
        this.form.value.sastojci.push(this.form.value.sastojakDodavanje);
        this.form.reset({naziv: this.form.value.naziv, grupa: this.form.value.grupa, sastojci: this.form.value.sastojci, sastojakDodavanje: ''})
    }

    obrisi(index: number){
        this.form.value.sastojci.splice(index, 1);
    }

    dodajLek() {
        let lek = {
            naziv: this.form.value.naziv, 
            grupa: this.form.value.grupa,
            sastojci: this.form.value.sastojci
        }
        this.administratorService.dodajLek(lek).subscribe(
            data => {
                if (data.id !== null) {
                    this.toastrService.success("Uspesno ste dodali lek!");
                    this.reset();
                }
            },
            error => {
                this.toastrService.error(error.error);
            }
        )
    }

    reset() {
        this.form.reset({grupa: 'ANELGETIK', sastojci: [], sastojakDodavanje: ''});
    }

}
