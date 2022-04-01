import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Credentials } from 'app/models/credential';
import { Item } from 'app/models/item';
import { Orders } from 'app/models/orders';
import { Supplier } from 'app/models/supplier';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { CartService } from 'app/services/cart.service';
import { OrdersService } from 'app/services/orders.service';
import { SupplierService } from 'app/services/supplier.service';



@Component({
  selector: 'app-orders',
  templateUrl: './orders.component.html',
  styleUrls: ['./orders.component.css']
})
export class OrdersComponent implements OnInit {

  // addOrder: Orders =
  //   {
  //     orderId: 0,
  //     quantity: 0,
  //     price: 0,
  //     orderDate: new Date(),
  //     items: [],
  //     supplier: {
  //       supplierId: 0,
  //       supplierName: '',
  //       supplierMobile: '',
  //       supplierLocation: '',
  //       orders: [],
  //       "credential": {
  //         "userName": '',
  //         "password": '',
  //         "userType": UserType.SUPPLIER
  //       }
  //     },
  //     deleted: 0
  //   }
  // cartTotal = 0;
  // addOrder: Orders = new Orders();
  // userName: string ='';
  // credential: Credentials = new Credentials();

  orders: Orders[]=[];
  items: Item[]=[];
  itemArr: Item[]=[];
  datePipe: any;
  itemId: any;

  constructor(private supplierService: SupplierService,
    private authService: AuthService,
    private cartService: CartService,
    private orderService: OrdersService,
    private activeRouter: ActivatedRoute) { }
  // // userData: any='';
  // ngOnInit(): void {
  //   this.userName= this.authService.getUserName() as string;
  //   this.supplierService.viewDetails(this.userName).subscribe((response) => {
  //     console.log('response' + response);
  //     this.addOrder.supplier = response;
  //     let c= this.authService.retrieveCredentialDetails();
  //     this.addOrder.supplier.credential = JSON.parse(c as string);
  //     console.log(this.addOrder.supplier);
  //     for (let i = 0; i < this.addOrder.items.length; i++) {
  //       this.addOrder.quantity += this.addOrder.items[i].itemQuantity;
  //       this.addOrder.price += (this.addOrder.items[i].itemPrice * this.addOrder.items[i].itemQuantity);
  //     }
  //   })

  //     this.addOrder.items = this.cartService.getItems();
  //     console.log(this.addOrder.items);
    
  //   // this.addOrder.items = [...this.cartService.getItems()];
    
  //   console.log(this.addOrder);
  //   this.orderService.addOrder(this.addOrder).subscribe((response) => {
  //     console.log(response);
  //     // this.addOrder.items = [];
  //     this.addOrder = response;
  //     this.cartService.clearCart();
  //   },
  //     (error) => {
  //       console.log(error);
  //     });
  // }
  
  // delete(id: number) {
  //   let orderId: any = this.activeRouter.snapshot.paramMap.get('orderId');
  //   this.orderService.deleteOrder(orderId).subscribe((response) => {
  //     console.log(response);
  //     // this.orderData=response;
  //   })
  // }

  // calcCartTotal() {
  //   this.cartTotal = 0;
  //   this.addOrder.items.forEach(item => {
  //     this.cartTotal += (item.itemQuantity * item.itemPrice)
  //   })
  // }
  ngOnInit(): void {
    this.itemId = this.activeRouter.snapshot.paramMap.get('itemId');
    this.orderService.viewOrder(this.itemId).subscribe((res)=>{
      this.orders = res;
      for(let i=0; i< this.orders.length; i++){
        this.orders[i].orderDate = this.datePipe.transform(new Date(), 'dd-MM-yyyy');
      }
      console.log(res);
    },
    (err)=>{
      alert(err);
    })
  }

}
