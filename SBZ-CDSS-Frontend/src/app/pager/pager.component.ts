import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Pager } from '../model/Pager';

@Component({
    selector: 'app-pager',
    templateUrl: './pager.component.html',
    styleUrls: ['./pager.component.scss']
})
export class PagerComponent implements OnInit {

    @Input()
    pager: Pager;

    @Output()
	izmenaEvent = new EventEmitter<Pager>();

    constructor() { }

    ngOnInit() {
    }

    promeniStranu(strana: number) {
        this.pager.trenutnaStrana = strana;
        this.izmenaEvent.emit(this.pager);
    }

}
