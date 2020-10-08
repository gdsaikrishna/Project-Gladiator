import { StatementTransactionDto } from './account-statement';

export class  AccountStatementStatus{
    statusCode:string;
    statusMessage:string;
    statementTransaction:StatementTransactionDto[];
}