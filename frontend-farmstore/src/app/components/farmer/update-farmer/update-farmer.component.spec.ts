import { ComponentFixture, TestBed } from '@angular/core/testing';

import { UpdateFarmerComponent } from './update-farmer.component';

describe('UpdateFarmerComponent', () => {
  let component: UpdateFarmerComponent;
  let fixture: ComponentFixture<UpdateFarmerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ UpdateFarmerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(UpdateFarmerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
