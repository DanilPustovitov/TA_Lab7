package com.company;

public class BTree {
    public Node root; // Pointer to root node
    public int t; // Minimum degree

    // Constructor (Initializes tree as empty)
    public BTree(int t) {
        this.root = null;
        this.t = t;
    }

    // function to traverse the tree
    public void traverse() {
        if (this.root != null)
            this.root.traverse();
        System.out.println();
    }

    // function to search a key in this tree
    // Check if present

    private Node Search(Node x, int key) {
        int i = 0;
        if (x == null)
            return x;
        for (i = 0; i < x.n; i++) {
            if (key < x.keys[i]) {
                break;
            }
            if (key == x.keys[i]) {
                return x;
            }
        }
        if (x.leaf) {
            return null;
        } else {
            return Search(x.C[i], key);
        }
    }


    public boolean Contain(int k) {
        if (this.Search(root, k) != null) {
            return true;
        } else {
            return false;
        }
    }

    public void insert(int k){
        if (root == null)
        {
            // Allocate memory for root
            root = new Node(t, true);
            root.keys[0] = k;  // Insert key
            root.n = 1;  // Update number of keys in root
        }
        else // If tree is not empty
        {
            // If root is full, then tree grows in height
            if (root.n == 2*t-1)
            {
                // Allocate memory for new root
                Node s = new Node(t, false);

                // Make old root as child of new root
                s.C[0] = root;

                // Split the old root and move 1 key to the new root
                s.splitChild(0, root);

                // New root has two children now.  Decide which of the
                // two children is going to have new key
                int i = 0;
                if (s.keys[0] < k)
                    i++;
                s.C[i].insertNonFull(k);

                // Change root
                root = s;
            }
            else  // If root is not full, call insertNonFull for root
                root.insertNonFull(k);
        }
    }

    void remove(int k)
    {
        if (root==null)
        {
            System.out.println("tree is empty!");
            return;
        }

        // Call the remove function for root
        root.remove(k);

        // If the root node has 0 keys, make its first child as the new root
        //  if it has a child, otherwise set root as NULL
        if (root.n==0)
        {
            Node tmp = root;
            if (root.leaf)
            root = null;
        else
            root = root.C[0];

        }

    }

}
