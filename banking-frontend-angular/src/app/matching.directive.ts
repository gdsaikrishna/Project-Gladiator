import { Directive , Input } from '@angular/core';
import { NG_VALIDATORS, Validator, ValidationErrors, FormGroup, AbstractControl } from '@angular/forms';
import { ShouldMatch } from './must-match.validator';
@Directive({
  selector: '[appMatching]',
  providers: [{ provide: NG_VALIDATORS, useExisting: MatchingDirective, multi: true }]

})
export class MatchingDirective implements Validator  {
  @Input('appMatching') mustMatch: string[] = [];
  constructor() { }
  validate(formGroup: FormGroup): ValidationErrors {
    return ShouldMatch(this.mustMatch[0], this.mustMatch[1])(formGroup);
  }
}
