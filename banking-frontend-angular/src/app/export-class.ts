

export class Account {
    constructor(public accountNumber: number, public balance: number, public accountType: string) { }
}

export class Transaction {
    constructor(public transactionId: number, public amount: number, public txType: string, public date: string, public balance: number, public remarks: string) { }
}

export class Beneficiary {
    public name: string;
    public accountNumber: number;
    public nickName: string;
}
export class ForgotPassword {
    userId: number;
    otp: number;
}

export class ForgotUserId {
    accountNo: number;
}
