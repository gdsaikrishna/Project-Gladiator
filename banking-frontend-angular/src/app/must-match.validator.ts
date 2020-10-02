import { FormGroup } from '@angular/forms';

export function MustMatch(controlName: string, matchingControlName: string, txName: string, ctxName: string) {
    return (formGroup: FormGroup) => {
        const userPassword = formGroup.controls[controlName];
        const cuserPassword = formGroup.controls[matchingControlName];
        const txPassword = formGroup.controls[txName];
        const ctxPassword = formGroup.controls[ctxName];

        if (!userPassword || !cuserPassword || !txPassword || !ctxPassword) {
          return null;
        }

        if (cuserPassword.errors && !cuserPassword.errors.mustMatch && ctxPassword.errors && !ctxPassword.errors.mustMatch) {
            return null;
        }

        if (userPassword.value !== cuserPassword.value) {
            cuserPassword.setErrors({ mustMatch: true });
        } else {
            cuserPassword.setErrors(null);
        }
        if (txPassword.value !== ctxPassword.value) {
            ctxPassword.setErrors({ mustMatch: true });
        } else {
            ctxPassword.setErrors(null);
        }
    }
}