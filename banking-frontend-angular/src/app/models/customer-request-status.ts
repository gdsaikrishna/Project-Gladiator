import { Customer } from './customer';

export class CustomerRequestStatus {
    public statusCode: string;
    public statusMessage: string;
    public customers: Customer[]=[];
}
