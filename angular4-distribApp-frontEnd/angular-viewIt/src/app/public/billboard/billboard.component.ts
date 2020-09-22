import { Component, OnInit } from '@angular/core';
import {MoviesService} from '../services/movies.service';
import {Movie} from '../../models/movie';
import {Router} from '@angular/router';

@Component({
  selector: 'app-billboard',
  templateUrl: './billboard.component.html',
  styleUrls: ['./billboard.component.css']
})
export class BillboardComponent implements OnInit {
  slides: Array<{img: string, title: string, id: number}> = [];

  slideConfig = {'slidesToShow': 4, 'slidesToScroll': 4};
  movies: Array<Movie>;

  constructor(private moviesService: MoviesService, public router: Router) { }

  ngOnInit() {
    this.getBillboard();
  }

  // TODO: get billboard after selecting a date. So add datepicker in screen, parse and edit movie.service server route
  getBillboard() {
    this.moviesService.getBillboard().subscribe(
      (data: Movie[]) => {
        // for every product received in the array
        this.movies = data;
        data.forEach((movie) => {this.addSlide(movie); });
      },
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished loading billboard!');
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
}
