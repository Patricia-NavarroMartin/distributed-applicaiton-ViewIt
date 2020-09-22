import { Component, OnInit } from '@angular/core';
import {Movie} from '../../models/movie';
import {MoviesService} from '../services/movies.service';
import {ActivatedRoute, Router} from '@angular/router';
import {NgForm} from '@angular/forms';
import {MovieDetails} from '../../models/movieDetails';
import {User} from '../../models/user';

@Component({
  selector: 'app-movie-creator',
  templateUrl: './movie-creator.component.html',
  styleUrls: ['./movie-creator.component.css']
})
export class MovieCreatorComponent implements OnInit {
  isLoading = true;
  movie: Movie;
  movieDetails: MovieDetails;
  id: number;
  public genreList: Array<string> = ['Action', 'Animated', 'Comedy', 'Musical'];

  constructor(private moviesService: MoviesService,
              private route: ActivatedRoute,
              public router: Router) {}

  ngOnInit() {
    this.movie = new Movie();
    this.movieDetails = new MovieDetails();
    console.log('Movie Creator initialized');
    this.isLoading = false;
  }

  onSubmit(movieCreateform: NgForm) {
    this.movie.movieDetails = this.movieDetails;
    console.log('Movie being saved:' + this.movie.title);
    this.moviesService.addMovie(this.movie).subscribe(
      (data: Movie) => {
      if (data === null) {
        console.log('Creation failed');
        movieCreateform.resetForm();
      } else {
        console.log('Created successfully movie: ' + data.title);
        this.router.navigate(['/billboard']);
      }},
    error => {
      console.error(error);
    },
      () => {
        console.log('Finished creating movie!');
      }
  );
  }

}
