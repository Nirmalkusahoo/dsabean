package com.nirmal.dsabean.constants;


import com.nirmal.dsabean.dto.TopicDto;

import java.util.ArrayList;
import java.util.List;

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

    public static List<TopicDto> getList() {
        List<TopicDto> list = new ArrayList<>();
        for (Topic value : Topic.values()) {
            list.add(new TopicDto(value.name(), value.getTopic()));
        }
        return list;
    }
}
