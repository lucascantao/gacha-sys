import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../service/character.service';
import { Character } from '../../models/character';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-character-selection',
  standalone: true,
  imports: [NgFor],
  templateUrl: './character-selection.component.html',
  styleUrl: './character-selection.component.css'
})
export class CharacterSelectionComponent implements OnInit {

  _characters!: Character[];

  constructor(private characterService: CharacterService) {}
  
  ngOnInit(): void {
    this.characterService.listCharacters().subscribe({
      next: r => this._characters = r
    })
  }



}
