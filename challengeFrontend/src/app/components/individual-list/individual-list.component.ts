import { Component, OnInit, Input } from '@angular/core';
import { GroceryList } from 'src/app/models/GroceryList';
import { ListGetterService } from 'src/app/services/list-getter.service';
import { Item } from 'src/app/models/item';
import { Router } from '@angular/router';

@Component({
  selector: 'app-individual-list',
  templateUrl: './individual-list.component.html',
  styleUrls: ['./individual-list.component.scss'],
})
export class IndividualListComponent implements OnInit {
  constructor(private listGetter: ListGetterService, private router: Router) {}

  @Input() passIndex: number;

  myIndex: number = 0;

  myList: GroceryList = {
    listId: 0,
    listName: 'null',
  };

  myItems: Item[] = [];

  newItem: Item = {
    itemId: 0,
    list: {
      listId: 0,
      listName: null,
    },
    itemName: '',
    itemType: '',
  };

  ngOnInit(): void {
    this.listGetter.getListById(this.passIndex).then((data) => {
      this.myList = data;
      this.myIndex = this.passIndex;
      this.listGetter.getItemsByListId(this.myIndex).then((data) => {
        for (let i of data) {
          this.myItems.push(i);
        }
      });
    });
  }

  clickBackButton() {
    this.router.navigate(['main']);
  }

  clickAddItem(item: Item) {
    if (this.newItem.itemName != '') {
      if (this.newItem.itemType != '') {
        this.listGetter.getListById(this.myIndex).then((data) => {
          item.list = data;
        });
        this.listGetter.addItemToTable(item, this.passIndex).then((data) => {
          this.myItems = [];
          this.listGetter.getItemsByListId(this.myIndex).then((data) => {
            for (let i of data) {
              this.myItems.push(i);
            }
          });
        });
      }
    }
  }

  clickDeleteItem(id: number) {
    this.listGetter.deleteItem(id).then((data) => {
      this.myItems = [];
      this.listGetter.getItemsByListId(this.myIndex).then((data) => {
        for (let i of data) {
          this.myItems.push(i);
        }
      });
    });
  }
}
