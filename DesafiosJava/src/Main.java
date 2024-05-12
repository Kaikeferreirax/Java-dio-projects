import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);
        DateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();

        /*INICIANDO PROJETO E INSTANCIANDO UMA LISTA QUE CONTENHA OS PRODUTOS*/

        Map<Integer, Product> products = new HashMap<>() {{
            put(1011, new Product("Alcatra", 1011, 0.0095));
            put(1111, new Product("File", 1111, 0.0073));
            put(1001, new Product("Coxão mole", 1001, 0.0082));
            put(1010, new Product("Patinho", 1010, 0.0080));

        }};

        Random random = new Random();


        // Register products
        System.out.println("Do you want to register products?(y/n)");
        char answer = sc.next().charAt(0);
        if (answer == 'y') {
            System.out.println("Code for Register products: ");
            int typedCod = sc.nextInt();
            int codePerm = 111000111;

            if (typedCod == codePerm) {
                int ids = random.nextInt(9999);
                System.out.println("Name product: ");
                sc.nextLine();
                String name = sc.nextLine();

                // already exists?
                Set<Map.Entry<Integer, Product>> entries2 = products.entrySet();
                for (Map.Entry<Integer, Product> entry1 : entries2) {
                    if (entry1.getValue().getName().equals(name)) {
                        throw new RuntimeException("This product is already registred!");
                    }
                }

                System.out.println("Price (KG): ");
                String priceStr = sc.nextLine();
                double price = toDouble(priceStr);
                //validation
                while (price  <  0) {
                    System.out.println("The value is invalid, Type again! ");
                    String otherPrice = sc.nextLine();
                    price = toDouble(otherPrice);
                }
                products.put(ids, new Product(name, ids, price));

            } else {
                System.out.println("Invalid code!");
            }

        }
            Set<Map.Entry<Integer, Product>> entries = products.entrySet();
            for (Map.Entry<Integer, Product> entry : entries) {
                System.out.println(entry.getKey() + " - " +
                        entry.getValue().getName()
                        + "- Price (KG) - $ "
                        + String.format("%.2f", entry.getValue().getPrice()));
            }

            System.out.println("Type code of product:");
            int typed = sc.nextInt();

            if (products.containsKey(typed)) {
                System.out.println("How many grams do you want?");
                int weight = sc.nextInt();

                if (weight > 200000 || weight < 0) {
                    System.out.println("Weight Invalid");

                } else {
                    double total = products.get(typed).calculateWeight(weight);
                    System.out.println(products.get(typed).toString());
                    System.out.println("Total: $" + String.format("%.2f", total));
                    System.out.println("Date: " + sdf.format(date));
                }

            } else {
                System.out.println("Product not found");
            }



       /*
        int typed = sc.nextInt();

        Set<Map.Entry<Integer,String>> entries = products.entrySet();

        for(Map.Entry<Integer,String> entry1 : entries){
            if(entry1.){

            }
        }

        if(products.containsKey(typed)){
            System.out.println(products.get(typed));
        } else {
            System.out.println("Product not found!");
        }
        */

        sc.close();
    }

    public static double toDouble(String price){
        String newPrice = price.replace(",",".");
        double valueConverted = - 1d;
        try {
            valueConverted =  Double.parseDouble(newPrice);
        }catch (NumberFormatException e) {
        }
        return valueConverted;
    }
}
