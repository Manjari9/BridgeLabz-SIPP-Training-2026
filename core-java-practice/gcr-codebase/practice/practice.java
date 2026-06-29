public class practice {
    public static void main(String[] args) throws Exception{
        int i=0;
        try{
            FileReader fr = new FileReader(fileName:"question.txt");
        }
        catch(NullPointerException e){
            System.out.println(e.getMessage());
        }
        catch(RuntimeException e){
            System.out.println(e.getMessage());
        }
        catch(Exception e){
            System.out.println("xyzException");
        }
        func1();
        System.out.printn("xyz");
    }
    static void func1() throws Exception{
        int i=1;
        int age=10;
        System.out.println("age is:"+age);
        if(age<18){
            throw new Exception("age is less than 18");
        }
    }
    
}
class AgeisWrong extends Exception{
    public String getMessage(){
        return "age is less than 18";
    }
