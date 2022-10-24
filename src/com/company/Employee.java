package com.company;

public class Employee {

    /* GÖREV:
    Java'da "Employee" adında fabrika çalışanlarını temsil eden ve metotları ile çalışanların
    maaşlarını hesaplayan bir sınıf yazmalısınız. Bu sınıf 4 nitelik ve 5 metoda sahip olacaktır.
    Sizden konsol çıktısı halinde Adı, maaşı, çalışma saati, başlangıç yılı, vergi, bonus, maaş artışı,
    vergi ve bonuslarla birlikte maaş, toplam maaş değerlerini konsola yazdırmanızı bekliyoruz.
    */

    /*
    Sınıfın Nitelikleri
    name : Çalışanın adı ve soyadı
    salary : Çalışanın maaşı
    workHours : Haftalık çalışma saati
    hireYear : İşe başlangıç yılı
    */

    String name;
    double salary;
    int workHours;
    int hireYear;

    //Employee(name,salary,workHours,hireYear) : Kurucu metot olup 4 parametre alacaktır.

    public Employee(String name, double salary, int workHours, int hireYear) {
        this.name = name;
        this.salary = salary;
        this.workHours = workHours;
        this.hireYear = hireYear;
    }

    /*
    tax() : Maaşa uygulanan vergiyi hesaplayacaktır.
    Çalışanın maaşı 1000 TL'den az ise vergi uygulanmayacaktır.
    Çalışanın maaşı 1000 TL'den fazla ise maaşının %3'ü kadar vergi uygulanacaktır.
     */

    public double tax() {

        double tax = 0;

        if (salary <= 1000) {
            tax = 0;
        } else if (salary > 1000) {
            tax = salary * 3 / 100;
        }
        return tax;
    }

    /*
    bonus() : Eğer çalışan haftada 40 saatten fazla çalışmış ise fazladan çalıştığı
    her saat başına 30 TL olacak şekilde bonus ücretleri hesaplayacaktır.
     */

    public double bonus() {

        double bonus = 0;

        if (workHours > 40) {
            bonus += (workHours - 40) * 30 * 4;
        }
        return bonus;
    }

    /*
    raiseSalary() : Çalışanın işe başlangıç yılına göre maaş artışını hesaplayacaktır. Şuan ki yılı 2021 olarak alın.
    Eğer çalışan 10 yıldan az bir süredir çalışıyorsa maaşına %5 zam yapılacaktır.
    Eğer çalışan 9 yıldan fazla ve 20 yıldan az çalışıyorsa maaşına %10 zam yapılacaktır.
    Eğer çalışan 19 yıldan fazla çalışıyorsa %15 zam yapılacaktır.
     */

    public double raiseSalary() {

        double raiseSalary = 0;

        int currentYear = 2021;
        if ((currentYear - hireYear) < 10) {
            raiseSalary = salary * 5 / 100;
        } else if ((currentYear - hireYear) >= 10 && (currentYear - hireYear) < 20) {
            raiseSalary = salary * 10 / 100;
        } else if ((currentYear - hireYear) >= 20) {
            raiseSalary = salary * 15 / 100;
        }

        return raiseSalary;
    }

    /*
    toString() : Çalışana ait bilgileri ekrana bastıracaktır.
     */

    @Override
    public String toString() {
        return  "name=" + name + "\n" +
                "salary=" + salary + "\n" +
                "workHours=" + workHours + "\n" +
                "hireYear=" + hireYear + "\n" +
                "tax=" + tax() + "\n" +
                "bonus=" + bonus() + "\n" +
                "raiseSalary=" + raiseSalary() + "\n" +
                "salaryWithTaxAndBonus=" + (salary - tax() + bonus()) + "\n" +
                "totalSalary=" + (salary - tax() + bonus() + raiseSalary());
    }

}
