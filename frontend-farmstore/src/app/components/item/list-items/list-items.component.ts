import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { HeaderComponent } from 'app/components/header/header.component';
import { Credentials } from 'app/models/credential';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { Orders } from 'app/models/orders';
import { Supplier } from 'app/models/supplier';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { CartService } from 'app/services/cart.service';
import { ItemService } from 'app/services/item.service';
import { SupplierService } from 'app/services/supplier.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-list-items',
  templateUrl: './list-items.component.html',
  styleUrls: ['./list-items.component.css']
})
export class ListItemsComponent implements OnInit {

  date: Date = new Date();
  orderItems: Array<Item> = [];
  currentOrder: Orders = new Orders();
  hasResult: boolean = true;
  items: Array<Item> = [];
  userName: string = '';
  supplier: Supplier = new Supplier();
  searchKey: string = '';
  itemCategory: string = '';

  constructor(private itemService: ItemService, private authService: AuthService, private supplierService: SupplierService, private cartService: CartService, private header: HeaderComponent, private router: Router) { }
  ngOnInit(): void {
    // this.currentOrder.items = this.cartService.getItems();
    console.log(this.currentOrder.items);
    this.userName = this.authService.getUserName() as string;
    this.supplierService.viewDetails(this.userName).subscribe((response) => {
      console.log('response' + response);
      this.supplier = response;
    },
      (err) => {
        alert(err.error.msg);
      });
    this.listItems();
    this.cartService.search.subscribe((val: any) => {
      this.searchKey = val;
    })
    this.cartService.category.subscribe((val:any) =>{
      this.itemCategory = val;
    })
  }

  listItems() {
    this.itemService.browseItems().subscribe(
      (data) => {
        this.items = data;
        console.log("Fetched Items: ");
        console.log(this.items);
      },
      (error) => {
        console.log("Failed to fetch items: ");
        console.log(error);
      }
    )
  }

  added(item: Item): boolean {
    if (this.currentOrder.items.includes(item))
      return true;
    else
      return false;
  }

  addToCart(item: Item) {
    // if (!this.cartItems.includes(item)) {
    // this.currentOrder.items = this.orderItems;
    this.currentOrder.orderDate = this.date;
    this.currentOrder.supplier = this.supplier;
    let e = <HTMLInputElement>document.activeElement;
    let e1 = <HTMLInputElement>document.activeElement?.querySelector('span');
    if (!this.currentOrder.items.includes(item)) {
      // item.itemQuantity = 1;
      this.currentOrder.items.push(item);
      e1.innerHTML = " Added";
      e.classList.add("cart_added");
      console.log("no of items in cart: " + this.currentOrder.items.length + "\n" + JSON.stringify(this.currentOrder.items));

      this.cartService.addToCart(item);
    }
    else {
      let id: number = item.itemId;
      this.currentOrder.items.forEach((value, index) => { if (value.itemId == id) this.currentOrder.items.splice(index, 1); });
      e1.innerHTML = " Add";
      e.classList.remove("cart_added");
      this.added(item);
      console.log("no of items in cart: " + this.currentOrder.items.length + "\n" + JSON.stringify(this.currentOrder.items));
      this.cartService.clearCartItem(item);
    }
  }
  //     else {
  //       Swal.fire({
  //         icon: 'error',
  //         title: 'Oops...',
  //         text: 'Item already exists in the cart!'
  //       })
  //     }

  // }

  orderStatus(item: Item) {
    let e = <HTMLInputElement>document.activeElement;
    let e1 = <HTMLInputElement>document.activeElement?.querySelector('span');
    if (!this.currentOrder.items.includes(item)) {
      e1.innerHTML = " Added";
      e.classList.add("cart_added");
    }
    else {
      e1.innerHTML = " Add";
      e.classList.remove("cart_added");
      this.added(item);
    }
  }

  switchToCart(item: Item){
    console.log("abc");
    this.BuyNow(item);
    this.router.navigate(['cart']);
  }

  BuyNow(item: Item) {
    // if (!this.cartItems.includes(item)) {
    // this.currentOrder.items = this.orderItems;
    this.currentOrder.orderDate = this.date;
    this.currentOrder.supplier = this.supplier;
    let e = <HTMLInputElement>document.activeElement;
    let e1 = <HTMLInputElement>document.activeElement?.querySelector('span');
    if (!this.currentOrder.items.includes(item)) {
      // item.itemQuantity = 1;
      this.currentOrder.items.push(item);
      e.classList.add("cart_added");
      console.log("no of items in cart: " + this.currentOrder.items.length + "\n" + JSON.stringify(this.currentOrder.items));

      this.cartService.addToCart(item);
    }
    else {
      let id: number = item.itemId;
      this.currentOrder.items.forEach((value, index) => { if (value.itemId == id) this.currentOrder.items.splice(index, 1); });
      e1.innerHTML = " Add";
      e.classList.remove("cart_added");
      this.added(item);
      console.log("no of items in cart: " + this.currentOrder.items.length + "\n" + JSON.stringify(this.currentOrder.items));
      this.cartService.clearCartItem(item);
    }
  }


}



