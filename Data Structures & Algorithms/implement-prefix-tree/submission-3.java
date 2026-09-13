class Node {
    char data;
    List<Node> next;

    public Node(char data) {
        this.data = data;
        this.next = new ArrayList<>();
    }  
}

class PrefixTree {
    private Node root;    
    public PrefixTree() {
        root = new Node('0');
    }

    public void insert(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            Boolean found = false;
            for (Node node : temp.next) {
                if (node.data == curr) {
                    temp = node;
                    found = true;
                    break;
                }
            }

            if (found) {
                continue;
            }
            Node add = new Node(word.charAt(i));
            temp.next.add(add);
            for (Node node : temp.next) {
                System.out.print(node.data + " ");
            }
            System.out.println();
            temp = add;
        }

        Node end = new Node('1');
        temp.next.add(end);
    }

    public boolean search(String word) {
        Node temp = root;
        for (int i = 0; i < word.length(); i++) {
            char curr = word.charAt(i);
            boolean found = false;
            for (Node node : temp.next) {
                if (node.data == curr) {
                    temp = node;
                    found = true;
                }
            }

            if (!found) {
                return false;
            }
        }

        for (Node node : temp.next) {
            if (node.data == '1') {
                return true;
            }
        }

        return false;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (int i = 0; i < prefix.length(); i++) {
            char curr = prefix.charAt(i);
            boolean found = false;
            for (Node node : temp.next) {
                if (node.data == curr) {
                    temp = node;
                    found = true;
                    continue;
                }
            }

            if (!found) {
                return false;
            }
        }

        return true;
    }
}
