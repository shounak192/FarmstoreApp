import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'search'
})
export class SearchPipe implements PipeTransform {

  transform(value: any, args?: any): any {
    if (!value) return null;
    if (!args) return value;

    args = args.toLowerCase();
    return value.filter((data: any) => {
      if ((JSON.stringify(data.farmer.farmerLocation).toLowerCase().includes(args)) ||
        (JSON.stringify(data.itemName).toLowerCase().includes(args)) ||
        (JSON.stringify(data.itemCategory).toLowerCase().includes(args)))
        return data;
    });
  }
}
