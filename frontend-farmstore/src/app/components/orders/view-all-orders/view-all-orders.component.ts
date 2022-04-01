import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { Orders } from 'app/models/orders';
import { UserType } from 'app/models/userType';
import { OrdersService } from 'app/services/orders.service';

@Component({
  selector: 'app-view-all-orders',
  templateUrl: './view-all-orders.component.html',
  styleUrls: ['./view-all-orders.component.css']
})
export class ViewAllOrdersComponent implements OnInit {
searchText:any;
listorder:Orders[]=[];
// orderData = {
//   orderId:0,
//   quantity: 0,
//   price: 0,
//   orderDate: new Date(),
//   // items: Item[],
//   supplier:{ supplierId: 0,
//     supplierName:  '',
//     supplierMobile: '',
//     supplierLocation: '',
//     orders: [],
//     "credential": {
//       "userName": '',
//       "password": '',
//       "userType": UserType
//   }
// },
//   deleted:  0
//   }
  constructor(private activeRouter : ActivatedRoute,
    private orderService : OrdersService) { }

  ngOnInit(): void {
    
  }

viewAllOrders(){
  this.orderService.viewAllOrders().subscribe((response)=>{
    this.listorder = response;
  })
}
}
