import { Component, OnInit } from '@angular/core';
import {Movie} from '../../models/movie';
import {MoviesService} from '../services/movies.service';
import {Router} from '@angular/router';

@Component({
  selector: 'app-billboard-editor',
  templateUrl: './billboard-editor.component.html',
  styleUrls: ['./billboard-editor.component.css']
})
export class BillboardEditorComponent implements OnInit {
  slides: Array<{img: string, title: string, id: number}> = [];

  slideConfig = {'slidesToShow': 4, 'slidesToScroll': 4};
  movies: Array<Movie>;

  constructor(private moviesService: MoviesService, public router: Router) { }

  ngOnInit() {
    this.getBillboard();
  }

  getBillboard() {
    this.moviesService.getMovies().subscribe(
      (data: Movie[]) => {
        // for every product received in the array
        this.movies = data;
        data.forEach((movie) => {this.addSlide(movie); });
      },
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished loading bar products!');
      }

    );
  }
  addSlide(movie: Movie) {
    // this.slides.push({img: 'http://placehold.it/350x150/777777', title: movie.title});
    this.slides.push({img: movie.image, title: movie.title, id: movie.movieId});
  }
  afterChange(e) {
    console.log('afterChange');
  }

  edit(id: number) {
    const url: String =  '/movie/' + id + '/edit';
    console.log(url);
    this.router.navigate([url]);
  }

  remove(id: number) {
    const removeMovie: Movie = this.movies.find(movie => movie.movieId === id);
    this.moviesService.removeMovie(removeMovie);
  }

  createNew() {
    const url: String = '/billboard/new-movie';
    this.router.navigate([url]);
  }
}
