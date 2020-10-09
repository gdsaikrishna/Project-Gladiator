import { FormGroup, ValidatorFn } from '@angular/forms';

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
        if (!userPassword) {
            return null;
        }
        /*
        const regex = new RegExp('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}');
        const valid = regex.test(controlName);
        return valid ? null : { invalidPassword: true };*/
    }
}



    export function ShouldMatch(controlName: string, matchingControlName: string) {
        return (formGroup: FormGroup) => {
            const newPassword = formGroup.controls[controlName];
            const cnewPassword = formGroup.controls[matchingControlName];
            if (!newPassword || !cnewPassword) {
                return null;
            }

            if (cnewPassword.errors && !cnewPassword.errors.shouldMatch) {
                return null;
            }

            if (newPassword.value !== cnewPassword.value) {
                cnewPassword.setErrors({ shouldMatch: true });
            } else {
                cnewPassword.setErrors(null);
            }
            if (!controlName) {
                return null;
            }
            /*const regex = new RegExp('(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[$@$!%*?&])[A-Za-z\d$@$!%*?&].{8,}');
            console.log("Here1")
            const valid = regex.test(controlName);
            console.log("Here")
            return valid ? null : { shouldMatch: true };*/
        }
    }