import { Component, OnInit } from '@angular/core';
import { Router } from "@angular/router";
import { RegistrationService } from 'app/services/registration.service';
import { UserType } from 'app/models/userType';
import { Orders } from 'app/models/orders';
import { Farmer } from 'app/models/farmer';
import { Supplier } from 'app/models/supplier';
import { HttpErrorResponse } from '@angular/common/http';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-registration',
  templateUrl: './registration.component.html',
  styleUrls: ['./registration.component.css']
})
export class RegistrationComponent implements OnInit {

  farmer: Farmer = new Farmer();
  supplier: Supplier = new Supplier();
  isFarmer: boolean = true;
  errorResponse: string='';
  successResponse: string='';
  validDetails = false;

  constructor(private registrationService: RegistrationService,
    private router: Router) { }

  ngOnInit(): void {
  }
  registerFarmer() {
    // console.log(this.farmer);
    this.farmer.credential.userType = UserType.FARMER;
    this.registrationService.registerFarmer(this.farmer).subscribe((response) => {
      this.successResponse = response.msg;
      this.validDetails = true;
      Swal.fire('Registered successfully!','','success');
      console.log(this.successResponse);
      this.router.navigate(['']);
    },
      (err) => {
        this.validDetails=false;
        this.errorResponse = err.error.msg;
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: this.errorResponse
        })
        console.log(this.errorResponse);
      })
  }

  setFarmer() {
    this.isFarmer = true;
  }
  setSupplier() {
    this.isFarmer = false;
  }

  registerSupplier() {
    console.log(this.supplier);
    this.registrationService.registerSupplier(this.supplier).subscribe((response) => {
      this.successResponse = response.msg;
      this.validDetails = true;
      Swal.fire('Registered successfully!','','success');
      console.log(this.successResponse);
      this.router.navigate(['']);
    },
      (err) => {
        this.validDetails=false;
        this.errorResponse = err.error.msg;
        Swal.fire({
          icon: 'error',
          title: 'Oops...',
          text: this.errorResponse
        })
        console.log(this.errorResponse);
      })
  }

}

