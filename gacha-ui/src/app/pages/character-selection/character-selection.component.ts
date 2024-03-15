import { Component, OnInit } from '@angular/core';
import { CharacterService } from '../../service/character.service';
import { Character } from '../../models/character';
import { NgFor, NgIf } from '@angular/common';
import { UsuarioService } from '../../service/usuario.service';

@Component({
  selector: 'app-character-selection',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './character-selection.component.html',
  styleUrl: './character-selection.component.css'
})
export class CharacterSelectionComponent implements OnInit {

  _characters!: Character[];

  constructor(
    private characterService: CharacterService,
    private usuarioService: UsuarioService,
    ) {}
  
  ngOnInit(): void {
    this.usuarioService.getUserByToken().subscribe({
      next: r => this._characters = r.characters
    })
  }




}
