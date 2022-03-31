import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSupplierOrdersComponent } from './view-supplier-orders.component';

describe('ViewSupplierOrdersComponent', () => {
  let component: ViewSupplierOrdersComponent;
  let fixture: ComponentFixture<ViewSupplierOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewSupplierOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSupplierOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
