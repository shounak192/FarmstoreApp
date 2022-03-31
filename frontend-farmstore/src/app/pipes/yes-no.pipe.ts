import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'yesNo'
})
export class YesNoPipe implements PipeTransform {

  transform(value: unknown, ...args: unknown[]): unknown {
    return value ? "YES" : "NO";
  }

}
