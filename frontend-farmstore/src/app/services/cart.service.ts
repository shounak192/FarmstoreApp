import { Injectable } from '@angular/core';
import { BehaviorSubject } from 'rxjs';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root'
})
export class CartService {

  public cartItems: Item[] = [];
  public itemList = new BehaviorSubject<any>([]);
  public search = new BehaviorSubject<string>("");
  public category = new BehaviorSubject<string>("");
  constructor() { }

  // getItems() {
  //   return this.itemList.asObservable();
  // }
  addToCart(ItemData: Item) {
    console.log(this.cartItems);
    this.cartItems.push(ItemData);
    console.log(this.cartItems);
    this.itemList.next(this.cartItems);
    console.log(this.cartItems);
  }

  setItem(item: Item){
    for(let i=0; i< this.cartItems.length; i++){
      if(this.cartItems[i].itemId == item.itemId)
      this.cartItems[i].itemQuantity = item.itemQuantity;
    }
  }

  getItems() {
    for(let i=0; i< this.cartItems.length; i++){
      this.cartItems[i].itemQuantity = 1;
    }
    return this.cartItems;
  }

  // clearCart(itemId: number) {
  //   console.log(itemId);

  //   const a = this.items.findIndex(b => b.itemId == itemId);
  //   if (a != -1) {

  //     this.items.splice(a, 1);
  //     return this.getItems();
  //   }
  //   else {
  //     return this.getItems();
  //   }
  // }

  getTotalPrice(): number {
    let grandTotal = 0;
    this.cartItems.map((a: any) => {
      grandTotal += a.total;
    })
    return grandTotal;
  }
  clearCartItem(item: Item) {
    this.cartItems.map((a: any, index: any) => {
      if (item.itemId === a.itemId) {
        this.cartItems.splice(index, 1);
      }
    })
    this.itemList.next(this.cartItems);
    return this.getItems();
  }
  clearCart() {
    this.cartItems = [];
    this.itemList.next(this.cartItems);
  }
}
