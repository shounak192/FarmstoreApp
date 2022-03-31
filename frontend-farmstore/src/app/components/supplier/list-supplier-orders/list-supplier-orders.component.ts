import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Credentials } from 'app/models/credential';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { Orders } from 'app/models/orders';
import { Supplier } from 'app/models/supplier';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { LoginService } from 'app/services/login.service';
import { OrdersService } from 'app/services/orders.service';
import { SupplierService } from 'app/services/supplier.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-list-supplier-orders',
  templateUrl: './list-supplier-orders.component.html',
  styleUrls: ['./list-supplier-orders.component.css']
})
export class ListSupplierOrdersComponent implements OnInit {

  allOrders: Orders[] = [];
  credential:Credentials = new Credentials();
  errorResponse:string='';
  validDetails = false;
  userName:string='';
  supplier: Supplier = new Supplier();
  datePipe: any;

  constructor(private supplierService: SupplierService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private loginService: LoginService,
    private authService: AuthService,
    private orderService: OrdersService) { }

  ngOnInit(): void {
    this.userName = this.authService.getUserName() as string;
    this.supplierService.viewDetails(this.userName).subscribe((response) => {
      console.log('response' + response);
      this.supplier = response;
    this.supplierService.viewOrders(this.supplier.supplierId).subscribe((response) => {
      console.log('response' + JSON.stringify(response));
      this.allOrders = response;
      for(let i=0; i< this.allOrders.length; i++){
        this.allOrders[i].orderDate = this.datePipe.transform(new Date(), 'dd-MM-yyyy');
      }
    },
      (err) => {
        this.validDetails = false;
        this.errorResponse = err.error.msg;
      });
  })
}
  
delete(order: Orders) {
  // this.router.navigate(['list-supplier-orders', orderId]);
  Swal.fire({
    title: 'Are you sure?',
    text: "You won't be able to revert this!",
    icon: 'warning',
    showCancelButton: true,
    confirmButtonColor: '#3085d6',
    cancelButtonColor: '#d33',
    confirmButtonText: 'Yes, delete it!'
  }).then((result) => {
    // let orderId : any = this.activatedRoute.snapshot.paramMap.get('orderId');
  this.orderService.deleteOrder(order).subscribe((response)=>{
      console.log(response);
      this.allOrders = response;
      // this.ngOnInit();
      if (result.isConfirmed) {
        Swal.fire(
          'Deleted!',
          'Your file has been deleted.',
          'success'
        );
        location.reload();
      }
    },
      (error) => {
        console.log(error);
        alert("Order not deleted!");
      });
  })

}
  viewOrderItems(orderId:number) {
    this.router.navigate(['view-supplier-orders', orderId])
  }

  
}
