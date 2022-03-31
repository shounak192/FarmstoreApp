import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { OrdersComponent } from './components/orders/orders.component';
import { SupplierComponent } from './components/supplier/supplier.component';
import { ItemComponent } from './components/item/item.component';
import { FarmerComponent } from './components/farmer/farmer.component';
import { LoginComponent } from './components/login/login.component';
import { RegistrationComponent } from './components/registration/registration.component';
import { ViewSupplierComponent } from './components/supplier/view-supplier/view-supplier.component';
import { UpdateSupplierComponent } from './components/supplier/update-supplier/update-supplier.component';
import { ListSupplierOrdersComponent } from './components/supplier/list-supplier-orders/list-supplier-orders.component';
import { FormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';
import { ViewSupplierOrdersComponent } from './components/supplier/view-supplier-orders/view-supplier-orders.component';
import { CommonModule, DatePipe } from '@angular/common';
import { UpdateFarmerComponent } from './components/farmer/update-farmer/update-farmer.component';
import { AddItemComponent } from './components/farmer/add-item/add-item.component';
import { FarmerProfileComponent } from './components/farmer/farmer-profile/farmer-profile.component';
import { ViewItemsByFarmeridComponent } from './components/farmer/view-items-by-farmerid/view-items-by-farmerid.component';
import { ViewAllOrdersComponent } from './components/orders/view-all-orders/view-all-orders.component';
import { ListItemsComponent } from './components/item/list-items/list-items.component';
import { YesNoPipe } from './pipes/yes-no.pipe';
import { ViewAllItemsComponent } from './components/item/view-all-items/view-all-items.component';
import { ViewItemsComponent } from './components/item/view-items/view-items.component';
import { SearchPipe } from './pipes/search.pipe';
import { HeaderComponent } from './components/header/header.component';
import { FooterComponent } from './components/footer/footer.component';
import { ViewSupplierOrderComponent } from './components/orders/view-supplier-order/view-supplier-order.component';
import { CartComponent } from './components/orders/cart/cart.component';
import { ViewfarmerComponent } from './components/admin/viewfarmer/viewfarmer.component';
import { AdminComponent } from './components/admin/admin.component';
import { ViewsupplierComponent } from './components/admin/viewsupplier/viewsupplier.component';
import { AuthHttpInterceptorService } from './services/auth-http-interceptor.service';

@NgModule({
  declarations: [
    AppComponent,
    OrdersComponent,
    SupplierComponent,
    ItemComponent,
    FarmerComponent,
    LoginComponent,
    RegistrationComponent,
    ViewSupplierComponent,
    UpdateSupplierComponent,
    ListSupplierOrdersComponent,
    ViewSupplierOrdersComponent,
    UpdateFarmerComponent,
    AddItemComponent,
    FarmerProfileComponent,
    ViewAllOrdersComponent,
    ListItemsComponent,
    YesNoPipe,
    ViewItemsComponent,
    SearchPipe,
    AddItemComponent,
    ViewAllItemsComponent,
    HeaderComponent,
    FooterComponent,
    ViewSupplierOrderComponent,
    CartComponent,
    ViewfarmerComponent,
    AdminComponent,
    ViewsupplierComponent,
    ViewItemsByFarmeridComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule,
    AppRoutingModule,
    CommonModule
  ],
  providers: [
    {
      provide: HTTP_INTERCEPTORS, useClass: AuthHttpInterceptorService, multi: true
    },
    DatePipe
  ], 
  bootstrap: [AppComponent]
})
export class AppModule { }
