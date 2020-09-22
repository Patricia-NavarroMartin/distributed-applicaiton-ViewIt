import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {UserService} from '../../public/services/user.service';

@Component({
  selector: 'app-header',
  templateUrl: './header.component.html',
  styleUrls: ['./header.component.css']
})
export class HeaderComponent implements OnInit {

  constructor(public router: Router,
              public userService: UserService) { }

  ngOnInit() {
  }

  edit() {
    const url: String =  this.router.url + '/edit';
    console.log(url);
    this.router.navigate([url]);
  }

  logout() {
    this.userService.logout();
    this.userService.setCurrentUser(null);
    this.router.navigate(['/']);
  }

}
