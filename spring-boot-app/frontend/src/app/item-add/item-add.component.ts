import { Component, OnInit  } from '@angular/core';
import { Subscription } from 'rxjs/Subscription';
import { ActivatedRoute, Router } from '@angular/router';
import { ItemService } from '../shared/item/item.service';
import { NgForm } from '@angular/forms';
import {Item} from '../shared/item/item.model';


@Component({
  selector: 'app-item-add',
  templateUrl: './item-add.component.html',
  styleUrls: ['./item-add.component.css']
})
export class ItemAddComponent implements OnInit {

 item = new Item();

  constructor(private route: ActivatedRoute,
              private router: Router,
              private itemService: ItemService,
             ) { }

 ngOnInit() {

    
  }
    resetForm(form?: NgForm) {
    if (form != null){
      form.reset();
    this.item = {
      itemName: 'ml',
      inventoryCode: 0,
      amount: 0,

       }
     }
  }


  gotoList() {
    this.router.navigate(['']);
  }

  save(itemForm: NgForm) {
 this.itemService.save(itemForm.value).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }

  remove(href) {
    this.itemService.remove(href).subscribe(result => {
      this.gotoList();
    }, error => console.error(error));
  }
  

}
