import { GroceryList } from './GroceryList';

export interface Item {
  itemId: number;
  list: GroceryList;
  itemName: string;
  itemType: string;
}
