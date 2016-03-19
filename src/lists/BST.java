package lists;

/**
 * Created by luben on 2016-03-17.
 */
public class BST<E extends Comparable<E>> {
    private static class Node<E> {
        private E data;
        private Node<E> left, rigth;

        public Node(E data) {
            this.data = data;
            left = rigth = null;
        }

        @Override
        public String toString() {
            return "" + data;
        }
    }

    private Node<E> root;
    private E deletedData;

    public BST() {
        this.root = null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("BST{");
        inOrder(root, sb);
        sb.append("}");
        return sb.toString();
    }

    private void inOrder(Node<E> node, StringBuilder sb) {
        if (node != null) {
            inOrder(node.left, sb);
            sb.append(", " + node);
            inOrder(node.rigth, sb);
        }
    }

    public boolean add(E data) {
        if (root == null) {
            root = new Node<E>(data);
            return true;
        }
        return add(data, root);
    }

    private boolean add(E data, Node<E> node) {
        if (data.compareTo(node.data) == 0) {
            return false;
        }
        if (data.compareTo(node.data) < 0) {
            if (node.left == null) {
                node.left = new Node<E>(data);
                return true;
            }
            return add(data, node.left);
        }
        if (node.rigth == null) {
            node.rigth = new Node<E>(data);
            return true;
        }
        return add(data, node.rigth);
    }

    public E find(E target) {
        return find(target, root);
    }

    private E find(E target, Node<E> node) {
        if (node != null) {
            return null;
        }
        if (target.compareTo(node.data) == 0) {
            return node.data;
        }
        if (target.compareTo(node.data) < 0) {
            return find(target, node.left);
        }
        return find(target, node.rigth);

    }

    public E remove(E target) {
//        return remove(target,root);

        if (root.data.compareTo(target) == 0) {//remove root
            E data = root.data;
            if (root.left == null) {
                if (root.rigth == null) {
                    root = null;
                } else {
                    root = root.rigth;
                }
            } else {
                if (root.rigth == null) {
                    root = root.left;
                } else {
//                    System.out.println("corrceomundo");
                    Node<E> tmp = root.rigth, pTmp = root;
                    while (tmp.left != null) {
                        pTmp = tmp;
                        tmp = tmp.left;
                    }
                    pTmp.left = tmp.rigth;
                    tmp.left = root.left;
                    tmp.rigth = root.rigth;
                    root = tmp;
                }
            }
            return data;
        } else if (target.compareTo(root.data) < 0) {
            return remove(target, root.left, root);
        }
        return remove(target, root.rigth, root);

    }


    private E remove(E target, Node<E> node, Node<E> parent) {
        if (target.compareTo(node.data) == 0) {
            //TODO remove
            if (node.left == null) {
                if (node.rigth == null) {//remove leaf
                    if (parent.left == node) {
                        parent.left = null;
                    } else {
                        parent.rigth = null;
                    }
                } else {//remove one subtree
                    if (parent.left == node) {
                        parent.left = node.rigth;
                    } else {
                        parent.rigth = node.rigth;
                    }
                }
            } else {
                if (node.rigth == null) {//remove the other subtree
                    if (parent.left == node) {
                        parent.left = node.left;
                    } else {
                        parent.rigth = node.left;
                    }
                } else {//TODO two subtrees
                    Node<E> tmp = node.rigth, tmpParent = root;
                    while (tmp.left != null) {
                        tmpParent = tmp;
                        tmp = tmp.left;
                    }
                    tmpParent.left = tmp.rigth;
                    tmp.left = node.left;
                    tmp.rigth = node.rigth;
                    if (parent.left == node) {
                        parent.left = tmp;
                    } else {
                        parent.rigth = tmp;
                    }
                }
            }
            return node.data;
        }
        if (target.compareTo(node.data) < 0) {
            return remove(target, node.left, node);
        }
        return remove(target, node.rigth, node);

    }

    public E delete(E target) {
        root = delete(target, root);
        return deletedData;
    }

    private Node<E> delete(E target, Node<E> node) {
        if (node == null) {
            deletedData = null;
            return null;
        }
        if (target.compareTo(node.data) < 0) {
            node.left = delete(target, node.left);
            return node;
        } else if (target.compareTo(node.data) > 0) {
            node.rigth = delete(target, node.rigth);
            return node;
        }
        deletedData = node.data;
        if (node.left == null) {
            return node.rigth;
        } else if (node.rigth == null) {
            return node.left;
        }
        Node<E> tmp = node.rigth, pTmp = node;
        if (tmp.left == null) {
//            pTmp=tmp;
            tmp.left = node.left;
            return tmp;
        }
        while (tmp.left != null) {
            pTmp = tmp;
            tmp = tmp.left;
        }
        pTmp.left = tmp.rigth;
        node.data = tmp.data;
        return node;
    }
}
