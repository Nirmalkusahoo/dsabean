package com.nirmal.dsabean.constants;


import com.nirmal.dsabean.dto.EnUserNameDto;

import java.util.ArrayList;
import java.util.List;

public enum Topic {
    Array("Array"),
    Recursion("Recursion"),
    String("String"),
    BinarySearch("Binary Search"),
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

    public static List<EnUserNameDto> getList() {
        List<EnUserNameDto> list = new ArrayList<>();
        for (Topic value : Topic.values()) {
            list.add(new EnUserNameDto(value.name(), value.getTopic()));
        }
        return list;
    }
}
