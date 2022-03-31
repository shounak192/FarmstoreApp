import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ViewItemsByFarmeridComponent } from './view-items-by-farmerid.component';

describe('ViewItemsByFarmeridComponent', () => {
  let component: ViewItemsByFarmeridComponent;
  let fixture: ComponentFixture<ViewItemsByFarmeridComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ViewItemsByFarmeridComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ViewItemsByFarmeridComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
