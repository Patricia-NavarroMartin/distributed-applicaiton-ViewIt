import {Order} from './order';
import {Product} from './product';

export class OrderDetail {
  public order?: Order;
  public orderDetailId?: number;
  public product: Product;
  public orderDetailPrice: number;
  public quantity: number;
}
