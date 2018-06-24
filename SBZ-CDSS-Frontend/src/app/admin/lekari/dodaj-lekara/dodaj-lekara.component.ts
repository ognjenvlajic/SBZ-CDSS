import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AdministratorService } from '../../../services/administrator/administrator.service';

@Component({
    selector: 'app-dodaj-lekara',
    templateUrl: './dodaj-lekara.component.html',
    styleUrls: ['./dodaj-lekara.component.scss']
})
export class DodajLekaraComponent implements OnInit {
    
    form: FormGroup;
    emailPattern = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$"
    lozinkaPattern = "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9]).{6,}$"

    constructor(
        fb: FormBuilder,
        private toastrService: ToastrService,
        private administratorService: AdministratorService
    ) { 
        this.form = fb.group({
            'email' : [null, Validators.compose([Validators.required, Validators.pattern(this.emailPattern)])],
            'lozinka': [null, Validators.compose([Validators.required, Validators.pattern(this.lozinkaPattern)])],
            'ime' : [null, Validators.required],
            'prezime' : [null, Validators.required],
        })
    }

    ngOnInit() {
    }

    onlyNumber(event) {
        if (event.charCode > 31 && (event.charCode != 46 &&(event.charCode < 48 || event.charCode > 57))){
            return event.preventDefault();
        }
    }

    dodajLekara() {
        this.administratorService.dodajLekara(this.form.value).subscribe(
            data => {
                if (data.id !== null) {
                    this.toastrService.success("Uspesno ste dodali lekara!");
                    this.form.reset();
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

}
