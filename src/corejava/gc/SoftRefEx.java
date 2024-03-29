package src.corejava.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;

public class SoftRefEx {

    public static void main(String[] args) {
        StringBuilder builder = new StringBuilder();
        SoftReference<StringBuilder> reference1 = new SoftReference<>(builder);
        ReferenceQueue<StringBuilder> referenceQueue = new ReferenceQueue<>();
        SoftReference<StringBuilder> reference2 = new SoftReference<>(builder, referenceQueue);

        StringBuilder builder1 = reference2.get();
        reference2.clear();
        StringBuilder builder2 = reference2.get();

        StringBuilder builder3 = reference2.get();
        if (builder3 != null) {
//            GC hasn't removed the instance yet
        } else {
//            GC has cleared the instance.
        }
    }
}
