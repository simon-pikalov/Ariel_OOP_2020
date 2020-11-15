import java.util.Comparator;
import java.util.Iterator;

/**
 * This class represents a simple Binary Search Tree, it was implemented in Class 5
 * as a class example - may contains alot of errors and untested methods!
 * @param <T>
 */
public class BST<T> {
    private BN<T> _root;  // inner class
    private Comparator<T> _comp;
    public static final Comparator
            Natural_Order_By_ToString = new BN_Comp();
    public BST(Comparator<T> c) {
        _root = null;
        _comp = c;
    }
    public BST() {this(Natural_Order_By_ToString);}
    public Comparator<T> getComparator() {return _comp;}
    public void add(T t) {
        if(isEmpty() ) {_root = new BN(t);}
        else { _root.add(t,_comp);}
    }
    public Iterator<T> interator() {
        return new BST.BST_IO_Iterator();
    }
    private boolean isEmpty() {
        return _root ==null;
    }

    public int size() {
        if(isEmpty() ) {return 0;}
        return _root.size();
    }

    /**
     * This method computes the i"th value as In-Order.
     * @param i
     * @return
     */
    public T get(int i) {
        T ans = null;
        if(!isEmpty() && i>=0 && i<size()) {
            ans = _root.get(i);
        }
        return ans;
    }
    private class BST_IO_Iterator implements Iterator<T> {
        private int _ind=0;
        public BST_IO_Iterator() {_ind = 0;}
        @Override
        public boolean hasNext() {
            return _ind < size();  // needs some thinking
        }
        @Override
        public T next() {
            T ans = get(_ind);
            _ind++;
            return ans;
        }
    }

    /**
     * Inner (private) Binary Search Tree Node
     * @param <T>
     */
    private class BN<T> {
        private BN<T> _left, _right;
        private T _data;

        private BN(T v) {
            _data = v;
            _left = null;
            _right = null;
        }
        public T getData() {return _data;};
        public BN getLeft() {return _left;}
        public BN getRight() {return _right;}
        public void setLeft(BN a) { _left=a;}
        public void setRight(BN a) { _right=a;}
        public boolean isLeaf() {return _left==null && _right==null;}
        public int size() {
            int l = 0, r = 0;
            if(this.getLeft()!=null) {l = this.getLeft().size();}
            if(this.getRight()!=null) {r = this.getRight().size();}
            return 1+l+r;
        }
        private void add(T n, Comparator<T> comp) {
            int v = comp.compare( n,_data);
            if(v<=0) {
                if(this.getLeft()==null) {
                    this.setLeft(new BN(n)); }
                else { this.getLeft().add(n,comp);}
            }
            else {
                if(this.getRight()==null) {
                    this.setRight(new BN(n)); }
                else { this.getRight().add(n,comp);}
            }
        }
        private T get(int i) {
            T ans = null;
            if(i>=0 && i<size()) {
                int l = 0;
                if(this.getLeft()!=null) {l =this.getLeft().size();}
                if(l==i) {ans =this.getData();}
                else {
                    if(l>i) {
                        ans = _left.get(i);
                    }
                    else {  // i-(l+1)
                        int ind = i-(l+1);
                        ans = _right.get(ind);
                    }
                }
            }
            return ans;
        }

    }

    public static class BN_Comp<T> implements Comparator<T> {
        private BN_Comp() {
            ;
        }
        @Override
        public int compare(T o1, T o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            return s1.compareTo(s2);
        }
    }
}
