import { Component, OnInit } from '@angular/core';
import { ItemService } from '../shared/item/item.service';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';



@Component({
  selector: 'app-item-list',
  templateUrl: './item-list.component.html',
  styleUrls: ['./item-list.component.css']
})
export class ItemListComponent implements OnInit {

  items: Array<any>;

  constructor(private itemService:ItemService) { }

  ngOnInit() {
  this.itemService.getAll().subscribe(data => {
      this.items = data;
     
    });
  }
  delete(id:any){
           this.itemService.delete(id).subscribe(result => {
   location.reload();
        }, error => console.error(error));
   }
  
  

}
