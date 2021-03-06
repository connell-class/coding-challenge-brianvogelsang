import { Component, OnInit } from '@angular/core';
import { ListGetterService } from 'src/app/services/list-getter.service';
import { GroceryList } from 'src/app/models/GroceryList';
import { Item } from 'src/app/models/item';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';

@Component({
  selector: 'app-lists',
  templateUrl: './lists.component.html',
  styleUrls: ['./lists.component.scss'],
})
export class ListsComponent implements OnInit {
  lists: GroceryList[] = [];
  items: Item[] = [];
  filterBar:string = '';

  myList: GroceryList = {
    listId: 0,
    listName: '',
  };

  cookieIndex: any = 0;

  constructor(
    private listGetter: ListGetterService,
    private cookieService: CookieService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.listGetter
      .getLists()
      .then((data) => {
        for (let y of data) {
          this.lists.push(y);
        }
      })
      .catch((e) => {
        console.log(e);
      });
  }

  redirectTo(uri: string) {
    this.router
      .navigateByUrl('/test', { skipLocationChange: true })
      .then(() => this.router.navigate([uri]));
  }

  clickListButton(list: GroceryList) {
    this.cookieIndex = list.listId;
    this.cookieIndex = this.cookieIndex.toString();
    this.cookieService.set('currentList', this.cookieIndex);
    this.router.navigate(['list']);
  }

  clickAddTable() {
    if (this.myList.listName.length > 63) {
      alert('List name must be less than 64 characters long, sorry!');
      return;
    }

    if (this.myList.listName != '') {
      this.listGetter.addTable(this.myList).then((data) => {
        this.lists = [];
        this.listGetter
          .getLists()
          .then((data) => {
            for (let y of data) {
              this.lists.push(y);
            }
            this.myList.listName = '';
          })
          .catch((e) => {
            alert('There was an error.');
          });
      });
    } else {
      alert('Enter new list name in text box.');
    }
  }

  clickDeleteButton(list: GroceryList) {
    this.listGetter.deleteTable(list.listId).then((data) => {
      this.lists = [];
      this.listGetter
        .getLists()
        .then((data) => {
          for (let y of data) {
            this.lists.push(y);
          }
        })
        .catch((e) => {
          alert('There was an error.');
        });
    });
  }
}
