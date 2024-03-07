import { Component } from '@angular/core';
import { AutenticacaoService } from '../service/autenticacao.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-register',
  standalone: true,
  imports: [],
  templateUrl: './register.component.html',
  styleUrl: './register.component.css'
})
export class RegisterComponent {

  _username = ''
  _password = ''
  _email = ''

  constructor(private autenticacaoService: AutenticacaoService, private router: Router) {}

  setUsername(value: string) {
    this._username = value;
  }

  setPassword(value: string) {
    this._password = value;
  }

  setEmail(value: string) {
    this._email = value;
  }

  submit() {
    
    this.autenticacaoService.register(this._username, this._email, this._password).subscribe({
      next: r => {
        this.router.navigateByUrl('/login');
      }
    });
  }

}
