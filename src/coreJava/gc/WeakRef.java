package coreJava.gc;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;

public class WeakRef {

    public static void main(String[] args) {
        Object referrent = new Object();

        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();

        WeakReference weakReference1 = new WeakReference(referrent);
        WeakReference weakReference2 = new WeakReference(referrent, referenceQueue);

        Object referent2 = new Object();
        weakReference1.clear();

        Object referent3 = weakReference1.get();
        if (referent3 != null) {
//            GC hasn't removed this instance yet.
        } else {
//            GC cleared this instance
        }

    }
}

