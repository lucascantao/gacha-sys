import { Component, OnInit } from '@angular/core';
import { BannerService } from '../../service/banner.service';
import { CharacterService } from '../../service/character.service';
import { Banner } from '../../models/banner';
import { Character } from '../../models/character';
import { NgFor } from '@angular/common';

@Component({
  selector: 'app-create-banner',
  standalone: true,
  imports: [NgFor],
  templateUrl: './create-banner.component.html',
  styleUrl: './create-banner.component.css'
})
export class CreateBannerComponent implements OnInit{

  _banner?:Banner;
  _characters!: Character[];

  constructor(private bannerService:BannerService, private characterService:CharacterService) {}

  ngOnInit(): void {
    this.characterService.listCharacters().subscribe({
      next: r => this._characters = r
    })
  }

  saveBanner(){
    this.bannerService.createBanner(this._banner!);
  }

}
