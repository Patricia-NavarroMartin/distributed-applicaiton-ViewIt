import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {User} from '../../models/user';
import {UserService} from '../../public/services/user.service';
import {NgForm} from '@angular/forms';
import {OrderDetail} from '../../models/orderDetail';
import {Movie} from '../../models/movie';
import {Order} from '../../models/order';

@Component({
  selector: 'app-user-account',
  templateUrl: './user-account.component.html',
  styleUrls: ['./user-account.component.css']
})
export class UserAccountComponent implements OnInit {
user: User;
orderList: Array<OrderDetail>;
total: number;
  constructor(public router: Router,
              public userService: UserService) { }

  ngOnInit() {
    this.user = this.userService.getCurrentUser();
    this.total = 0;
    this.getOrderList();
  }

  getOrderList() {
    this.userService.getCurrentOrder().subscribe(
      (data: OrderDetail[]) => {
          this.orderList = data;
          // Calculate total value
          this.orderList.forEach((od) => this.addPrice(od));
          // this.router.navigate(['/billboard']);
        },
      error => {
        console.error(error);
      },
      () => {
        console.log('Finished loading the order list!');
      }
    );
  }

  saveChanges(form: NgForm) {
    this.userService.editUser(this.user).subscribe(
      (data: User) => {
        if (data === null) {
          console.log('User saved correctly');
          this.userService.refreshUser().subscribe(
            (data2: User) => {
              if (data2 === null) {
                console.log('User refreshed correctly');
              }}
          );
        }
      }
    );
    this.router.navigate(['/home']);
  }

  private addPrice(od: OrderDetail) {
    this.total += od.orderDetailPrice;
  }

  purchase() {
    this.userService.purchaseCurrentOrder().subscribe(
      (data: Order) => {
        if (data === null) { console.log('Order saved correctly'); }
      }
    );
    this.router.navigate(['/billboard']);
  }
}
