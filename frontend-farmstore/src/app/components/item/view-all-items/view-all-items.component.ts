import { Component, OnInit } from '@angular/core';
import { Item } from 'app/models/item';
import { ItemService } from 'app/services/item.service';
import Swal from 'sweetalert2';

@Component({
  selector: 'app-view-all-items',
  templateUrl: './view-all-items.component.html',
  styleUrls: ['./view-all-items.component.css']
})
export class ViewAllItemsComponent implements OnInit {

  items: Array<Item> = [];
  editItem: Item = new Item();
  verified_response: string = '';
  verified_status: boolean = false;

  constructor(private itemService: ItemService) { }

  ngOnInit(): void {
    this.viewAllItems();
  }

  verifyItem(itemId: number) {
    this.verified_status = false;
    this.itemService.verfiyItem(itemId).subscribe(
      (data) => {
        this.verified_response = data.msg;
        this.verified_status = true;
        console.log(data.msg);
        location.reload();
      },
      (error) => {
        console.log("Failed to verify item with id : " + itemId);
        console.log(error);
        this.verified_response = error.error;
      }
    );
  }

  viewAllItems() {
    this.itemService.viewAllItems().subscribe(
      (data) => {
        this.items = data;
        // let count = 0;
        // for (let i = 0; i < this.items.length; i++) {
        //   if (this.items[i].deleted == 1)
        //     count++;
        // }
        // if (count == this.items.length) this.deleted = true;
        console.log("Fetched Items: ");
        console.log(this.items);
      },
      (error) => {
        console.log("Failed to fetch items: ");
        console.log(error);
      }
    );
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
      },
        (error) => {
          console.log(error);
          alert("Item not deleted!");
        });
    })

  }

  onCloseHandled(editItem: Item) {
    if (this.editItem == editItem)
      alert("Item not verified yet!");
    location.reload();
  }
}
