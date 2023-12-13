package com.nirmal.dsabean.constants;


public enum Topic {
    Array("Array"),
    Recursion("Recursion"),
    String("String"),
    SlidingWindow("Sliding Window"),
    Stack("Stack"),
    Tree("Tree"),
    BinarySearchTree("Binary Search Tree"),
    LinkedList("Linked List"),
    DoublyLinkedList("Doubly Linked List"),
    DynamicProgramming("Dynamic Programming"),
    Graph("Graph"),
    Trie("Trie"),
    Design("Design");

    private String topic;

    Topic(String value) {
        this.topic = value;
    }

    public String getTopic() {
        return topic;
    }
}
