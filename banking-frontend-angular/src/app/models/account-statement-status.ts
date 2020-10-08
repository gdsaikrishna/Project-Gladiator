import { StatementTransactionDto } from './account-statement';

export class  AccountStatementStatus{
    public statusCode:string;
    public statusMessage:string;
    public statementTransactionDto:StatementTransactionDto[];
}