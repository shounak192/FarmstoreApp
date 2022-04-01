import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Category } from 'app/models/category';
import { Credentials } from 'app/models/credential';
import { Item } from 'app/models/item';
import { Orders } from 'app/models/orders';
import { AuthService } from 'app/services/auth.service';
import { CartService } from 'app/services/cart.service';
import { ItemService } from 'app/services/item.service';
import { OrdersService } from 'app/services/orders.service';
import { SupplierService } from 'app/services/supplier.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-cart',
  templateUrl: './cart.component.html',
  styleUrls: ['./cart.component.css']
})
export class CartComponent implements OnInit {

  items: Item[] = [];
  items1: Item[] = [];
  grandTotal: number = 0;
  addOrder: Orders = new Orders();
  userName: string = '';
  credential: Credentials = new Credentials();
  total: number[] = [];


  constructor(private cartService: CartService,
    private activatedRoute: ActivatedRoute,
    // private viewCustomerService: ViewCustomerBookService,
    private router: Router, private authService: AuthService, private supplierService: SupplierService, private orderService: OrdersService, private itemService: ItemService) { }

  ngOnInit(): void {
    this.itemService.browseItems().subscribe(
      (data) => {
        this.items1 = data;
        console.log("Fetched Items: ");
      },
      (error) => {
        console.log("Failed to fetch items: ");
        console.log(error);
      }
    );
    this.items = this.cartService.getItems();
    this.addOrder.items = this.items;
    this.userName = this.authService.getUserName() as string;
    this.supplierService.viewDetails(this.userName).subscribe((response) => {
      console.log('response' + response);
      this.addOrder.supplier = response;
      let c = this.authService.retrieveCredentialDetails();
      this.addOrder.supplier.credential = JSON.parse(c as string);
      console.log(this.addOrder.supplier);
      console.log(this.items1.length);
      for (let i = 0; i < this.addOrder.items.length; i++) {
        this.total[i] = this.addOrder.items[i].itemPrice * this.addOrder.items[i].itemQuantity;
        this.addOrder.quantity += this.addOrder.items[i].itemQuantity;
        console.log(this.addOrder.quantity);
      }
      this.calcCartTotal();
    });
  }

  // this.addOrder.items = [...this.cartService.getItems()];


  clearCartItem(item: Item) {
    this.cartService.clearCartItem(item);
    this.total.forEach((value, index) => { if (value == item.itemPrice * item.itemQuantity) this.total.splice(index, 1); });
    this.calcCartTotal();
  }

  inc(item: Item) {
    for (let i = 0; i < this.addOrder.items.length; i++) {
      for (let j = 0; j < this.items1.length; j++) {
        if (item.itemId == this.items[i].itemId && item.itemId == this.items1[j].itemId) {
          if (item.itemQuantity + 1 > this.items1[j].itemQuantity) {
            Swal.fire({
              title: 'Ordering more than existing stock!',
              icon: 'warning',
              confirmButtonColor: '#3085d6',
              confirmButtonText: 'OK'
            });
          }
          else {
            item.itemQuantity++;
            this.total[i] = this.addOrder.items[i].itemPrice * item.itemQuantity;
            this.addOrder.quantity++;
          }
        }
      }
    }

    console.log(this.addOrder.quantity);
    // this.addOrder.items.forEach(i => {
    //   if(i.itemId == item.itemId){
    //   i.itemQuantity+= 1;
    //   for (let i = 0; i < this.addOrder.items.length; i++) {
    //   this.total[i]= i.itemPrice * i.itemQuantity;
    //   }
    // });
    this.calcCartTotal();
  }



  dec(item: Item) {
    if (item.itemQuantity > 1) {
      for (let i = 0; i < this.addOrder.items.length; i++) {
        if (item.itemId == this.items[i].itemId) {
          item.itemQuantity -= 1;
          this.total[i] = this.addOrder.items[i].itemPrice * item.itemQuantity;
          this.addOrder.quantity--;
        }
      }
      this.calcCartTotal();
    }
  }

  emptycart() {
    this.cartService.clearCart();
  }

  placeOrder() {
    this.addOrder.price = this.grandTotal;
    console.log(this.addOrder);
    this.orderService.addOrder(this.addOrder).subscribe((response) => {
      console.log(response);
      // this.addOrder.items = [];
      this.addOrder = response;
      this.cartService.clearCart();
      this.items = [];
      this.router.navigate(['list-supplier-orders']);
    },
      (error) => {
        console.log(error);
      });
    // this.router.navigate(['order']);
  }

  navToItems() {
    this.router.navigate(['browse-items']);
  }
  calcCartTotal() {
    let sum = 0;
    this.total.forEach(n => sum += n);
    this.grandTotal = sum;
  }

}
