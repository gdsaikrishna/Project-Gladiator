export class StatementTransactionDto{
    public fromAccountNumber: number;
	public  toAccountNumber: number;
	public  amount: number;
	public  transactionType: string;
	public transactionId: number;
	public  remark: string;
    public  dateTime: number;
}

export class TransactionDisplay{

	public accountNumber: number;
	  public  amount: number;
	  public  transactionType: string;
	  public transactionId: number;
	  public  remark: string;
	public  dateTime: number;
	public check: string;
  
  }
  