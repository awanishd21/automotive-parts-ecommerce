import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DealerListComponent } from './dealer-list.component';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { NO_ERRORS_SCHEMA } from '@angular/core';

describe('DealerListComponent', () => {
  let component: DealerListComponent;
  let fixture: ComponentFixture<DealerListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ DealerListComponent ],
      imports: [ HttpClientTestingModule ],
      schemas: [NO_ERRORS_SCHEMA]
    }).compileComponents();

    fixture = TestBed.createComponent(DealerListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should emit dealerSelected event', () => {
    spyOn(component.dealerSelected, 'emit');
    const dealer = { name: 'Test Dealer' };
    component.selectDealer(dealer);
    expect(component.dealerSelected.emit).toHaveBeenCalledWith(dealer);
  });
});