import { Component, OnInit } from '@angular/core';
import { ListGetterService } from 'src/app/services/list-getter.service';
import { GroceryList } from 'src/app/models/GroceryList';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-list-view',
  templateUrl: './list-view.component.html',
  styleUrls: ['./list-view.component.scss'],
})
export class ListViewComponent implements OnInit {
  constructor(
    private listGetter: ListGetterService,
    private cookieService: CookieService
  ) {}

  private cookieIndex: any;

  public passIndex: number = 1;

  myList: GroceryList = {
    listId: 0,
    listName: 'null',
  };

  ngOnInit(): void {
    this.cookieIndex = this.cookieService.get('currentList');
    this.passIndex = this.cookieIndex;

    this.listGetter.getListById(this.passIndex).then((data) => {
      this.myList = data;
    });
  }
}
