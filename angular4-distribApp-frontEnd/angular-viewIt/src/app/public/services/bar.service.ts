import {Injectable} from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {HttpService} from '../../common/services/http.service';
import {Product} from '../../models/product';

@Injectable()
export class BarService extends HttpService {
  private url = this.apiBaseURL;
  constructor(public http: HttpClient) {super(http); }

  getBar(): Observable<Array<Product>> {
    return this.get(`${this.url}/bar`);
  }
}
