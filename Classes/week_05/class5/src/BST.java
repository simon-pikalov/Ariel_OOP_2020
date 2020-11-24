
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;

/**
 * This class represents a simple Binary Search Tree, it was implemented in Class 5
 * as a class example - may contains a lot of errors and untested methods!
 * @param <T>
 */
public class BST<T> {
    public static final int INORDER_SLOW=1, INORDER_FAST=2, PRETORDER_FAST=4, POSTTORDER_FAST=6;
    private int _mc;
    private BN<T> _root;  // inner class
    private Comparator<T> _comp;
    public static final  Comparator
            Natural_Order_By_ToString = BN_Comp.toStringIterator();
    public BST(Comparator<T> c) {
        _root = null;
        _mc = 0;
        _comp = c;
    }
    public BST() {this(Natural_Order_By_ToString);}
    public Comparator<T> getComparator() {return _comp;}
    public void setComparator(Comparator<T> c) {
        _comp = c;
        addMC();//
        // BUG a reorder of the BT is needed according to the new Comparator!
    }

    /**
     * This method removes all data from the BST.
     */
    public void clear() {_root = null;}
    public void add(T t) {
        if (t != null) {
            addMC();
            if (isEmpty()) {
                _root = new BN(t);
            } else {
                _root.add(t, _comp);
            }
        }
    }
    private void addMC() {_mc++;}
    public int getMC() {return _mc;}
    public Iterator<T> interator() {
        return interator(INORDER_FAST); }
    private Iterator<T> interator(int type) {
        ArrayList data = new ArrayList<T>();
        if (_root!=null) {
            if (type == INORDER_SLOW) {return new BST.SLOW_Inorder_Iterator();}
            if (type == POSTTORDER_FAST) { _root.fill_post(data); }
            if (type == PRETORDER_FAST) { _root.fill_pre(data); }
            if (type == INORDER_FAST) { _root.fill_io(data); }
        }
        return data.iterator();
    }
    private boolean isEmpty() {
        return _root ==null;
    }
    public int size() {
        if(isEmpty() ) {return 0;}
        return _root.size();
    }
    public int height() {
        if(isEmpty() ) {return -1;}
        return _root.height();
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
    private class SLOW_Inorder_Iterator implements Iterator<T> {
        private int _ind=0, _init_mc;
        public SLOW_Inorder_Iterator() {_ind = 0; _init_mc = _mc;}
        @Override
        public boolean hasNext() {
            if(_init_mc != _mc) { throw new RuntimeException("The BST was changed - invalid iterator");}
            return _ind < size();
        }
        @Override
        public T next() {
            if(_init_mc != _mc) { throw new RuntimeException("The BST was changed - invalid iterator");}
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
        private T getData() {return _data;};
        private BN getLeft() {return _left;}
        private BN getRight() {return _right;}
        private void setLeft(BN a) { _left=a;}
        private void setRight(BN a) { _right=a;}
        private boolean isLeaf() {return _left==null && _right==null;}
        private int size() {
            int l = 0, r = 0;
            if(this.getLeft()!=null) {l = this.getLeft().size();}
            if(this.getRight()!=null) {r = this.getRight().size();}
            return 1+l+r;
        }
        private int height() {
            int ans=0,l=-1,r=-1;
            if(this.getLeft()!=null) {l = this.getLeft().height();}
            if(this.getRight()!=null) {r = this.getRight().height();}
            return ans + Math.max(l+1, r+1);
        }
        private void add(T n, Comparator<T> comp) {
            int v = comp.compare( n,_data);
            if(v<=0) {
                if(this.getLeft()==null) {
                    this.setLeft(new BN(n)); }
                else { this.getLeft().add(n,_comp);}
            }
            else {
                if(this.getRight()==null) {
                    this.setRight(new BN(n)); }
                else { this.getRight().add(n,_comp);}
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
                        // i = 5, l = 2,
                        int ind = i-(l+1);
                        ans = _right.get(ind);
                    }
                }
            }
            return ans;
        }

        private void fill_io(ArrayList<T> data) {
            if(this.getLeft()!=null) {getLeft().fill_io(data);}
            data.add(this.getData());
            if(this.getRight()!=null) {getRight().fill_io(data);}
        }
        private void fill_pre(ArrayList<T> data) {
            data.add(this.getData());
            if(this.getLeft()!=null) {getLeft().fill_pre(data);}
            if(this.getRight()!=null) {getRight().fill_pre(data);}
        }
        private void fill_post(ArrayList<T> data) {
            if(this.getLeft()!=null) {getLeft().fill_post(data);}
            if(this.getRight()!=null) {getLeft().fill_post(data);}
            data.add(this.getData());
        }
    }

    private static class BN_Comp<T> implements Comparator<T> {
        private BN_Comp() {;}
        @Override
        public int compare(T o1, T o2) {
            String s1 = o1.toString();
            String s2 = o2.toString();
            return s1.compareTo(s2);
        }
        public static Comparator toStringIterator() {
            return new BN_Comp();
        }
    }
}
