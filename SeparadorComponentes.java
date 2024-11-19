import java.util.Scanner;

public class EvaluadorExpresion {
   public static void main(String[] args) {
      Scanner scanner = new Scanner(System.in);

      System.out.print("a: ");
      int a = scanner.nextInt();
      System.out.print("b: ");
      int b = scanner.nextInt();
      System.out.print("c: ");
      int c = scanner.nextInt();
      System.out.print("z: ");
      int z = scanner.nextInt();
      scanner.nextLine();

      // a = 10 | b = 15 | c = 12 | z = 7
      System.out.print("Expresion: "); // (a<b*2 && (c-z)>(a/5) || (b%a) == (c%z)) && (a*2 <= b+z*2)
      String expresion = scanner.nextLine();

      boolean resultado = evaluarExpresion(expresion, a, b, c, z);
      System.out.println("Resultado: " + resultado);
      
      scanner.close();
   }

   public static boolean evaluarExpresion(String expresion, int a, int b, int c, int z) {
      expresion = expresion.replace("a", String.valueOf(a));
      expresion = expresion.replace("b", String.valueOf(b));
      expresion = expresion.replace("c", String.valueOf(c));
      expresion = expresion.replace("z", String.valueOf(z));
      return evaluarLogica(expresion);
   }

   public static boolean evaluarLogica(String expresion) {
      try {
         javax.script.ScriptEngine engine = new javax.script.ScriptEngineManager().getEngineByName("JavaScript");
         Object result = engine.eval(expresion);
         
         if (result instanceof Boolean) {
               return (Boolean) result;
         } else if (result instanceof Integer) {
               return ((Integer) result) != 0;
         }
      } catch (Exception e) {
         System.out.println("Error al evaluar la expresion:\n" + e.getMessage());
      }
      return false;
   }
}