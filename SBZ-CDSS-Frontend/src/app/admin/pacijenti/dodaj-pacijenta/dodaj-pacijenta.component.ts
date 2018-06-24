import { Component, OnInit } from '@angular/core';
import { FormGroup, FormBuilder, Validators } from '@angular/forms';
import { ToastrService } from 'ngx-toastr';
import { AdministratorService } from '../../../services/administrator/administrator.service';

@Component({
    selector: 'app-dodaj-pacijenta',
    templateUrl: './dodaj-pacijenta.component.html',
    styleUrls: ['./dodaj-pacijenta.component.scss']
})
export class DodajPacijentaComponent implements OnInit {

    form: FormGroup;

    constructor(
        fb: FormBuilder,
        private toastrService: ToastrService,
        private administratorService: AdministratorService
    ) { 
        this.form = fb.group({
            'jmbg' : [null, Validators.compose([Validators.required, Validators.minLength(13)])],
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

    dodajPacijenta() {
        this.administratorService.dodajPacijenta(this.form.value).subscribe(
            data => {
                if (data.id !== null) {
                    this.toastrService.success("Uspesno ste dodali pacijenta!");
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
