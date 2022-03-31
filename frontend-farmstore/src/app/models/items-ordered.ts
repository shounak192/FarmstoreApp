import { Category } from "./category";

export class ItemsOrdered {
    itemId:number = 0;
    itemName:string = '';
    itemQuantity:number = 0;
    itemPrice:number = 0;
    itemCategory:Category = Category.GRAINS;

    constructor(){
        
    }
}
