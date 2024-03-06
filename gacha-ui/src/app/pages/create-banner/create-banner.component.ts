import { Component, OnInit } from '@angular/core';
import { BannerService } from '../../service/banner.service';
import { CharacterService } from '../../service/character.service';
import { Banner } from '../../models/banner';
import { Character } from '../../models/character';
import { NgFor } from '@angular/common';
import { Router } from '@angular/router';

@Component({
  selector: 'app-create-banner',
  standalone: true,
  imports: [NgFor],
  templateUrl: './create-banner.component.html',
  styleUrl: './create-banner.component.css'
})
export class CreateBannerComponent implements OnInit{

  _banner:Banner = {
    id: null, 
    name: '',
    characters: []

  };
  _characters!: Character[];

  constructor(private bannerService:BannerService, private characterService:CharacterService, private router:Router) {}

  ngOnInit(): void {
    this.characterService.listCharacters().subscribe({
      next: r => this._characters = r,
    })
  }

  saveBanner(){
    this.bannerService.createBanner(this._banner).subscribe({
      next: r => {
        this.router.navigateByUrl('/banner')
      },
      error: e => {
        console.log(e)
      }
    });
  }

  setName(name: string) {
    this._banner.name = name;
  }

  selectCharacter(name: string){
    console.log(name)
    this._characters.forEach(c => {
      if(c.name === name && !this._banner.characters.includes(c)){
        this._banner.characters.push(c)
      }
    })
  }

  removeCharacter(c:Character) {
    this._banner.characters = this._banner.characters.filter(char => char !== c);
  }

}
