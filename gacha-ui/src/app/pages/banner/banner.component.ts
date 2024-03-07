import { Component, Input, OnInit } from '@angular/core';
import { BannerService } from '../../service/banner.service';
import { Banner } from '../../models/banner';
import { NgFor, NgIf } from '@angular/common';
import { Character } from '../../models/character';
import { Weapon } from '../../models/weapon';
import { PullCardComponent } from '../components/pull-card/pull-card.component';
import { UsuarioService } from '../../service/usuario.service';
import { animate, style, transition, trigger } from '@angular/animations';
import { environment } from '../../../../enviroment';


@Component({
  selector: 'app-banner',
  standalone: true,
  imports: [NgIf, NgFor, PullCardComponent],
  templateUrl: './banner.component.html',
  styleUrl: './banner.component.css',
  animations: [
    trigger('wishWhiteFadeOut', [
      transition(':enter', [
        style({opacity: 1}),
        animate('1s', style({opacity: 0}))
      ])
    ])
  ]
})
export class BannerComponent implements OnInit{

  _pulls!:number;
  _banners!: Banner[];
  _selected_banner?: Banner;

  _selected_character?:Character;

  _pull_character?:Character;
  _pull_weapon?:Weapon;

  _showCard = false;

  _gDrive = environment.gDriveApi;

  constructor(private bannerService:BannerService, private usuarioService: UsuarioService) {}
  
  ngOnInit(): void {
    this.usuarioService.getUserByToken().subscribe({
      next: r => {
        this._pulls = r.pulls;
      }
    })

    this.bannerService.listBanners().subscribe({
      next: r => {
        this._banners = r;
        this._selected_banner = this._banners[0];
        this._selected_character = this._selected_banner.characters[0];
      }
    })
  }

  pull(banner_id:number, quantity:number) {
    if(this._pulls <= 0){return}
    
    this._pulls -= 1;
    this.dismiss()
    this.bannerService.pullCharacter(banner_id).subscribe({
      next: r => {
        if(r!=null){
          this._pull_character = r;
          this._showCard = true;
        } else {
          this.bannerService.pullT3().subscribe({
            next: r => {
              this._pull_weapon = r;
              this._showCard = true;
            }
          })
        }
      }
    })
  }

  dismiss(){
    this._showCard = false;
    this._pull_character = undefined;
    this._pull_weapon = undefined;
  }

  selectBanner(banner:Banner) {
    this._selected_banner = banner;
    this.selectCharacter(banner.characters[0]);
  }

  selectCharacter(character:Character) {
    this._selected_character = character;
  }

  

}
