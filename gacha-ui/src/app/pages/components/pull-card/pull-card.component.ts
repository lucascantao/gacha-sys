import { Component, Input } from '@angular/core';
import { Character } from '../../../models/character';
import { Weapon } from '../../../models/weapon';
import { Router } from '@angular/router';
import { NgIf } from '@angular/common';

@Component({
  selector: 'app-pull-card',
  standalone: true,
  imports: [NgIf],
  templateUrl: './pull-card.component.html',
  styleUrl: './pull-card.component.css'
})
export class PullCardComponent {

  @Input() character?: Character;
  @Input() weapon?: Weapon;

  

}
