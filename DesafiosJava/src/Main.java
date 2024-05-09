import java.util.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);


        /*INICIANDO PROJETO E INSTANCIANDO UMA LISTA QUE CONTENHA OS PRODUTOS*/

        Map<Integer, Product > products = new HashMap<>() {{
            put(1011, new Product("Alcatra",1011,0.035));
            put(1111,  new Product("File",1111,0.033));
            put(1001, new Product("Coxão mole",1001,0.032));
            put(1010, new Product("Patinho",1010,0.030));

        }};

        System.out.println("1011 - Alcatra");
        System.out.println("1111 - Filé");
        System.out.println("1001 - Coxão Mole");
        System.out.println("1010 - Patinho");
        System.out.println("Type code of product:");
        int typed = sc.nextInt();

        if (products.containsKey(typed)) {
            System.out.println("How many grams do you want?");
            int weight = sc.nextInt();

            if(weight > 200000 || weight < 0){
                System.out.println("Weight Invalid");

            } else {
                double total = products.get(typed).calculateWeight(weight);
                System.out.println(products.get(typed).toString());
                System.out.println("Total: R$" + total);
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
}