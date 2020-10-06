import {Transaction} from './transaction'
export class TransactionSuccessfulDto{

    public transactionSuccessDto:Transaction=new Transaction();
    public statusCode:string;
    public statusMessage:string;
}