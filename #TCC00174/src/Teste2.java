
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Teste2 {

  public static void main(String[] args) {

    Map<String, Double> matrizes = new HashMap<>();
    Map<String, Double> escalares = new HashMap<>();

    escalares.put("c", 120.67);
    double var = escalares.get("c");

    for (Entry<String, Double> var2 : escalares.entrySet()) {
      var2.getValue();
      var2.getKey();
    }


  }
}
