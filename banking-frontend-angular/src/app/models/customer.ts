import { Address } from "./address";


export class Customer {

    public serviceRefNo: number;
    public title: string;
    public firstName: string;
    public middleName: string;
    public lastName: string;
    public fatherName: string;
    public mobileNo: string;
    public emailId: string;
    public aadhaarNo: string;
    public panCard: string;
    public dateOfBirth: Date;
    public resAddress: Address = new Address();
    public perAddress: Address = new Address();
    public occupationType: string;
    public sourceOfIncome: string;
    public grossAnnualIncome: number;
    public netBankingRequirement: string;
    public debitCardRequirement: string;
}
