public class profit_and_loss {
    public static void main(String[] args) {
        int costPrice = 129;
        int sellingPrice = 191;
        
        int profit = sellingPrice - costPrice;
        double profitPercentage = (profit / (double) costPrice) * 100;
        
        System.out.println("Cost Price: INR " + costPrice + "\nSelling Price: INR " + sellingPrice + "\nProfit: INR " + profit + "\nProfit Percentage: " + profitPercentage + "%");
    }
}
