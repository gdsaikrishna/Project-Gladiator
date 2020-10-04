import { Customer } from './customer';

export class UserProfileStatus {
    public statusCode: string;
    public statusMessage: string;
    public customer: Customer = new Customer;
}
