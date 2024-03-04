import { Component, OnInit } from '@angular/core';
import { UsuarioService } from '../../service/usuario.service';
import { Usuario } from '../../models/usuario';
import { NgFor, NgIf } from '@angular/common';

@Component({
  selector: 'app-user-details',
  standalone: true,
  imports: [NgFor, NgIf],
  templateUrl: './user-details.component.html',
  styleUrl: './user-details.component.css'
})
export class UserDetailsComponent implements OnInit{

  _userDetails!: Usuario;

  constructor (private usuarioService:UsuarioService) {}
  
  ngOnInit(): void {
    this.usuarioService.getUserByToken().subscribe({
      next: r => {
        console.log(r)
        this._userDetails = r;
      }
    })
  }

  

}
