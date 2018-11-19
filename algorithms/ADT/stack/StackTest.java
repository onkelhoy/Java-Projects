public class StackTest implements Test {
    
    @Override
    public void Run() {
        Stack s = new Stack();
        String str = "5 + 3 * 8 + ( 10 - 2 * 3 ) * 7 + 2"; // 5 + 24 + 30 = 59
        String[] splits = str.split(" ");
        System.out.println(splits.toString());
    }
}