import { Component, Input, OnChanges } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-order',
  template: `
    <div *ngIf="part && city">
      <h3>Place Order</h3>
      <button (click)="placeOrder()" [disabled]="orderStatus">Place Order{{dealer ? ' With Selected Dealer' : ' (Auto Assign)'}}</button>
      <div *ngIf="orderStatus">{{orderStatus}}</div>
    </div>
  `
})
export class OrderComponent implements OnChanges {
  @Input() part = '';
  @Input() city = '';
  @Input() dealer: any = null;
  orderStatus = '';

  constructor(private http: HttpClient) {}

  ngOnChanges() {
    this.orderStatus = '';
  }

  placeOrder() {
    // 1. Create order
    this.http.post<any>('http://localhost:8081/orders', {
      partName: this.part,
      customerLocation: this.city
    }).subscribe(order => {
      // 2. Assign dealer
      this.http.post<any>('http://localhost:8083/dealer-selection/assign', {
        orderId: order.id,
        customerLocation: this.city,
        dealerId: this.dealer ? this.dealer.id : null
      }).subscribe(resp => {
        this.orderStatus = resp.status === 'ASSIGNED'
          ? `Order placed! Assigned Dealer ID: ${resp.assignedDealerId}`
          : 'Order placement failed';
      });
    });
  }
}