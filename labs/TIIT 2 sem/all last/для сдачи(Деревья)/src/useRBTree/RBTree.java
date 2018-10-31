package useRBTree;

public class RBTree
{
    private RedBlackNode current;
    private RedBlackNode parent;
    private RedBlackNode grand;
    private RedBlackNode great;
    private RedBlackNode header;
    private static RedBlackNode nullNode;

    static {
        nullNode = new RedBlackNode(0);
        nullNode.left = nullNode;
        nullNode.right = nullNode;
    }
    static final int BLACK = 1;
    static final int RED   = 0;

    public RBTree(int negInf) {
        header = new RedBlackNode(negInf);
        header.left = nullNode;
        header.right = nullNode;
    }

    public void insert(int item ) {
        current = parent = grand = header;
        nullNode.element = item;
        while(current.element != item){
            great = grand;
            grand = parent;
            parent = current;
            current = item < current.element ? current.left : current.right;
            // Если оба красные то вертим
            if (current.left.color == RED && current.right.color == RED)
                handleReorient( item );
        }
        // Если такой элемент уже есть то ...
        if (current != nullNode) {
            current.isVisiable = true;
            return;
        }
        current = new RedBlackNode(item, nullNode, nullNode);
        // Если нет, то добавим
        if (item < parent.element)
            parent.left = current;
        else
            parent.right = current;
        handleReorient(item);
    }

    private void handleReorient(int item) {
        current.color = RED;
        current.left.color = BLACK;
        current.right.color = BLACK;

        if (parent.color == RED)
        {
            grand.color = RED;
            if (item < grand.element != item < parent.element) {
                parent = rotate(item, grand);  // доп поворот для внутреннего внука))
            }
            current = rotate(item, great);
            current.color = BLACK;
        }
        header.right.color = BLACK;
    }

    private RedBlackNode rotate(int item, RedBlackNode parent) {
        if(item < parent.element) {
            return parent.left = item < parent.left.element ? rotateWithLeftChild(parent.left) : rotateWithRightChild(parent.left);
        }
        else {
            return parent.right = item < parent.right.element ? rotateWithLeftChild(parent.right) : rotateWithRightChild(parent.right);
        }
    }

    private RedBlackNode rotateWithLeftChild(RedBlackNode k2) {
        RedBlackNode k1 = k2.left;
        k2.left = k1.right;
        k1.right = k2;
        return k1;
    }
    private RedBlackNode rotateWithRightChild(RedBlackNode k1) {
        RedBlackNode k2 = k1.right;
        k1.right = k2.left;
        k2.left = k1;
        return k2;
    }

    public void makeEmpty() {
        header.right = nullNode;
    }

    public boolean search(int val) {
        return search(header.right, val);
    }
    private boolean search(RedBlackNode r, int val) {
        boolean found = false;
        while ((r != nullNode) && !found)
        {
            int rval = r.element;
            if (val < rval)
                r = r.left;
            else if (val > rval)
                r = r.right;
            else if(r.isVisiable) {
                found = true;
                break;
            }
            else{
                found = false;
                break;
            }
            found = search(r, val);
        }
        return found;
    }

    public int countNodes() {
        return countNodes(header.right);
    }
    private int countNodes(RedBlackNode r) {
        if (r == nullNode)
            return 0;
        else
        {
            int l = 0;
            if(r.isVisiable){
                l = 1;
            }
            l += countNodes(r.left);
            l += countNodes(r.right);
            return l;
        }
    }

    public void visualShow(){
        for(int i = 0; i<10; i++){
            System.out.print(i + "   ");
        }
        System.out.println("\n");
        visualShow(header.right, 0);
    }
    private void visualShow(RedBlackNode r, int level){
    if(r != nullNode){
        String str = "";
        visualShow(r.right, level + 1);
        for (int i=0; i<level;i++){str += "    ";}
        if(r.isVisiable){
            System.out.println(str + r.element);
        }
        else {
            System.out.println(str + "X");
        }
        visualShow(r.left, level + 1);
    }
}

    private class Dannie{
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int blijMin = Integer.MIN_VALUE;
        int blijMax = Integer.MAX_VALUE;
    }

    public int poiskMax(){
        Dannie dannie = new Dannie();
        poiskMax(header.right, dannie);
        return dannie.max;
    }
    private void poiskMax(RedBlackNode r, Dannie dannie){
        if(r != nullNode){
            poiskMax(r.right, dannie);
            if(r.element > dannie.max  && r.isVisiable){
                dannie.max = r.element;
            }
            poiskMax(r.left, dannie);
        }
    }

    public int poiskMin(){
        Dannie dannie = new Dannie();
        poiskMin(header.right, dannie);
        return  dannie.min;
    }
    private void poiskMin(RedBlackNode r, Dannie dannie){
        if(r != nullNode){
            poiskMin(r.left, dannie);
            if(r.element < dannie.min  && r.isVisiable){
                dannie.min = r.element;
            }
            poiskMin(r.right, dannie);
        }
    }

    public int blijMensh(int nomber){
        Dannie dannie = new Dannie();
        poisBlijZnach(header.right, dannie, nomber);
        if(dannie.blijMin == Integer.MIN_VALUE){
            return - 1;
        }
        return dannie.blijMin;
    }
    public int blijBolsh(int nomber){
        Dannie dannie = new Dannie();
        poisBlijZnach(header.right, dannie, nomber);
        if(dannie.blijMax == Integer.MAX_VALUE){
            return -1;
        }
        return dannie.blijMax;
    }
    private void poisBlijZnach(RedBlackNode r, Dannie dannie, int nomber){
        if(r != nullNode){
            poisBlijZnach(r.left, dannie, nomber);
            if((Math.abs(nomber - dannie.blijMin) > Math.abs(nomber - r.element) && r.element < nomber) && r.isVisiable){
               dannie.blijMin = r.element;
            }
            if((Math.abs(dannie.blijMax - nomber) > Math.abs(r.element - nomber) && r.element > nomber) && r.isVisiable){
                dannie.blijMax = r.element;
            }
            poisBlijZnach(r.right, dannie, nomber);
        }
    }

    public void remove(int del){
        remove(header.right, del);
    }
    private void remove(RedBlackNode r, int del){
        if(r != nullNode){
            if(r.element == del){
                r.isVisiable = false;
            }
            remove(r.right, del);
            remove(r.left, del);
        }
    }
}





















