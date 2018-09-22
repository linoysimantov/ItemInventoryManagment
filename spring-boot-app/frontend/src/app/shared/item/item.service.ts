import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';
import {Item} from './item.model'

@Injectable()
export class ItemService {

 public API = '//localhost:8080';
  public ITEM_API = this.API + '/items';


  constructor(private http: HttpClient) {
  }

  getAll(): Observable<any> {
    return this.http.get(this.ITEM_API);
  }
   get(id: number) {
    return this.http.get(this.ITEM_API + '/' + id+ '/details');
  }
  
  save(item: Item) {
    const body: Item ={
      itemName: item.itemName,
      inventoryCode: item.inventoryCode,
      amount: item.amount
    };
      return this.http.post(this.ITEM_API, body);
      }
      
  deposit(depositNum: string, id:number) {
      return this.http.put(this.ITEM_API + '/' + id+ '/deposit/'+ depositNum, {},{});
  }
    withdrawal(withdrawalNum: string, id:  number) {
      return this.http.put(this.ITEM_API + '/' + id+ '/withdrawal/'+ withdrawalNum, {}, {});
  }
    delete(id:number){
            return this.http.delete(this.ITEM_API + '/' + id);

    }
  

  

  remove(href: string) {
    return this.http.delete(href);
  }
}