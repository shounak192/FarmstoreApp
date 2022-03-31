import { Component, OnInit } from '@angular/core';
import { Supplier } from 'app/models/supplier';
import { ActivatedRoute, Router } from '@angular/router';
import { SupplierService } from 'app/services/supplier.service';
import { LoginService } from 'app/services/login.service';
import { AuthService } from 'app/services/auth.service';
import { Credentials } from 'app/models/credential';
import { NgForm } from '@angular/forms';
import Swal from 'sweetalert2';
import { THIS_EXPR } from '@angular/compiler/src/output/output_ast';
@Component({
  selector: 'app-view-supplier',
  templateUrl: './view-supplier.component.html',
  styleUrls: ['./view-supplier.component.css']
})
export class ViewSupplierComponent implements OnInit {

  
  constructor(private supplierService: SupplierService, 
              private router: Router, 
              private authService: AuthService) { }
  supplier:Supplier= new Supplier();
  userName: string ='';
  credential:Credentials = new Credentials();
  editSupplier: Supplier = new Supplier();
  ngOnInit(): void {
    this.userName = this.authService.getUserName() as string;
    this.supplierService.viewDetails(this.userName).subscribe((response) => {
      console.log('response' + JSON.stringify(response));
      this.supplier = response;
    },
    (err) => {
      alert(JSON.stringify(err));
    });
  }

  updateSupplier(supplier: Supplier) {
    this.authService.setUserName(supplier.credential.userName);
    this.supplierService.updateDetails(supplier).subscribe(
      (data) => {
        this.supplier = data;
        console.log("Updated Item: ");
        console.log(this.supplier);
        this.openSweetAlert();
        this.ngOnInit();
        location.reload();
        
      },
      (error) => {
        console.log("Failed to update item: ");
        console.log(error);
      }
    );

}

onCloseHandled(editSupplier: Supplier) {
  if (this.editSupplier == editSupplier){
    Swal.fire({
      title: 'No changes made!',
      icon: 'warning',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'OK'
    });
  }
  // location.reload();
  console.log(this.editSupplier);
}

openSweetAlert() {
  Swal.fire('Updated successfully!','','success')
}
  

}
