import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Farmer } from 'app/models/farmer';
import { UserType } from 'app/models/userType';
import { FarmerService } from 'app/services/farmer.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-update-farmer',
  templateUrl: './update-farmer.component.html',
  styleUrls: ['./update-farmer.component.css']
})
export class UpdateFarmerComponent implements OnInit {

  constructor(
    private activatedRoute: ActivatedRoute,
    private router: Router,
    private farmerService:FarmerService) { }

    farmer: Farmer= new Farmer();

  ngOnInit(): void {
    let username: any = this.activatedRoute.snapshot.paramMap.get('username');
    console.log(username);
    this.farmerService.getFarmerByUserName(username).subscribe((response) => {
      console.log('response' + response)
      this.farmer = response;
      console.log(response);
    },
    (err)=>{alert(err.error.msg)});
  }

  navigateToFarmerHome() {
    this.router.navigate(['']);
  }

  isUpdated:boolean | undefined;

  updateFarmer() {
    console.log(this.farmer)
    this.farmerService.updateFarmer(this.farmer).subscribe((response) => {
      console.log(response);
      this.openSweetAlert();
    },
    (err)=>{alert(err.error.msg)});
  }
  
  openSweetAlert() {
    Swal.fire('Updated successfully!','','success')
  }




 
}
