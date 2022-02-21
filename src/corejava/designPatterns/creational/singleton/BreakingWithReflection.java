package src.corejava.designPatterns.creational.singleton;

import java.lang.reflect.Constructor;

public class BreakingWithReflection {

    public static void main(String[] args) {
        BillPughImplementation billPughImplementation = BillPughImplementation.getINSTANCE();
        BillPughImplementation billPughImplementation2 = null;

        EagerInitialisation eagerInitialisation = EagerInitialisation.getInstance();
        EagerInitialisation eagerInitialisation2 = null;

        LazyInitialisation lazyInitialisation = LazyInitialisation.getInstance();
        LazyInitialisation lazyInitialisation2 = null;

        StaticBlockInitialisation staticBlockInitialisation = StaticBlockInitialisation.getINSTANCE();
        StaticBlockInitialisation staticBlockInitialisation2 = null;

        try {
            Constructor[] billPughImplementationConstructors = BillPughImplementation.class.getConstructors();
            Constructor[] eagerInitialisationConstructors = EagerInitialisation.class.getConstructors();
            Constructor[] lazyInitialisationConstructors = LazyInitialisation.class.getConstructors();
            Constructor[] staticBlockInitialisationConstructors = StaticBlockInitialisation.class.getConstructors();
//
//            for (Constructor constructor:billPughImplementationConstructors) {
//                constructor.setAccessible(true);
//                billPughImplementation2 = BillPughImplementation.getINSTANCE();
//                break;
//            }
            for (Constructor constructor : eagerInitialisationConstructors) {
                constructor.setAccessible(true);
                eagerInitialisation2 = EagerInitialisation.getInstance();
                break;
            }
            for (Constructor constructor : lazyInitialisationConstructors) {
                constructor.setAccessible(true);
                lazyInitialisation2 = LazyInitialisation.getInstance();
                break;
            }
            for (Constructor constructor : staticBlockInitialisationConstructors) {
                constructor.setAccessible(true);
                staticBlockInitialisation2 = StaticBlockInitialisation.getINSTANCE();
                break;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("The hashcode of first instance of BillPughImplementation is " + billPughImplementation.hashCode());
        System.out.println("The hashcode of second instance of BillPughImplementation is " + billPughImplementation2.hashCode());
        System.out.println("The hashcode of first instance of EagerInitialisation is " + eagerInitialisation.hashCode());
        System.out.println("The hashcode of second instance of EagerInitialisation is " + eagerInitialisation2.hashCode());
        System.out.println("The hashcode of first instance of LazyInitialisation is " + lazyInitialisation.hashCode());
        System.out.println("The hashcode of second instance of LazyInitialisation is " + lazyInitialisation2.hashCode());
        System.out.println("The hashcode of first instance of StaticBlockInitialisation is " + staticBlockInitialisation.hashCode());
        System.out.println("The hashcode of second instance of StaticBlockInitialisation is " + staticBlockInitialisation2.hashCode());
    }


}
