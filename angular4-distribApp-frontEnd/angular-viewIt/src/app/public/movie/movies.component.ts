import { Component, OnInit } from '@angular/core';
import {Movie} from '../../models/movie';
import {MoviesService} from '../services/movies.service';
import {ActivatedRoute, Router} from '@angular/router';
import {Config} from '../../config';

import { DomSanitizer } from '@angular/platform-browser';
import {Ticket} from '../../models/ticket';
import {Product} from '../../models/product';
import {OrderDetail} from '../../models/orderDetail';
import { ViewChild, ElementRef} from '@angular/core';

@Component({
  selector: 'app-movies',
  templateUrl: './movies.component.html',
  styleUrls: ['./movies.component.css']
})
export class MoviesComponent implements OnInit {
  isLoading = true;
  validAmount: boolean;
  validType: boolean;
  movie: Movie;
  id: number;
  trailer: string;
  screenings: Array<string>;
  selectedScreening: string;
  tickets: Array<Ticket>;
  public ticketList: Array<number> = [1, 2, 3, 4, 5];
  orderDetail: OrderDetail;
  product: Product;
  selectedTicket: Ticket;
  @ViewChild('closeAddModal') closeAddModal: ElementRef;

  constructor(public sanitizer: DomSanitizer,
              private moviesService: MoviesService,
              private route: ActivatedRoute,
              private router: Router) { }

  ngOnInit() {
    // this.route.params.subscribe(params => {
      // this.id = +params['id']; // (+) converts string 'id' to a number
      this.route.paramMap.subscribe(params => {
        console.log(params.get('id'));
        this.id = parseInt (params.get('id'), 10);
        this.getMovieDetails(this.id);
        this.getTickets();
        this.selectedTicket = new Ticket();
        this.product = new Product();
        this.orderDetail = new OrderDetail();
        this.orderDetail.product = this.product;
        this.validAmount = false;
        this.validType = false;
      });
    // });
  }

  getTickets() {
    this.moviesService.getTickets().subscribe(
      (data: Ticket[]) => {
        this.tickets = data;
      },
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished loading tickets!');
      }
    );
  }

  getMovieDetails(movieId: number) {
    this.moviesService.getBillboardMovie(movieId).subscribe(
      (data: Movie) => {
        this.movie = data;
        this.trailer = Config.YOUTUBE_EMBED + this.movie.trailer;
        this.isLoading = false;
        // getScreenings?¿?¿?¿?¿
      },
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished loading movie!');
      }
    );

    this.moviesService.getBillboardMovieScreenings(movieId).subscribe(
      (data: string[]) => {
        // for every product received in the array
        this.screenings = data;
        // data.forEach((screeningTime) => {
        //   this.addButton(screeningTime);
        // });
      },
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished loading screening times!');
      }
      );
    }

  selectScreening(screeningTime: string ) {
    this.selectedScreening = screeningTime;
  }

  buyTickets() {
    // Construct the order detail
    this.selectedTicket = this.tickets.filter(t => t.name === this.selectedTicket.name).shift();
    this.generateOrderDetail();
    this.moviesService.addOrderDetail(this.orderDetail).subscribe(
      (data: OrderDetail) => {
        if (data === null) {
          console.log('Adding ticket failed');
        } else {
          console.log('Added successfully. ProductId = ' + data.product.productId);
          this.closeAddModal.nativeElement.click();
          this.router.navigate(['/billboard']);
        }},
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished login in!');
      }
    );
  }
  generateOrderDetail() {
    // 1st construct the product:
    this.product.name = this.selectedTicket.name;
    this.product.productId = this.selectedTicket.productId;
    this.product.ticketType = this.selectedTicket.ticketType;
    this.product.unitPrice = this.selectedTicket.unitPrice;

    this.orderDetail.product = this.product;

  }

}

