import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Credentials } from 'app/models/credential';
import { Farmer } from 'app/models/farmer';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { FarmerService } from 'app/services/farmer.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-farmer-profile',
  templateUrl: './farmer-profile.component.html',
  styleUrls: ['./farmer-profile.component.css']
})
export class FarmerProfileComponent implements OnInit {

  constructor(
    private farmerService: FarmerService, 
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private authService: AuthService
  ) { }

  farmer: Farmer = new Farmer();
  userName: string ='';
  credential:Credentials = new Credentials();
  editFarmer: Farmer = new Farmer();

  ngOnInit(): void {
    this.userName = this.authService.getUserName() as string;
    this.farmerService.getFarmerByUserName(this.userName).subscribe((response) => {
      console.log('response' + JSON.stringify(response));
      this.farmer = response;
    },
    (err)=>{
    alert(err.error.msg);
    });
  }

  

  // navigateToFarmerHome() {
  //   this.router.navigate(['']);
  // }

  updateFarmer(farmer: Farmer, ngForm: NgForm) {
    this.authService.setUserName(farmer.credential.userName);
      this.farmerService.updateFarmer(farmer).subscribe(
        (data) => {
          this.farmer = data;
          console.log("Updated Item: ");
          console.log(this.farmer);
          this.openSweetAlert();
          this.ngOnInit();
        location.reload();
        },
        (error) => {
          console.log("Failed to update item: ");
          console.log(error.error.msg);
        }
      );
      
  }

  onCloseHandled(editFarmer: Farmer) {
    if (this.editFarmer == editFarmer){
    Swal.fire({
      title: 'No changes made!',
      icon: 'warning',
      confirmButtonColor: '#3085d6',
      confirmButtonText: 'OK'
    });
    }
}
  
  openSweetAlert() {
    Swal.fire('Updated successfully!','','success')
  }


}
