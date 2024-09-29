package src.scaler.lld.crashCourse.generics;

public class Pair<L, R> {
    private R right;
    private L left;

    public Pair(R right, L left) {
        if(left == null || right == null){
            throw new NullValueException("Left and right values cannot be null");
        }
        this.right = right;
        this.left = left;
    }

    public R getRight() {
        return right;
    }


    public L getLeft() {
        return left;
    }
    public <L, R> Pair<R, L> swap(Pair<L, R> pair) {
        return (Pair<R, L>) new Pair<>(pair.getRight(), pair.getLeft());
    }

}
