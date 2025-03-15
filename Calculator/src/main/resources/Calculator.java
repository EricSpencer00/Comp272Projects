public class Calculator {
    public static double evaluate(String expression) throws Exception {
        return (double) new javax.script.ScriptEngineManager()
                .getEngineByName("JavaScript").eval(expression);
    }
}
