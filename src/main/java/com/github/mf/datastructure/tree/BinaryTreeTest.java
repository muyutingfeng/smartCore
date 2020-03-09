package com.github.mf.datastructure.tree;

/**
 * 二叉树前中后序遍历、查找
 */
public class BinaryTreeTest {
    public static void main(String[] args) {
        HeroNode node1 = new HeroNode(1, "宋江");
        HeroNode node2 = new HeroNode(2, "吴用");
        HeroNode node3 = new HeroNode(3, "卢俊义");
        HeroNode node4 = new HeroNode(4, "林冲");

        HeroNode node5 = new HeroNode(5, "公孙胜");

        BinaryTree bt = new BinaryTree();
        bt.setRoot(node1);
        node1.setLeft(node2);
        node1.setRight(node3);
        node3.setRight(node4);
        node3.setLeft(node5);

        System.out.println("----------前序遍历----------");
        bt.preOrder();

        System.out.println("----------中序遍历----------");
        bt.inOrder();

        System.out.println("----------后序遍历----------");
        bt.postOrder();


        System.out.println("----------前序查找----------");
        HeroNode resNode = bt.preOrderSearch(5);
        if(resNode!=null){
            System.out.printf("已找到节点，no=%d,name=%s",resNode.getNo(),resNode.getName());
            System.out.println();
        }else{
            System.out.println("节点未找到");
        }

        System.out.println("----------中序查找----------");
        bt.inOrderSearch(5);
        if(resNode!=null){
            System.out.printf("已找到节点，no=%d,name=%s",resNode.getNo(),resNode.getName());
            System.out.println();
        }else{
            System.out.println("节点未找到");
        }

        System.out.println("----------后序查找----------");
        bt.postOrderSearch(5);
        if(resNode!=null){
            System.out.printf("已找到节点，no=%d,name=%s",resNode.getNo(),resNode.getName());
            System.out.println();
        }else{
            System.out.println("节点未找到");
        }
    }
}


class BinaryTree {
    private HeroNode root;

    public void setRoot(HeroNode root) {
        this.root = root;
    }


    //前序
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //中序
    public void inOrder() {
        if (this.root != null) {
            this.root.inOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }

    //后序
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空");
        }
    }


    //前序查找
    public HeroNode preOrderSearch(int no) {
        if (this.root != null) {
             return this.root.preOrderSearch(no);
        } else {
            return null;
        }
    }

    //中序查找
    public HeroNode inOrderSearch(int no) {
        if (this.root != null) {
            return root.inOrderSearch(no);
        } else {
            return null;
        }
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        if (this.root != null) {
            return this.root.postOrderSearch(no);
        } else {
            return null;
        }
    }


}

class HeroNode {
    private int no;
    private String name;
    private HeroNode left;
    private HeroNode right;

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HeroNode getLeft() {
        return left;
    }

    public void setLeft(HeroNode left) {
        this.left = left;
    }

    public HeroNode getRight() {
        return right;
    }

    public void setRight(HeroNode right) {
        this.right = right;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }


    //前序
    public void preOrder() {
        System.out.println(this);
        if (this.left != null) {
            this.left.preOrder();
        }
        if (this.right != null) {
            this.right.preOrder();
        }
    }

    //中序
    public void inOrder() {
        if (this.left != null) {
            this.left.inOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.inOrder();
        }
    }

    //后序
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }
        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);
    }


    //前序查找
    public HeroNode preOrderSearch(int no) {
        System.out.println("前序查找");
        if (this.no == no) {
            return this;
        }

        HeroNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.preOrderSearch(no);
            if (resultNode != null) {
                return resultNode;
            }
        }

        if (this.right != null) {
            resultNode = this.right.preOrderSearch(no);
        }
        return resultNode;
    }

    //中序查找
    public HeroNode inOrderSearch(int no) {
        HeroNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.inOrderSearch(no);
            if (resultNode != null) {
                return resultNode;
            }
        }
        System.out.println("中序查找");
        if (this.no == no) {
            return this;
        }

        if (this.right != null) {
            resultNode = this.right.inOrderSearch(no);
        }

        return resultNode;
    }

    //后序查找
    public HeroNode postOrderSearch(int no) {
        HeroNode resultNode = null;
        if (this.left != null) {
            resultNode = this.left.postOrderSearch(no);
            if (resultNode != null) {
                return resultNode;
            }
        }

        if (this.right != null) {
            resultNode = this.right.postOrderSearch(no);
            if (resultNode != null) {
                return resultNode;
            }
        }

        System.out.println("后序查找");
        if (this.no == no) {
            return this;
        }
        return resultNode;
    }
}
