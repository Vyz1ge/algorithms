package SkillTask6;

import java.util.ArrayList;

public class MyBinaryTree {

    private Node root;

    @Override
    public String toString() {
        String s = "";
        System.out.println("\n");
        System.out.println("\t\t\t\t\t\t\t\t\t\t\t" + (root.getValue() != 0 ? root.getValue() : "null") + "\n");
        System.out.println("\t\t\t\t\t\t\t" + (root.getLow() != null ? root.getLow().getValue() : "null") + "\t\t\t\t\t\t\t\t" + (root.getHigh() != null ? root.getHigh().getValue() : "null"));
        System.out.println("\n"
                + "\t\t\t\t\t"
                + (root.getLow() != null && root.getLow().getLow() != null && root.getLow().getLow().getValue() != 0 ? root.getLow().getLow().getValue() : "null") + "\t\t\t\t"
                + (root.getLow() != null && root.getLow().getHigh() != null && root.getLow().getHigh().getValue() != 0 ? root.getLow().getHigh().getValue() : "null") + "\t\t\t\t"
                + (root.getHigh() != null && root.getHigh().getLow() != null && root.getHigh().getLow().getValue() != 0 ? root.getHigh().getLow().getValue() : "null") + "\t\t\t\t"
                + (root.getHigh() != null && root.getHigh().getHigh() != null && root.getHigh().getHigh().getValue() != 0 ? root.getHigh().getHigh().getValue() : "null"));
        System.out.println("\n"
                + "\t\t\t\t"
                + (root.getLow() != null && root.getLow().getLow() != null && root.getLow().getLow().getLow() != null && root.getLow().getLow().getLow().getValue() != 0 ? root.getLow().getLow().getLow().getValue() : "null") + "\t"
                + (root.getLow() != null && root.getLow().getLow() != null && root.getLow().getLow().getHigh() != null && root.getLow().getLow().getHigh().getValue() != 0 ? root.getLow().getLow().getHigh().getValue() : "null") + "\t"
                + (root.getLow() != null && root.getLow().getHigh() != null && root.getLow().getHigh().getLow() != null && root.getLow().getHigh().getLow().getValue() != 0 ? root.getLow().getHigh().getLow().getValue() : "null") + "\t"
                + (root.getLow() != null && root.getLow().getHigh() != null && root.getLow().getHigh().getHigh() != null && root.getLow().getHigh().getHigh().getValue() != 0 ? root.getLow().getHigh().getHigh().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getLow() != null && root.getHigh().getLow().getLow() != null && root.getHigh().getLow().getLow().getValue() != 0 ? root.getHigh().getLow().getLow().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getLow() != null && root.getHigh().getLow().getHigh() != null && root.getHigh().getLow().getHigh().getValue() != 0 ? root.getHigh().getLow().getHigh().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getHigh() != null && root.getHigh().getHigh().getLow() != null && root.getHigh().getHigh().getLow().getValue() != 0 ? root.getHigh().getHigh().getLow().getValue() : "null") + "\t"
                + (root.getHigh() != null && root.getHigh().getHigh() != null && root.getHigh().getHigh().getHigh() != null && root.getHigh().getHigh().getHigh().getValue() != 0 ? root.getHigh().getHigh().getHigh().getValue() : "null")
        );
        return s;
    }

    public MyBinaryTree() {
        root = null;
    }

    public void add(int value) {
        if (root == null) {
            root = new Node(value, null);
        }
        add(value, root);
    }

    public void add(int value, Node v) {
        if (root == null) {
            return;
        }
        if (value > v.getValue()) {
            if (v.getHigh() == null) {
                v.setHigh(new Node(value, v));
                return;
            }
            add(value, v.getHigh());
        } else {
            if (v.getLow() == null) {
                v.setLow(new Node(value, v));
                return;
            }
            add(value, v.getLow());
        }
    }

    public MyBinaryTree fromArray(ArrayList<Integer> list) {
        MyBinaryTree myBinaryTree = new MyBinaryTree();
        myBinaryTree.root = fromArray(list, 0, list.size());
        return myBinaryTree;
    }

    public Node fromArray(ArrayList<Integer> list, int low, int high) {
        if (low + 1 > high) {
            return null;
        }
        if (low + 1 == high) {
            return new Node(list.get(low), null);//root ??
        }
        int middle = (low + high) / 2;
        Node t = new Node(list.get(middle), null);
        t.setLow(fromArray(list, low, middle));
        t.setHigh(fromArray(list, middle + 1, high));
        if (t.getLow() != null) {
            t.getLow().setParent(t);
        }
        if (t.getHigh() != null) {
            t.getHigh().setParent(t);
        }
        return t;
    }

    public Node find(int value) {
        if (root == null) {
            return null;
        }
        Node t = find(value, root);
        return t;
    }

    public Node find(int value, Node t) {
        if (t == null) {
            return null;
        }
        if (value == t.getValue()) {
            return t;
        }
        if (value > t.getValue()) {
            return find(value, t.getHigh());
        } else {
            return find(value, t.getLow());
        }
    }

    public void delete(int value) {
        if (root == null) {
            return;
        }
        Node t = find(value);
        if (t == null) {
            return;
        }
        delete(t);
    }

    public void delete(Node t) {
        if (t == null) {
            return;
        }
        if ((t.getLow() == null) || (t.getHigh() == null)) {
            Node child = null;
            if (t.getLow() != null) {
                child = t.getLow();
            } else {
                child = t.getHigh();
            }
            if (t == root) {//??
                root.setValue(child.getValue());//??
                if (child != null) {//??
                    child.setParent(null);//??
                }//??
            }
            if (t.getParent().getLow() == t) {
                t.getParent().setLow(child);
                if (child != null) {
                    child.setParent(t.getParent());
                }
            } else {
                t.getParent().setHigh(child);
                if (child != null) {
                    child.setParent(t.getParent());
                }
            }
        } else {
            Node nxt = t.getHigh();
            while (nxt.getLow() != null) {
                nxt = nxt.getLow();
            }
            t.setValue(nxt.getValue());
            delete(nxt);
        }
    }

    public Node next(int value) {
        if (root == null) {
            return null;
        }
        Node v = find(value);
        if (v == null) {
            return null;
        }
        return next(v);
    }

    public Node next(Node v) {
        if (v == null) {
            return null;
        }
        if (v.getHigh() != null) {
            Node nxt = v.getHigh();
            while (nxt.getLow() != null) {
                nxt = nxt.getLow();
            }
            return nxt;
        }
        Node t = v;
        while ((t.getParent().getHigh() == t) && (t.getParent() != null)) {
            t = t.getParent();
        }
        return t.getParent();

    }

    public void print() {
        if (root == null) {
            return;
        }
        print(root);
    }

    public void print(Node v) {
        if (v == null) {
            return;
        }
        print(v.getLow());
        System.out.println(v.getValue());
        print(v.getHigh());
    }

    public boolean chek() {
        return chek(root, null, null);
    }

    public boolean chek(Node v, Integer low, Integer high) {
        if (v == null) {
            return true;
        }
        if ((low != null) && (v.getValue() < low)) {
            return false;
        }
        if ((high != null) && (v.getValue() > high)) {
            return false;
        }
        return chek(v.getLow(), low, v.getValue()) && chek(v.getHigh(), v.getValue(), high);
    }
}

class Node {
    private Node parent;
    private Node high;
    private Node low;
    private int value;

    public Node(int value, Node parent) {
        this.parent = parent;
        this.value = value;
        this.low = null;
        this.high = null;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public Node getHigh() {
        return high;
    }

    public void setHigh(Node high) {
        this.high = high;
    }

    public Node getLow() {
        return low;
    }

    public void setLow(Node low) {
        this.low = low;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}