export class TransactionDto{
    public userId:number;
    public fromAccountNumber: number;
    public toAccountNumber: number;
    public amount: number;
	public remarks: string;
	public transactionPassword: string;
	public transactionType: string;
}