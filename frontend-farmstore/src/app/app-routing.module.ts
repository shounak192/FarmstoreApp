import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { FarmerComponent } from './components/farmer/farmer.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from "./components/registration/registration.component";
import { SupplierComponent } from './components/supplier/supplier.component';
import { ListSupplierOrdersComponent } from './components/supplier/list-supplier-orders/list-supplier-orders.component';
import { UpdateSupplierComponent } from './components/supplier/update-supplier/update-supplier.component';
import { ViewSupplierOrdersComponent } from './components/supplier/view-supplier-orders/view-supplier-orders.component';
import { ViewSupplierComponent } from './components/supplier/view-supplier/view-supplier.component';
import { UpdateFarmerComponent } from './components/farmer/update-farmer/update-farmer.component';
import { ViewItemsByFarmeridComponent } from './components/farmer/view-items-by-farmerid/view-items-by-farmerid.component';
import { FarmerProfileComponent } from './components/farmer/farmer-profile/farmer-profile.component';
import { AddItemComponent } from './components/farmer/add-item/add-item.component';
import { AdminComponent } from './components/admin/admin.component';
import { ViewfarmerComponent } from './components/admin/viewfarmer/viewfarmer.component';
import { ViewsupplierComponent } from './components/admin/viewsupplier/viewsupplier.component';
import { OrdersComponent } from './components/orders/orders.component';
import { CartComponent } from './components/orders/cart/cart.component';
import { ViewAllOrdersComponent } from './components/orders/view-all-orders/view-all-orders.component';
import { ViewSupplierOrderComponent } from './components/orders/view-supplier-order/view-supplier-order.component';
import { ItemComponent } from './components/item/item.component';
import { ListItemsComponent } from './components/item/list-items/list-items.component';
import { ViewAllItemsComponent } from './components/item/view-all-items/view-all-items.component';
import { ViewItemsComponent } from './components/item/view-items/view-items.component';
const routes: Routes = [
  { path: '', component: LoginComponent },
  { path: 'register', component: RegistrationComponent },
  { path: 'farmer', component: FarmerComponent },
  { path: 'login', component: LoginComponent },
  { path: 'supplier', component: SupplierComponent },
  { path: 'view-supplier-details', component: ViewSupplierComponent },
  { path: 'update-supplier-details', component: UpdateSupplierComponent },
  { path: 'list-supplier-orders', component: ListSupplierOrdersComponent },
  { path: 'list-supplier-orders/:orderId', component: ListSupplierOrdersComponent },
  { path: 'view-supplier-orders/:orderId', component: ViewSupplierOrdersComponent },
  { path: 'update-farmer', component: UpdateFarmerComponent },
  { path: 'farmer/profile', component: FarmerProfileComponent },
  { path: 'add-item', component: AddItemComponent }, 
  { path: 'admin', component: AdminComponent },
  { path: 'viewfarmer', component: ViewfarmerComponent },
  { path: 'viewsupplier', component: ViewsupplierComponent },
  { path: "order/:itemId", component: OrdersComponent },
  { path: "cart", component: CartComponent },
  { path: "view-all-orders", component: ViewAllOrdersComponent },
  { path: "view-orderBy-ItemId", component: ViewSupplierOrderComponent },
  { path: "item", component: ItemComponent },
  { path: 'browse-items', component: ListItemsComponent },
  { path: 'view-items', component: ViewItemsComponent },
  { path: 'view-items/:itemId', component: ViewItemsComponent },
  { path: 'view-all-items', component: ViewAllItemsComponent },
  { path: 'view-items-by-farmerid', component: ViewItemsByFarmeridComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }


