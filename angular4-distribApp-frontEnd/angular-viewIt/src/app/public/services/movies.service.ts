import {Injectable} from '@angular/core';
import { HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {HttpService} from '../../common/services/http.service';
import {Movie} from '../../models/movie';
import {Product} from '../../models/product';
import {Ticket} from '../../models/ticket';
import {OrderDetail} from '../../models/orderDetail';
// Here we route to the server's domain
@Injectable()
export class MoviesService extends HttpService {
  private url = this.apiServicesURL;
  constructor(public http: HttpClient) {super(http); }

  // General access to the movies database without considering date issues
  getMovies(): Observable<Array<Movie>> {
    return this.get(`${this.url}/movies`);
  }

  getMovie(id: number): Observable<Movie> {
    return this.get(`${this.url}/movies/${id}`);
  }

  updateMovie(movie: Movie): Observable<Movie> {
    return this.put(`${this.url}/movies/${movie.movieId}/edit`, movie);
  }

  addMovie(movie: Movie): Observable<Movie> {
    return this.post(`${this.url}/movies/new`, movie);
  }

  removeMovie(movie: Movie) {
    this.delete(`${this.url}/movies/remove`, movie);
  }


  // Get from cached info
  getBillboard(): Observable<Array<Movie>> {
    return this.get(`${this.url}/screenings/billboard`);
  }

  getBillboardMovie(id: number): Observable<Movie> {
    return this.get(`${this.url}/screenings/billboard/movie/${id}`);
  }

  getBillboardMovieScreenings(id: number): Observable<Array<String>> {
    return this.get(`${this.url}/screenings/billboard/movie/${id}/screenings`);
  }

  getTickets(): Observable<Array<Ticket>> {
    return this.get(`${this.url}/product/tickets`);
  }

  addOrderDetail(od: OrderDetail): Observable<OrderDetail> {
    return this.post(`${this.url}/user/order/add`, od);
  }

}
