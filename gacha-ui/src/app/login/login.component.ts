import { Component } from '@angular/core';
import { AutenticacaoService } from '../service/autenticacao.service';

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

  constructor(private autenticacaoService: AutenticacaoService) {}

  setUsername(value: string) {
    this._username = value;
  }

  setPassword(value: string) {
    this._password = value;
  }

  submit() {
    this.autenticacaoService.login(this._username, this._password).subscribe({next: r => console.log(r), error: e => console.log(e)})
  }

}
