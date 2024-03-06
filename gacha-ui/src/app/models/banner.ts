import { Character } from "./character";

export interface Banner {
    id: number | undefined,
    name: string,
    characters: Character[]
}