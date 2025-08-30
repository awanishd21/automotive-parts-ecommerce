import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>Automotive Parts Portal</h1>
    <app-part-search (search)="onPartSearch($event)"></app-part-search>
    <app-dealer-list
      [city]="city"
      [part]="part"
      (dealerSelected)="onDealerSelected($event)">
    </app-dealer-list>
    <app-order
      [part]="part"
      [city]="city"
      [dealer]="selectedDealer">
    </app-order>
  `
})
export class AppComponent {
  city = '';
  part = '';
  selectedDealer: any = null;
  onPartSearch(event: { part: string, city: string }) {
    this.part = event.part;
    this.city = event.city;
    this.selectedDealer = null;
  }
  onDealerSelected(dealer: any) {
    this.selectedDealer = dealer;
  }
}