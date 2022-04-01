import { Credentials } from "./credential";
import { Orders } from "./orders";

export class Supplier {

    supplierId:number = 0;
    supplierName:string = '';
    supplierMobile:string = '';
    supplierEmail:string='';
    supplierLocation:string = '';
    // orders:Orders[] = [];
    credential:Credentials = new Credentials();

    constructor() {}

}
