import { Component, Input, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-orders',
  template: `
    <h3>Your Orders</h3>
    <ul>
      <li *ngFor="let order of orders">
        Order #{{order.id}}: {{order.partName}} ({{order.status}})
        <button *ngIf="order.status !== 'COMPLETED'" (click)="fulfillOrder(order)">Mark as Fulfilled</button>
      </li>
    </ul>
    <button (click)="refresh()">Refresh</button>
  `
})
export class OrdersComponent implements OnInit {
  @Input() dealerId!: number;
  orders: any[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.loadOrders();
  }

  loadOrders() {
    this.http.get<any[]>(`http://localhost:8081/orders/dealer/${this.dealerId}`)
      .subscribe(res => this.orders = res);
  }

  fulfillOrder(order: any) {
    this.http.patch<any>(`http://localhost:8081/orders/${order.id}/status`, '"COMPLETED"', {
      headers: { 'Content-Type': 'application/json' }
    }).subscribe(() => {
      this.loadOrders();
    });
  }

  refresh() {
    this.loadOrders();
  }
}