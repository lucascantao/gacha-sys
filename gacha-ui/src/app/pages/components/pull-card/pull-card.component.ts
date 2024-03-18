import { Component, Input } from '@angular/core';
import { Character } from '../../../models/character';
import { Weapon } from '../../../models/weapon';
import { Router } from '@angular/router';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-pull-card',
  standalone: true,
  imports: [NgIf, NgFor],
  templateUrl: './pull-card.component.html',
  styleUrl: './pull-card.component.css'
})
export class PullCardComponent {

  @Input() characters: Character[] = [];
  @Input() weapons: Weapon[] = [];

  

}
