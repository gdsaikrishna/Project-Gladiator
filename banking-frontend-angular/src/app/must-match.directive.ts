import { Directive, Input } from '@angular/core';
import { NG_VALIDATORS, Validator, ValidationErrors, FormGroup } from '@angular/forms';
import { MustMatch } from './must-match.validator';
@Directive({
  selector: '[appMustMatch]',
  providers: [{ provide: NG_VALIDATORS, useExisting: MustMatchDirective, multi: true }]

})
export class MustMatchDirective implements Validator {
  @Input('appMustMatch') mustMatch: string[] = [];

  validate(formGroup: FormGroup): ValidationErrors {
      return MustMatch(this.mustMatch[0], this.mustMatch[1], this.mustMatch[2] , this.mustMatch[3])(formGroup);
  }

  /*@Input('passMustMatch') shouldMatch: string[] = [];

  check(formGroup: FormGroup): ValidationErrors {
      return ShouldMatch(this.shouldMatch[0], this.shouldMatch[1])(formGroup);
  }*/
}
