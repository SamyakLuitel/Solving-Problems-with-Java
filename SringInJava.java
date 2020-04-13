public class SringInJava {
    public static void main(String[] args) {
        String s = "dukeprogramming";
        System.out.println(s.substring(4,7));
        System.out.println(s.substring(4));
        System.out.println(s.length());
        System.out.println(s.indexOf("program"));

        //Single quoted is to define char literals e.g char a = 'a';
        //Double quoted is to define String literals e.g String hello = “Hello”;

        System.out.println(s.indexOf("g"));
        System.out.println(s.indexOf("g",8));
        System.out.println(s.startsWith("duke"));
        System.out.println(s.endsWith("king"));
        System.out.println(s.endsWith("ing"));


    }
}
