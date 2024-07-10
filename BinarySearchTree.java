/**
 * BinarySearchTree. Represent a binary search tree
 * The student cannot change the public interface
 *
 * @author Austin Howard
 * @version July 9, 2024
 */
public class BinarySearchTree<E extends Comparable<E>> {
    TreeNode<E> root; // the root of the tree

    /**
     * constructor create a empty binary search tree by setting root to be null
     */
    public BinarySearchTree() {
        this.root = null;
    }

    /**
     * search the given data in this binary search tree
     * If the data is found, return a reference to the tree node
     * othewise, return null
     * @param data The target to search
     * @return a TreeNode reference to the node that contains the data
     *         if no node contains data, return null
     */
    public TreeNode<E> search(E data) {
        return searchRecursive(root, data);
    }

    /**
     * Recursively searches for the given data in a BST
     *
     * @param node The current node being compared.
     * @param data The data being searched for.
     * @return A reference to the node that contains the data, or return null.
     */
    private TreeNode<E> searchRecursive(TreeNode<E> node, E data) {
        // If the current node is null or its data matches the target data
        if (node == null || data.compareTo(node.getData()) == 0) {
            return node;
        } else if (data.compareTo(node.getData()) < 0) {
            // If the target data is less than the current node's data, search the left subtree
            return searchRecursive(node.getLeft(), data);
        } else {
            // Search the right subtree
            return searchRecursive(node.getRight(), data);
        }
    }


    /**
     * insert given node to this binary search tree. If this tree
     * was empty, the given node becomes the root of this tree.
     * @param newNode the given node to be inserted
     */
    public void insert(TreeNode<E> newNode) {
        root = insertRecursive(root, newNode);
    }

    private TreeNode<E> insertRecursive(TreeNode<E> current, TreeNode<E> newNode) {
        // If current node is null, insert a new node and return it
        if (current == null) {
            return newNode;
        }

        if (newNode.getData().compareTo(current.getData()) < 0) {
            //Insert Node into the left subtree, set new parent reference
            current.setLeft(insertRecursive(current.getLeft(), newNode));
            current.getLeft().setParent(current);
        } else if (newNode.getData().compareTo(current.getData()) > 0) {
            //Insert Node into the right subtree, set new parent reference
            current.setRight(insertRecursive(current.getRight(), newNode));
            current.getRight().setParent(current);
        }
        return current;
    }

    /**
     * insert given data to this binary search tree. If this tree
     * was empty, the given node becomes the root of this tree.
     * @param data the given data to be inserted
     */
    public void insert(E data) {
        TreeNode<E> newNode = new TreeNode<>(data);
        insert(newNode);
    }

    /**
     * remove the given data from this binary search tree and return
     * true. If the data is not in the tree, return false
     */
    public boolean remove(E data) {
        if (search(data) == null) {
            return false;
        }
        root = removeRecursive(root, data);
        return true;
    }

    private TreeNode<E> removeRecursive(TreeNode<E> current, E data) {
        if (current == null) {
            return null;
        }

        // Check if current node is the node to delete
        if (data.compareTo(current.getData()) == 0) {

            if (current.getLeft() == null && current.getRight() == null) {
                // Remove node if the current node does not have children
                return null;
            } else if (current.getRight() == null) {
                // Node has only left child, replace the node with left child
                return current.getLeft();
            } else if (current.getLeft() == null) {
                // Node has only right child, replace the node with right child
                return current.getRight();
            } else {
                // Find the smallest value in the right subtree to replace the node's data
                E smallestValue = findSmallestValue(current.getRight());
                current.setData(smallestValue);
                current.setRight(removeRecursive(current.getRight(), smallestValue));

                return current;
            }

        }

        if (data.compareTo(current.getData()) < 0) {
            // Recursively remove from left subtree
            current.setLeft(removeRecursive(current.getLeft(), data));
        } else {
            // Recursively remove from right subtree
            current.setRight(removeRecursive(current.getRight(), data));
        }

        return current; // Return current node after deletion
    }


    private E findSmallestValue(TreeNode<E> root) {
        return root.getLeft() == null ? root.getData() : findSmallestValue(root.getLeft());
    }

    /**
     * return a string representation of the tree
     * @return a String representation of the tree
     */
    public String toString() {
        return "(" + nodeTraversal(root) + ")";
    }

    // Recursive string return through subtrees
    private String nodeTraversal(TreeNode<E> treeNode) {
        if (treeNode == null) {
            return "-";
        }
        return treeNode.getData().toString()
                + "(" + nodeTraversal(treeNode.getLeft())
                + "," + nodeTraversal(treeNode.getRight()) + ")";
    }

    /**
     * return true if the tree is empty. False otherwise
     * @return true if the tree is empty; false otherwise
     */
    public boolean isEmpty() {
        return root == null;
    }

    /**
     * return the height of the tree. Notice the height is defined as
     * the length of the longest path from nodes to root
     * @return the height of the tree
     */
    public int height() {
        return heightRecursive(root);
    }

    // Calculate and return the height of the subtrees
    private int heightRecursive(TreeNode<E> node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = heightRecursive(node.getLeft());
        int rightHeight = heightRecursive(node.getRight());

        // Add 1 to the total to account for the current node
        return Math.max(leftHeight, rightHeight) + 1;
    }

    /**
     * return the number of nodes in the tree
     * @return the number of nodes in this tree
     */
    public int size() {
        return sizeRecursive(root);
    }

    // Calculate the size of left and right subtrees,
    private int sizeRecursive(TreeNode<E> node) {
        if (node == null) {
            return 0;
        }

        // Add 1 to the total to account for the current node
        return sizeRecursive(node.getLeft()) + sizeRecursive(node.getRight()) + 1;
    }
}
