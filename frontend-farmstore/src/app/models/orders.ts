import { Item } from "./item";
import { ItemsOrdered } from "./items-ordered";
import { Supplier } from "./supplier";

export class Orders {
    
    orderId:number = 0;
    quantity:number = 0;
    price:number = 0;
    orderDate:Date = new Date();
    items:ItemsOrdered[] = [];
    supplier:Supplier= new Supplier() ;
    

    constructor() {}

}
