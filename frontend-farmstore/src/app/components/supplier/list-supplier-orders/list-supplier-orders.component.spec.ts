import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListSupplierOrdersComponent } from './list-supplier-orders.component';

describe('ListSupplierOrdersComponent', () => {
  let component: ListSupplierOrdersComponent;
  let fixture: ComponentFixture<ListSupplierOrdersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListSupplierOrdersComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListSupplierOrdersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
