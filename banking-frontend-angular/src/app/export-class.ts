export class OpenAccount {

    public title: string;
    public firstName: string;
    public middleName: string;
    public lastName: string;
    public fatherName: string;
    public mobileNo: string;
    public emailId: string;
    public aadhaarNo: string;
    public dateOfBirth: Date;
    public resAddress: Address = new Address();
    public perAddress: Address = new Address();
    public occupationType: string;
    public sourceOfIncome: string;
    public grossAnnualIncome: number;
    public netBankingRequirement: string;
}

export class Address {
    public addressLine1: string;
    public addressLine2: string;
    public landmark: string;
    public state: string;
    public city: string;
    public pincode: number;
}

export class Account {
    constructor(public accountNumber: number, public balance: number, public accountType: string) { }
}

export class Transaction {
    constructor(public transactionId: number, public amount: number, public txType: string, public date: string, public remarks: string) { }
}