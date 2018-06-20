export interface Pager {
    trenutnaStrana: number;
    velicinaStrane: number; // koliko elemenata sadrzi jedna strana
    ukupnoStrana: number;
    prvaStrana: number;
    poslednjaStrana: number;
    strane: number[];
}