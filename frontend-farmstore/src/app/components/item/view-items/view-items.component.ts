import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Credentials } from 'app/models/credential';
import { Farmer } from 'app/models/farmer';
import { Item } from 'app/models/item';
import { UserType } from 'app/models/userType';
import { AuthService } from 'app/services/auth.service';
import { FarmerService } from 'app/services/farmer.service';
import { ItemService } from 'app/services/item.service';
import Swal from 'sweetalert2';
@Component({
  selector: 'app-view-items',
  templateUrl: './view-items.component.html',
  styleUrls: ['./view-items.component.css']
})
export class ViewItemsComponent implements OnInit {

  farmer: Farmer = new Farmer();
  credential: Credentials = new Credentials();
  items: Item[] = [];
  editItem: Item = new Item();
  userName: string = '';
  item: Item = new Item();

  constructor(private itemService: ItemService,
    private authService: AuthService,
    private farmerService: FarmerService,
    private activeRouter: ActivatedRoute,
    private router: Router) { }

  ngOnInit(): void {
    this.userName = this.authService.getUserName() as string;
    this.farmerService.getFarmerByUserName(this.userName).subscribe((response) => {
      console.log('response' + response);
      this.farmer = response;
      this.viewItems(this.farmer.farmerId);
    });
  }

  updateItem(item: Item, ngForm: NgForm) {
    if (!ngForm.dirty) {
      Swal.fire({
        title: 'No changes made!',
        icon: 'warning',
        confirmButtonColor: '#3085d6',
        confirmButtonText: 'OK'
      })
      this.ngOnInit();
    } else {
      item.verified=false;
      this.itemService.updateItem(item).subscribe(
        (data) => {
          this.item = data;
          console.log("Updated Item: ");
          console.log(this.item);
          Swal.fire('Details Updated and sent for verification','','success');
        },
        (error) => {
          console.log("Failed to update item: ");
          console.log(error);
        }
      );
    }

  }

  deleteItem(itemId: number) {
    // this.router.navigate(['view-items', itemId]);
    Swal.fire({
      title: 'Are you sure?',
      text: "You won't be able to revert this!",
      icon: 'warning',
      showCancelButton: true,
      confirmButtonColor: '#3085d6',
      cancelButtonColor: '#d33',
      confirmButtonText: 'Yes, delete it!'
    }).then((result) => {
      // let itemId: any = this.activeRouter.snapshot.paramMap.get('itemId');
      this.itemService.removeItem(itemId).subscribe((response) => {
        console.log(response);
        this.items = response;
        // this.ngOnInit();
        if (result.isConfirmed) {
          Swal.fire(
            'Deleted!',
            'Your file has been deleted.',
            'success'
          )
        }
        location.reload();
      },
        (error) => {
          console.log(error);
          alert("Item not deleted!");
        });
    })

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


onCloseHandled(editItem: Item) {
  // if (this.editItem == editItem)
  //   alert("No changes made!");
  location.reload();
}

}
