import { Component, Input, Output, EventEmitter, OnChanges } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-dealer-list',
  template: `
    <div *ngIf="dealers.length">
      <h3>Nearby Dealers</h3>
      <ul>
        <li *ngFor="let dealer of dealers">
          {{dealer.name}} ({{dealer.address}})
          <button (click)="selectDealer(dealer)">Select</button>
        </li>
      </ul>
      <button (click)="selectDealer(null)">Auto Assign Dealer</button>
    </div>
  `
})
export class DealerListComponent implements OnChanges {
  @Input() city = '';
  @Input() part = '';
  @Output() dealerSelected = new EventEmitter<any>();
  dealers: any[] = [];
  constructor(private http: HttpClient) {}

  ngOnChanges() {
    if (this.city) {
      this.http.get<any[]>(`http://localhost:8082/dealers/city/${this.city}`)
        .subscribe(res => this.dealers = res);
    }
  }

  selectDealer(dealer: any) {
    this.dealerSelected.emit(dealer);
  }
}