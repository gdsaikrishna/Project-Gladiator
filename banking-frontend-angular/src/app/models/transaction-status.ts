import {Transaction} from './transaction'
export class TransactionStatus{

    public transactionSuccessDto:Transaction=new Transaction();
    public statusCode:string;
    public statusMessage:string;
}