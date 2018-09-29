package useRBTree;

class RedBlackNode
{
    RedBlackNode left, right;
    int element;
    int color;
    boolean isVisiable;

    public RedBlackNode(int theElement, RedBlackNode lt, RedBlackNode rt) {
        left = lt;
        right = rt;
        element = theElement;
        color = 1;
        isVisiable = true;
    }

    public RedBlackNode(int theElement) {
        this( theElement, null, null );
    }
}

