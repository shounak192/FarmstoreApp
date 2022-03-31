import { Category } from "./category"
import { Farmer } from "./farmer"
import { Orders } from "./orders";

export class Item {

    itemId:number = 0;
    itemName:string = '';
    itemQuantity:number = 0;
    itemPrice:number = 0;
    itemCategory:Category = Category.GRAINS;
    farmer:Farmer = new Farmer();
    //orders:Array<Orders> = [];
    verified:boolean = false;
    
    constructor() {}

}
