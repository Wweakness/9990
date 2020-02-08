import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tree {
    public static Node buildTree() {
        Node a = new Node('A');
        Node b = new Node('B');
        Node c = new Node('C');
        Node d = new Node('D');
        Node e = new Node('E');
        Node f = new Node('F');
        Node g = new Node('G');
        Node h = new Node('H');

        a.left = b; a.right = c;
        b.left = d; b.right = e;
        c.left = f; c.right = g;
        d.left = null; d.right = null;
        e.left = null; e.right = h;
        f.left = null; f.right = null;
        g.left = null; g.right = null;
        h.left = null; h.right = null;

        return a;
    }


    public static List<Character> preOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Character> list = new ArrayList<>();
        List<Character> leftPreOrder = preOrder(root.left);
        List<Character> rightPreOrder = preOrder(root.right);
        list.add(root.value);
        list.addAll(leftPreOrder);
        list.addAll(rightPreOrder);
        return list;
    }

    public static void preOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        // 根 + 左子树 + 右子树
        System.out.println(root.value);
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }
    public static void inOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        // 左子树 + 根 + 右子树
        inOrderTraversal(root.left);
        System.out.println(root.value);
        inOrderTraversal(root.right);
    }

    public static void postOrderTraversal(Node root) {
        if (root == null) {
            return;
        }

        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.println(root.value);
    }
    //计算总结点个数方法一：
    public static  int count = 0;
    public static void calcCount(Node root) {
        if (root == null) {
            return;
        }
        count++;
        calcCount(root.left);
        calcCount(root.right);
    }
    //计算总结点个数方法二：
    public static int calcCount2(Node root) {
        if (root == null) {
            return 0;
        }
        int left = calcCount2(root.left);
        int right = calcCount2(root.right);
        int count = left + right + 1;
        return count;
    }

    public static int leafCount = 0;
    //计算叶子结点方法一：
    public static int calcLeafCount(Node root) {
        if (root == null) {
            return count;
        }

        calcLeafCount(root.left);
        // 代表是叶子结点
        if (root.left == null && root.right == null) {
            leafCount++;
        }
        calcLeafCount(root.right);
        return count;
    }
    //计算叶子结点方法二：
    public static int calcLeafCount2(Node root) {
        if (root == null) {
            return 0;
        }

        // 代表只有一个结点的树
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = calcLeafCount2(root.left);
        int right = calcLeafCount2(root.right);
        return left + right;
    }
    //计算二叉树高度
    public static int calcHeight(Node root) {
        if (root == null) {
            return 0;
        }

        int left = calcHeight(root.left);
        int right = calcHeight(root.right);
        int height = Math.max(left, right) + 1;
        return height;
    }
    //计算第k层结点个数
    public static int calcKLevel(Node root, int k) {
        if (root == null) {
            return 0;
        }

        if (k == 1) {
            return 1;
        }

        int left = calcKLevel(root.left, k - 1);
        int right = calcKLevel(root.right, k - 1);
        int count = left + right;

        return count;
    }
    //查找某一值
    public static Node search(Node root, char val) {
        if (root == null) {
            return null;
        }
        if (root.value == val) {
            return root;
        }
        Node left = search(root.left, val);
        if (left != null) {
            return left;
        }
        Node right = search(root.right, val);
        if (right != null) {
            return right;
        }
        return null;
    }
    //判断是否是镜像二叉树
    public static boolean isMirror(Node p, Node q) {
        if (p == null && q == null) {
            return true;
        }

        if (p == null || q == null) {
            return false;
        }

        return p.value == q.value
                && isMirror(p.left, q.right)
                && isMirror(p.right, q.left);
    }

    // 前序 + 中序
    public static Node buildTree1(List<Character> preorder, List<Character> inorder) {
        if (preorder.size() == 0) {
            return null;
        }
        char rootValue = preorder.get(0);
        int leftCount = inorder.indexOf(rootValue);
        Node root = new Node(rootValue);
        List<Character> leftPreorder = preorder.subList(1, 1 + leftCount);
        List<Character> leftInorder = inorder.subList(0, leftCount);
        Node left = buildTree1(leftPreorder, leftInorder);
        root.left = left;
        List<Character> rightPreorder = preorder.subList(1 + leftCount, preorder.size());
        List<Character> rightInorder = inorder.subList(leftCount + 1, inorder.size());
        Node right = buildTree1(rightPreorder, rightInorder);
        root.right = right;
        return root;
    }

    public static void buildTree2(List<Character> inorder, List<Character> postorder) {
    }

    public static void main(String[] args) {
        List<Character> preorder = Arrays.asList('A', 'B', 'D', 'E', 'G', 'C', 'F', 'H');
        List<Character> inorder = Arrays.asList('D', 'B', 'G', 'E', 'A', 'C', 'F', 'H');
        Node root = buildTree1(preorder, inorder);
        System.out.println("成功");
    }
}
