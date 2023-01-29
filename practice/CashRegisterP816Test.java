package practice;

public class CashRegisterP816Test
{
    public static void main(String[] args)
    {
        CashRegisterP816 r1 = new CashRegisterP816(3);
        r1.addItem(0);
        System.out.println("r1.add(0): " + (r1.getCount() == 0 ? "OK" : "FAIL"));
        r1.addItem(1.2);
        System.out.println("r1.add(1.2): " + (r1.getCount() == 1 ? "OK" : "FAIL"));
        r1.addItem(2.3);
        System.out.println("r1.add(2.3): " + (r1.getCount() == 2 ? "OK" : "FAIL"));
        r1.addItem(-2);
        System.out.println("r1.add(-2): " + (r1.getCount() == 2 ? "OK" : "FAIL"));
        r1.addItem(1.4);
        System.out.println("r1.add(1.4): " + (r1.getCount() == 3 ? "OK" : "FAIL"));
        System.out.println("r1.add(1.4): " + (r1.getTotal() == 4.9 ? "OK" : "FAIL"));
        CashRegisterP816 r2 = new CashRegisterP816(5);
        r2.addItem(3);
        r2.addItem(5.2);
        r2.addItem(6);
        r2.addItem(7);
        System.out.println("r2.add(3, 5.2, 6, 7): " + (r2.getCount() == 4 ? "OK" : "FAIL"));
        System.out.println("r2.add(3, 5.2, 6, 7): " + (r2.getTotal() == 21.2 ? "OK" : "FAIL"));
        r2.addItem(9);
        System.out.println("r2.add(9): " + (r2.getCount() == 5 ? "OK" : "FAIL"));
        System.out.println("r2.add(9): " + (r2.getTotal() == 30.2 ? "OK" : "FAIL"));
        r2.addItem(7);
        System.out.println("r2.add(7): " + (r2.getCount() == 5 ? "OK" : "FAIL"));
        System.out.println("r2.add(7): " + (r2.getTotal() == 30.2 ? "OK" : "FAIL"));
        System.out.println("r1: " + (r1.getCount() == 3 ? "OK" : "FAIL"));
        System.out.println("r1: " + (r1.getTotal() == 4.9 ? "OK" : "FAIL"));
        r1.cancelLast();
        System.out.println("r1.cancelLast: " + (r1.getCount() == 2 ? "OK" : "FAIL"));
        System.out.println("r1.cancelLast: " + (r1.getTotal() == 3.5 ? "OK" : "FAIL"));
        r1.cancelLast();
        System.out.println("r1.cancelLast: " + (r1.getCount() == 1 ? "OK" : "FAIL"));
        System.out.println("r1.cancelLast: " + (r1.getTotal() == 1.2 ? "OK" : "FAIL"));
        r1.cancelLast();
        System.out.println("r1.cancelLast: " + (r1.getCount() == 0 ? "OK" : "FAIL"));
        System.out.println("r1.cancelLast: " + (r1.getTotal() == 0 ? "OK" : "FAIL"));
        r2.clear();
        System.out.println("r1.cancelLast: " + (r2.getCount() == 0 ? "OK" : "FAIL"));
        System.out.println("r1.cancelLast: " + (r2.getTotal() == 0 ? "OK" : "FAIL"));
        CashRegisterP816 r3 = new CashRegisterP816();
        r3.addItem(2.99);
        System.out.println("r3.addItem(2.99): " + (r3.getTotal() == 2.99 ? "OK" : "FAIL"));
        r3.cancelLast();
        System.out.println("r3.cancelLast: " + (r3.getTotal() == 0 ? "OK" : "FAIL"));
    }
}
