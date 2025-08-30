import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `
    <h1>Dealer Dashboard</h1>
    <app-login *ngIf="!dealerId" (loggedIn)="onLogin($event)"></app-login>
    <app-orders *ngIf="dealerId" [dealerId]="dealerId"></app-orders>
  `
})
export class AppComponent {
  dealerId: number | null = null;
  onLogin(id: number) {
    this.dealerId = id;
  }
}