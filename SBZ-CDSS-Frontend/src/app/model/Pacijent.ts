import { Lek } from "./Lek";

export interface Pacijent {
    id: number;
    jmbg: string;
    ime: string;
    prezime: string;
    alergijaLekovi: Lek[];
    alergijaSastojci: string[];
}