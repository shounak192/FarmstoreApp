import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { Orders } from 'app/models/orders';
import { Supplier } from 'app/models/supplier';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { FarmerService } from 'app/services/farmer.service';
import { ItemService } from 'app/services/item.service';
import { OrdersService } from 'app/services/orders.service';

@Component({
  selector: 'app-view-supplier-order',
  templateUrl: './view-supplier-order.component.html',
  styleUrls: ['./view-supplier-order.component.css']
})
export class ViewSupplierOrderComponent implements OnInit {
  //  orderData = {
  //     orderId:0,
  //     quantity: 0,
  //     price: 0,
  //     orderDate: new Date(),
  //     // items: Item[],
  //     supplier:{ supplierId: 0,
  //       supplierName:  '',
  //       supplierMobile: '',
  //       supplierLocation: '',
  //       "credential": {
  //         "userName": '',
  //         "password": '',
  //         "userType": UserType.SUPPLIER
  //     }
  //   },
  //     deleted:  0
  //     }
  supplier: Supplier = new Supplier();
  items: Item[] = [];
  orders: Orders[] = [];
  userName: string='';
  farmer: Farmer = new Farmer();

  constructor(private activeRouter: ActivatedRoute, private authService: AuthService,
    private orderService: OrdersService, private router: Router, private farmerService: FarmerService, private itemService: ItemService) { }

  ngOnInit(): void {
    this.userName = this.authService.getUserName() as string;
    this.farmerService.getFarmerByUserName(this.userName).subscribe((response) => {
      console.log('response' + response);
      this.farmer = response;
      this.viewItems(this.farmer.farmerId);
    });
  }
  
  viewItems(farmerId: number) {
    this.itemService.viewItems(farmerId).subscribe(
      (data) => {
        this.items = data;
        console.log("Fetched Items: ");
        console.log(this.items);
      },
      (error) => {
        console.log("Failed to fetch items: ");
        console.log(error);
      }
    );
  }

  viewOrdersByItemId(itemId:number){
    this.router.navigate(['order',itemId]);
  }

}
