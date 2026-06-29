interface CouponValidator{
    boolean validateCoupon(String code);
    static boolean isLengthValid(String code){
        return code.length() >= 5 && code.length() <= 10;
    }
}
class ShoppingCart implements CouponValidator{
    @Override
    public boolean validateCoupon(String code){
        if( !CouponValidator.isLengthValid(code)) {
            return false;
        }

        // Coupon must start with "DISC"
        if (!code.startsWith("DISC")) {
            return false;
        }

        return true;
    }
}

public class Main {
    public static void main(String[] args) {

        String[] coupons = {
            "DISC10",
            "DISC50",
            "SALE20",
            "DISC",
            "DISCOUNT100",
            "DISC25"
        };

        ShoppingCart cart = new ShoppingCart();

        for (String coupon : coupons) {
            if (cart.validateCoupon(coupon)) {
                System.out.println(coupon + " -> Valid Coupon");
            } else {
                System.out.println(coupon + " -> Invalid Coupon");
            }
        }
    }
}
