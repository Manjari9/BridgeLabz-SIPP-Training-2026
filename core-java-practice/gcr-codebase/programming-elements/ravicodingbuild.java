import java.util.Scanner;
class ravicodingguild {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter name:");
        String name=sc.nextLine();
        System.out.println("Enter age:");
        int age =sc.nextInt();
        System.out.println("Enter rank:");
        int rank=sc.nextInt();
        System.out.println("Enter salary:");
        double salary=sc.nextDouble();
        System.out.println("enter Membership fee:");
        float membershipfee=sc.nextFloat();
        double bonus=salary*0.12;
        int annualbonus =(int)bonus;
        System.out.println("WECOME CARD");
        System.out.println("Name   :"+name);
        System.out.println("Age    :"+age);
        System.out.println("Rank   :"+rank);
        System.out.println("Salary  :"+salary);
        System.out.println("Membership fee   :"+membershipfee);
        System.out.println("Annual Bonus"+" "+annualbonus);}
    }
