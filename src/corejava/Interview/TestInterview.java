package src.corejava.Interview;

import java.math.BigInteger;
import java.util.HashMap;

public class TestInterview {

    public static void main(String[] args) {
//        String pig = "length: 10";
//        String dog = "length: "+ pig.length();
//        System.out.println("Animals are" + pig == dog);

//        BigInteger fiveThousand = new BigInteger("5000");
//        BigInteger fiftyThousand = new BigInteger("50000");
//        BigInteger fiveHunderedThousand = new BigInteger("500000");
//        BigInteger total = BigInteger.ZERO;
//        total.add(fiveThousand);
//        total.add(fiftyThousand);
//        total.add(fiveHunderedThousand);
//        System.out.println(total.intValue());
        String out = "ADD_FILE";
        System.out.println(out.equals("ADD_FILE"));
        HashMap<String, String> map = new HashMap<>();
        map.put("ACV", "68");
        map.put("Awgvwe", "11");
        String check = "ACV";
        map.put("2rf", "ACAS");
        if (map.containsKey(check.toString())) {
            System.out.println(map.get("Awgvwe"));
        }
        if (map.get("Awgvwe").compareTo(map.get("ACV")) == 0) {
            System.out.println("CHECK");
        } else {
            System.out.println("TESTES");
        }
        Integer tets = 1231;
        Integer etewt = 1231;
        if (tets.compareTo(etewt) == 0) {
            System.out.println("soung");
        }


    }
}

