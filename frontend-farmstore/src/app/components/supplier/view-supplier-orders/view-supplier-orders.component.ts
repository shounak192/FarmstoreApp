import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { CartComponent } from 'app/components/orders/cart/cart.component';
import { Category } from 'app/models/category';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { ItemsOrdered } from 'app/models/items-ordered';
import { Orders } from 'app/models/orders';
import { Supplier } from 'app/models/supplier';
import { AuthService } from 'app/services/auth.service';
import { LoginService } from 'app/services/login.service';
import { OrdersService } from 'app/services/orders.service';
import { SupplierService } from 'app/services/supplier.service';

@Component({
  selector: 'app-view-supplier-orders',
  templateUrl: './view-supplier-orders.component.html',
  styleUrls: ['./view-supplier-orders.component.css']
})
export class ViewSupplierOrdersComponent implements OnInit {

  orders:Orders = new Orders();
  item: ItemsOrdered[]=[]; 
  
  constructor(private supplierService: SupplierService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private loginService: LoginService,
    private authService: AuthService,
    private orderService: OrdersService) { 
      // this.router.navigate(['view-supplier-order']);
    }
  

  ngOnInit(): void {
    let orderId: any = this.activatedRoute.snapshot.paramMap.get('orderId');
    console.log(orderId);
    this.orderService.viewOrderByOrderId(orderId).subscribe((response) => {
      this.orders = response;
      this.item = this.orders.items;
      console.log(this.orders.items);
    },
    (error)=>{ console.log(error.error)})
  }

}
