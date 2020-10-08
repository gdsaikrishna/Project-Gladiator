export class StatementTransactionDto{
    public fromAccountNumber: number;
	public  toAccountNumber: number;
	public  amount: number;
	public  transactionType: string;
	public transactionId: number;
	public  remark: string;
    public  dateTime: number;
}