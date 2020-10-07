import { Customer } from './customer';

export class AdminSearchCustomerStatus {
    public statusCode: string;
    public statusMessage: string;
    public customer: Customer = new Customer();
}
