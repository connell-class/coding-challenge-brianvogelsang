import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { GroceryList } from '../models/GroceryList';
import { Item } from '../models/item';

@Injectable({
  providedIn: 'root',
})
export class ListGetterService {
  constructor(private http: HttpClient) {}

  getLists(): Promise<GroceryList[]> {
    return this.http
      .get<GroceryList[]>('http://localhost:9002/grocery-lists')
      .toPromise();
  }

  getListById(id: number): Promise<GroceryList> {
    return this.http
      .get<GroceryList>('http://localhost:9002/grocery-lists/' + id)
      .toPromise();
  }

  getItemsByListId(id: number): Promise<Item[]> {
    return this.http
      .get<Item[]>('http://localhost:9002/grocery-lists/items/lists/' + id)
      .toPromise();
  }

  addTable(g: GroceryList): Promise<GroceryList> {
    return this.http
      .post<GroceryList>('http://localhost:9002/grocery-lists', g)
      .toPromise();
  }

  deleteTable(id: number): Promise<any> {
    const headers = new HttpHeaders().set(
      'Content-Type',
      'text/plain; charset=utf-8'
    );
    return this.http
      .delete('http://localhost:9002/grocery-lists/' + id, {
        headers,
        responseType: 'text',
      })
      .toPromise();
  }

  addItemToTable(item: Item, id: number): Promise<Item> {
    return this.http
      .post<Item>('http://localhost:9002/grocery-lists/items/' + id, item)
      .toPromise();
  }

  deleteItem(id: number): Promise<any> {
    const headers = new HttpHeaders().set(
      'Content-Type',
      'text/plain; charset=utf-8'
    );
    return this.http
      .delete('http://localhost:9002/grocery-lists/items/' + id, {
        headers,
        responseType: 'text',
      })
      .toPromise();
  }
}
