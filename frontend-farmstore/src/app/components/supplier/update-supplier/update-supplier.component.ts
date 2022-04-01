import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Supplier } from 'app/models/supplier';
import { SupplierService } from 'app/services/supplier.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-supplier',
  templateUrl: './update-supplier.component.html',
  styleUrls: ['./update-supplier.component.css']
})
export class UpdateSupplierComponent implements OnInit {

  errorResponse:string='';
  validDetails = false;
  supplier: Supplier = new Supplier();
  location:string[]=['Bangalore', 'Hyderabad','Chennai','Delhi','Mumbai','Kolkata','Ahmedabad','Kochi'];
  constructor(private supplierService:SupplierService, private router: Router) { }

  ngOnInit(): void {
  }

  // updateDetails(supplier:Supplier)
  // {
  //     this.supplierService.updateDetails(this.supplier).subscribe(
  //       (response)=>
  //       {
  //         this.supplier=response;
  //         this.openSweetAlert();
  //       },
  //       (err) =>
  //       {
  //         this.validDetails = false;
  //         this.errorResponse = err.error.msg;
  //       }
  //     )
  //   }
    openSweetAlert() {
      Swal.fire('Updated successfully!','','success')
    }

}
