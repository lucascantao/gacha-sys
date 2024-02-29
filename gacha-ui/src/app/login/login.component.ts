import { Component } from '@angular/core';
import { AutenticacaoService } from '../service/autenticacao.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-login',
  standalone: true,
  imports: [],
  templateUrl: './login.component.html',
  styleUrl: './login.component.css'
})
export class LoginComponent {

  _username = ''
  _password = ''

  constructor(private autenticacaoService: AutenticacaoService, private router: Router) {}

  setUsername(value: string) {
    this._username = value;
  }

  setPassword(value: string) {
    this._password = value;
  }

  submit() {
    this.autenticacaoService.authenticate(this._username, this._password).subscribe({
      next: r => {
        localStorage.setItem('token', r.accessToken);
        this.router.navigateByUrl('/banner');
      }, 
      error: e => console.log(e)})
  }

}
