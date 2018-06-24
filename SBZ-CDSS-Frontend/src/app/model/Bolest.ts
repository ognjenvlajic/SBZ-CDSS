import { Simptom } from "./Simptom";

export interface Bolest {
    id: number;
    naziv: string;
    opstiSimptomi: Simptom[];
    specificniSimptomi: Simptom[];
}