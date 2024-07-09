
/**
 * class TreeNode. This is a TreeNode. The students should understand the structure of a binary tree node
 *
 * @author Your Name
 * @version Date Start
 */
public class TreeNode<E extends Comparable<E>>
{
    E data;
    TreeNode<E> parent;
    TreeNode<E> left;
    TreeNode<E> right;

    /**
     * constructor construct a tree node with every field as null
     */
    public TreeNode()
    {

    }

    /**
     * constructor construct a tree node with all node referece null to hold given data
     * @param data The given data of type E
     */
    public TreeNode(E data)
    {
    }

    /**
     * set this node's data as given data
     * @param data The given data of type E
     */
    public void setData(E data)
    {
    }

    /**
     * get this node's data
     * @return the node's data of type E
     */
    public E getData()
    {
        return null;
    }

    /**
     * set this node's parent node as given node
     * @param parent The given node 
     */
    public void setParent(TreeNode<E> parent)
    {
    }

    /**
     * get this node's parent node
     * @return the node's parent node
     */
    public TreeNode<E> getParent()
    {
        return null;
    }

    /**
     * set this node's left child node as given node
     * @param left The given node 
     */
    public void setLeft(TreeNode<E> left)
    {
    }

    /**
     * get this node's left child node
     * @return the node's left child node
     */
    public TreeNode<E> getLeft()
    {
        return null;
    }

    /**
     * set this node's right child node as given node
     * @param right The given node 
     */
    public void setRight(TreeNode<E> right)
    {
    }

    /**
     * get this node's right child node
     * @return the node's right child node
     */
    public TreeNode<E> getRight()
    {
        return null;
    }

    /**
     * check if this node is the left child of its parent
     * @return true if this node is the left child of its parent; false otherwise.
     * If this node is root, i.e. it has no parent, it also return false
     */
    public boolean isLeftChild(){

        return false;
    }

    /**
     * check if this node is the right child of its parent
     * @return true if this node is the right child of its parent; false otherwise.
     * If this node is root, i.e. it has no parent, it also return false
     */
    public boolean isRightChild(){

        return false;
    }

    /**
     * check if this node is a leaf
     * @return true if this node is a leaf; false otherwise.
     */
    public boolean isLeaf(){

        return false;
    }

    /**
     * check if this node is a root
     * @return true if this node is a root; false otherwise.
     */
    public boolean isRoot(){

        return false;
    }
}