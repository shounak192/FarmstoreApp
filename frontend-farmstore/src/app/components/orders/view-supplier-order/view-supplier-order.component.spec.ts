import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewSupplierOrderComponent } from './view-supplier-order.component';

describe('ViewSupplierOrderComponent', () => {
  let component: ViewSupplierOrderComponent;
  let fixture: ComponentFixture<ViewSupplierOrderComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewSupplierOrderComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewSupplierOrderComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
