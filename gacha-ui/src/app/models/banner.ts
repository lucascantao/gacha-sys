import { Character } from "./character";

export interface Banner {
    id: number | null,
    name: string,
    characters: Character[]
}