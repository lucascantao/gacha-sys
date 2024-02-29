import { Character } from "./character";

export interface Banner {
    id: number,
    name: string,
    characters: Character[]
}