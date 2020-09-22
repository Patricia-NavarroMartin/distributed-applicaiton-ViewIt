import {Injectable} from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import {Observable} from 'rxjs';
import {Config} from '../../config';


@Injectable()
export class HttpService {
  apiBaseURL = Config.API_SERVER_URL;
  apiServicesURL = Config.API_SERVER_SERVICES_URL;

  constructor(public http: HttpClient) {
  }

  public get(url, token?): Observable<any> {
    const options = {
      headers: !!token ? new HttpHeaders({
        'Content-Type': 'application/json',
        'Api-Token': token
      }) : new HttpHeaders({'Content-Type': 'application/json'})
    };
    return this.http.get(url, options);
  }

  // El token es opcional porque por ejemplo durante el login no es necesario.
  // Cuando existe lo mandamos y cuando no existe no lo enviamos
  public post(url, params, token?): Observable<any> {
    /*const options = {
      headers: !!token ? new HttpHeaders({
        'Content-Type': 'application/json',
        'Api-Token': token
      }) : new HttpHeaders({'Content-Type': 'application/json'})
    };*/
    const headers = new HttpHeaders().set('Content-Type', 'application/json');
    const body = JSON.stringify(params);
    return this.http.post(url, body, {headers: headers});
  }

  public put(url, params, token?): Observable<any> {
    const options = {
      headers: !!token ? new HttpHeaders({
        'Content-Type': 'application/json',
        'Api-Token': token
      }) : new HttpHeaders({'Content-Type': 'application/json'})
    };
    const body = JSON.stringify(params);
    return this.http.put(url, body, options);
  }

  public delete(url, token): Observable<any> {
    const options = {
      headers: new HttpHeaders({
        'Content-Type': 'application/json',
        'Api-Token': token
      })
    };
    return this.http.delete(url, options);
  }
}
