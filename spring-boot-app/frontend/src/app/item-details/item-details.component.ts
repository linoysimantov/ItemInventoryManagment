import { Observable } from 'rxjs/Observable';
import { Component, OnInit } from '@angular/core';
import { ItemService } from '../shared/item/item.service';
import { ActivatedRoute } from '@angular/router';
import { MatButtonModule, MatCardModule, MatInputModule, MatListModule, MatToolbarModule } from '@angular/material';



	

@Component({
  selector: 'app-item-details',
  templateUrl: './item-details.component.html',
  styleUrls: ['./item-details.component.css']
})
export class ItemDetailsComponent implements OnInit {
  item: any;
    itemId: number;
     private sub: any;

  constructor(private itemService:ItemService, private route: ActivatedRoute) { 
  }
  
  ngOnInit() {
    this.sub = this.route.params.subscribe(params => {
       this.itemId = +params['id']; 

       
    });
  this.itemService.get(this.itemId).subscribe(data => {
      this.item = data;
     
    });
    }
      deposit(depositNum){
         this.itemService.deposit(depositNum.value, this.itemId).subscribe(result => {
   location.reload();
  		  }, error => console.error(error));
 	 }
 	 
 	       withdrawal(withdrawalNum){
         this.itemService.withdrawal(withdrawalNum.value, this.itemId).subscribe(result => {
   location.reload();
  		  }, error => console.error(error));
 	 }
  

}
