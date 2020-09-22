import { Injectable } from '@angular/core';
import {Config} from '../../config';
import {HttpService} from './http.service';
import {SessionStorageService} from 'ngx-webstorage';
@Injectable()
export class AuthenticationService {
  hasSession = false;
  user;
  apiBaseURL: string = Config.API_SERVER_URL;

  constructor(public http: HttpService, public _locker: SessionStorageService) {
  }

  public isLoggedIn() {
    const user = this._locker.retrieve('user');
    // Existe este usuario en el locker? si no, lo generamos
    if (!!user) {
      this.user = user;
      this.hasSession = true;
    }
    return this.hasSession;
  }

  public logIn(username: string, password: string) {
    // El url del server donde se envian un ajax de tipo post sin token con el server
    const url = `${this.apiBaseURL}/users/login`;

    // Devuelve un observable de usuario
    return this.http.post(url, {
      'username': username,
      'password': password
    });
  }

  public logout() {
    this.user = null;
    this.hasSession = false;
    // Limpiar el session storage del "user" dado que es la llave del hashmap
    this._locker.clear('user');
  }
}
