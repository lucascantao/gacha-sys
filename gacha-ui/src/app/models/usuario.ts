import { Character } from "./character";
import { Weapon } from "./weapon";

export interface Usuario {
    id: number,
    email: string,
    name: string,
    pulls: number,
    characters: Character[],
    weapons: Weapon[]
    
}