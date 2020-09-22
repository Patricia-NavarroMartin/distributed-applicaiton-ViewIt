import { Component, OnInit } from '@angular/core';
import {User} from '../../models/user';
import {Router} from '@angular/router';
import {UserService} from '../services/user.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {
  user:  User;

  constructor(public router: Router,
              private userService: UserService) { }

  ngOnInit() {
    this.user = new User();
  }

  onSubmit() {
    // this.router.navigate(['/home']);
    // TODO: store this new user in the database
    this.userService.registerUser(this.user).subscribe(
      (data: User) => {
        if (data === null) {
          console.log('Registration failed');
        } else {
          console.log('User registered with id: ' + data.userId);
          this.router.navigate(['/billboard']);
          this.userService.setCurrentUser(data);
        }},
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished login in!');
      }
    );
  }

}
