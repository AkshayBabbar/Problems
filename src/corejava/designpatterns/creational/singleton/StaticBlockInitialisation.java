package src.corejava.designpatterns.creational.singleton;

/**
 * @uthor: Akshay Babbar
 * @Purpose: The @Purpose of this class is that the static block initialisation of singleton design pattern.
 * This is similar to the eager initialisation.
 * The solution provided is done in Static Block.
 */
public class StaticBlockInitialisation {

    private static StaticBlockInitialisation INSTANCE;

    static {
        try {
            INSTANCE = new StaticBlockInitialisation();
        } catch (Exception e) {
            throw new RuntimeException("THe Exception occured while creating Static Block initailisation.");
        }
    }

    private StaticBlockInitialisation() {
    }

    public static StaticBlockInitialisation getINSTANCE() {
        return INSTANCE;
    }
}
