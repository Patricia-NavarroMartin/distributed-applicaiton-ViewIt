import { Component, OnInit } from '@angular/core';
import {Router, RouterModule} from '@angular/router';
import {User} from 'src/app/models/user';
import {UserService} from '../services/user.service';
import {Observable} from 'rxjs';
import {Form, NgForm} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {
user: User;
userNotValid: boolean;
  constructor(public router: Router,
              public userService: UserService) {}

  ngOnInit() {
    this.user = new User();
    this.userNotValid = false;
  }


  onSubmit(loginForm: NgForm) {
    // const authorized = true;
    // this.router.navigate(['/home']);
    this.userService.loginUser(this.user).subscribe(
      (data: User) => {
        if (data === null) {
          console.log('Login failed');
          this.userNotValid = true;
          loginForm.resetForm();
        } else {
          console.log('Logged in with user: ' + data.username);
          this.userService.setCurrentUser(data);
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
/*
    if (this.userService.loginUser(this.user) === null) {
      this.userNotValid = true;
      loginForm.resetForm();
    } else {
      this.router.navigate(['/billboard']);
    }
  }*/

}
